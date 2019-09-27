package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/")
	public String showpage() {
		return "welcome";
	}

	
	
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
