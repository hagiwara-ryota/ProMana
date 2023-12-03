package com.example.ProMana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LinesController {

	@GetMapping("/lines/new")
	public String create() {
		return "lines/new";
	}
}
