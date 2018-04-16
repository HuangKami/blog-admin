package com.kami.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.Privilege;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.model.Roleprivilege;
import com.kami.blog.service.PrivilegeService;
import com.kami.blog.service.RoleprivilegeService;


@Controller
@RequestMapping("/rolePrivilege")
public class RolePrivilegeController {
	@Autowired
	private RoleprivilegeService roleprivilegeService;
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping
	public String list() {
		return "rolePrivilege";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<Roleprivilege> list(Model model, QueryCondition queryCondition) {
		return roleprivilegeService.getData(queryCondition);
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public List<Privilege> select(Model model) {
		return privilegeService.selectPrivilege(null);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addRolePrivilege(Roleprivilege rolePrivilege) {
		if(rolePrivilege.getRoleId() == 0) {
			return "error";
		}
		roleprivilegeService.insertRoleprivilege(rolePrivilege);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRolePrivilege(Roleprivilege rolePrivilege) {
		roleprivilegeService.deleteRoleprivilegeById(rolePrivilege.getId());
		return "success";
	}
}
