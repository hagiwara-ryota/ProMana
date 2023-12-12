package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProMana.entity.Line;
import com.example.ProMana.repository.LinesRepository;
import com.example.ProMana.repository.ProducedCaseCountRepository;

@Controller
public class MenuController {

	@Autowired
	LinesRepository linesRepository;

	@Autowired
	ProducedCaseCountRepository producedCaseCountRepository;

	@GetMapping("/menus/index")
	public String index() {
		return "menus/index";
	}

	@GetMapping("/lines/index")
	public String linesIndex(Model model) {
		List<Line> linesList = linesRepository.findAll();
		model.addAttribute("lines", linesList);
		return "lines/index";
	}

	@GetMapping("/plans/index")
	public String plansIndex(Model model) {
		List<Line> linesList = linesRepository.findLinesWithPlan();
		model.addAttribute("lines", linesList);
		return "plans/index";
	}

	

}
