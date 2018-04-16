package com.kami.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kami.blog.model.DatatablesView;
import com.kami.blog.model.Privilege;
import com.kami.blog.model.QueryCondition;
import com.kami.blog.service.PrivilegeService;


@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;
	
	@RequestMapping
	public String list() {
		return "privilege";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public DatatablesView<Privilege> list(Model model, QueryCondition queryCondition) {
		return privilegeService.getData(queryCondition);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String addPrivilege(Privilege privilege) {
		privilegeService.insertPrivilege(privilege);
		return "success";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String updatePrivilege(Privilege privilege) {
		privilegeService.updateNonEmptyPrivilegeById(privilege);
		return "success";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deletePrivilege(Privilege privilege) {
		privilegeService.deletePrivilegeById(privilege.getId());
		return "success";
	}
}
