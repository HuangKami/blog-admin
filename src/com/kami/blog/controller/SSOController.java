package com.kami.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kami.blog.model.User;
import com.kami.blog.util.CookieHelper;
import com.kami.blog.util.KeyHelper;
import com.kami.blog.util.SessionHelper;

@Controller
@RequestMapping("/sso")
public class SSOController {
	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@RequestMapping
	public String sso(HttpServletRequest request) {
		String token = CookieHelper.getCookieValue(request, KeyHelper.TOKEN);
		User user = redisTemplate.opsForValue().get(token);
		if(user != null) {
			SessionHelper.setAttribute(request, KeyHelper.USER, user);
			SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getName(), user.getPassword()));  
		}
		return "redirect:main";
	}
}
