package com.kami.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kami.blog.util.StringHelper;

@Controller
@RequestMapping("/main")
public class MainController {

	@RequestMapping
	public String index(String table, String userId, String roleId, Model model) {
		if(StringHelper.isNotEmpty(table)) {
			if(StringHelper.equals("userRole", table) && StringHelper.isNotEmpty(userId)) {
				model.addAttribute("userId", userId);
			} else if(StringHelper.equals("rolePrivilege", table) && StringHelper.isNotEmpty(roleId)) {
				model.addAttribute("roleId", roleId);
			}
			model.addAttribute("table", table);
		} else {
			model.addAttribute("table", "index");
		}
		return "main";
	}
}
