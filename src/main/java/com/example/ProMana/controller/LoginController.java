package com.example.ProMana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/")
	public String login(Model model) {
		return "login/loginHome";
	}

	@GetMapping("/login/account")
	public String showAccountPage(Model model) {
	    return "login/account";
	}

}
