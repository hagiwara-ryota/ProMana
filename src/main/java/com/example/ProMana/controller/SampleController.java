package com.example.ProMana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SampleController {

	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("message", "Hello, World!");
		return "pages/index";
	}
}
