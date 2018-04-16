package com.kami.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/unAuthorized")
public class UnAuthorizedController {
	public String unAuthorized() {
		return "403";
	}
}
