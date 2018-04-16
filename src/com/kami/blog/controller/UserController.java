package com.kami.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.User;
import com.kami.blog.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String list() {
		return "user";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<User> list(Model model, QueryCondition queryCondition) {
		return userService.getData(queryCondition);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUser(User user) {
		userService.insertUser(user);
		return "success";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(User user) {
		userService.updateNonEmptyUserById(user);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteUser(User user) {
		userService.deleteUserById(user.getId());
		return "success";
	}
}
