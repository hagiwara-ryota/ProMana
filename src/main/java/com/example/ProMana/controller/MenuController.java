package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProMana.entity.Lines;
import com.example.ProMana.repository.LinesRepository;

@Controller
public class MenuController {

	@Autowired
	LinesRepository linesRepository;

	@GetMapping("/menus/index")
	public String index() {
		return "menus/index";
	}

	@GetMapping("/lines/index")
	public String linesIndex(Model model) {
		List<Lines> linesList = linesRepository.findAll();
		model.addAttribute("lines", linesList);
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
