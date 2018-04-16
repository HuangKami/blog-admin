package com.kami.blog.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kami.blog.common.Assist;
import com.kami.blog.model.User;
import com.kami.blog.service.UserService;
import com.kami.blog.util.CookieHelper;
import com.kami.blog.util.KeyHelper;
import com.kami.blog.util.MD5Helper;
import com.kami.blog.util.SessionHelper;
import com.kami.blog.util.StringHelper;
import com.kami.blog.util.UUIDHelper;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping
	public String index() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response,
			User user, Model model) {
		if(StringHelper.isEmpty(user.getName()) || StringHelper.isEmpty(user.getPassword())) {
			model.addAttribute(KeyHelper.ERROR, "用户名或密码不能为空");
			return "login";
		}
		Assist assist = new Assist();
		assist.setRequires(Assist.orEq("name", user.getName())).setRequires(Assist.orEq("email", user.getName()));
		List<User> users = userService.selectUser(assist);
		if(users == null || users.size() == 0) {
			model.addAttribute(KeyHelper.ERROR, "用户名或邮箱不存在");
			return "login";
		}
		User user2 = users.get(0);
		if(!StringHelper.equals(MD5Helper.md5(user.getPassword()), user2.getPassword())) {
			model.addAttribute(KeyHelper.ERROR, "密码不正确");
			return "login";
		}
		if(!user2.isAdmin()) {
			model.addAttribute(KeyHelper.ERROR, "权限不足");
			return "login";
		}
		SessionHelper.setAttribute(request, KeyHelper.USER, user2);
		String token = "kami-" + UUIDHelper.getUUID();
		CookieHelper.addCookie(response, KeyHelper.TOKEN, token);
		redisTemplate.opsForValue().set(token, user2);
		redisTemplate.expire(token, 300, TimeUnit.SECONDS);
		SecurityUtils.getSubject().login(new UsernamePasswordToken(user2.getName(), user2.getPassword()));  
		return "redirect:/main";
	}
	
	@RequestMapping("/toPortal")
	public void toPortal(HttpServletResponse response) {
		try {
			response.sendRedirect(KeyHelper.URL + "/sso");
		} catch (IOException e) {
			logger.error(e, e);
		}
	}
	
	/**
	 * 用户请求注销
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		SessionHelper.removeAttribute(request, KeyHelper.USER);
		return "redirect:/main";
	}
	
}
