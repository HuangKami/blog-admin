package com.kami.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Role;
import com.kami.blog.model.Userrole;
import com.kami.blog.service.RoleService;
import com.kami.blog.service.UserroleService;
import com.kami.blog.util.StringHelper;


@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	@Autowired
	private UserroleService userroleService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping
	public String list() {
		return "userRole";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<Userrole> list(Model model, QueryCondition queryCondition) {
		return userroleService.getData(queryCondition);
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Role> select(Model model) {
		return roleService.selectRole(null);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUserrole(Userrole role) {
		if(StringHelper.isEmpty(role.getUserId())) {
			return "error";
		}
		userroleService.insertUserrole(role);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteUserrole(Userrole role) {
		userroleService.deleteUserroleById(role.getId());
		return "success";
	}
}
