package com.example.ProMana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/menus/index")
	public String index() {
		return "menus/index";
	}

	@GetMapping("/lines/index")
	public String linesIndex() {
		return "lines/index";
	}

	@GetMapping("/plans/index")
	public String plansindex() {
		return "menus/index";
	}

	@GetMapping("/produced_case_counts/index")
	public String produced_case_countsIndex() {
		return "menus/index";
	}
}
