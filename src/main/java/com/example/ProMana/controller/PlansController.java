package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProMana.Service.LinesService;
import com.example.ProMana.Service.PlansService;
import com.example.ProMana.entity.Line;
import com.example.ProMana.form.PlansForm;
import com.example.ProMana.repository.LinesRepository;

import jakarta.validation.Valid;

@Controller
public class PlansController {

	@Autowired
	private PlansService plansService;

	@Autowired
	private LinesService linesService;

	@Autowired
	private LinesRepository linesRepository;

	@GetMapping("/plans/new")
	public String showRegistrationForm(Model model, PlansForm plansForm) {
		model.addAttribute("lines", linesService.getAllLines());
		return "plans/new";
	}

	@GetMapping("/savePlans")
	public String create(@Valid @ModelAttribute("plansForm") PlansForm plansForm,
			BindingResult bindingResult, @RequestParam("lines_Id") Long lines_Id,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("lines", linesService.getAllLines());
			return "plans/new";
		}
		plansService.registerPlan(lines_Id, plansForm.getPlanned_case_count());
		List<Line> linesList = linesRepository.findLinesWithPlan();
		model.addAttribute("lines", linesList);
		return "plans/index";

	}

}