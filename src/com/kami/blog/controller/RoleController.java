package com.kami.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Role;
import com.kami.blog.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping
	public String list() {
		return "role";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<Role> list(Model model, QueryCondition queryCondition) {
		return roleService.getData(queryCondition);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addRole(Role role) {
		roleService.insertRole(role);
		return "success";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateRole(Role role) {
		roleService.updateNonEmptyRoleById(role);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRole(Role role) {
		roleService.deleteRoleById(role.getId());
		return "success";
	}
}
