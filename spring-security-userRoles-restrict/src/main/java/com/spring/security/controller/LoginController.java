package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showLoginPage")
	public String showPage() {
		return"fancy-login";
	}
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return"access-denied";
	}
	

}
