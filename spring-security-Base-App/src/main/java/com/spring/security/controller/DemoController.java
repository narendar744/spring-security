package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/welcome")
	public String showpage() {
		return "welcome";
	}

}
