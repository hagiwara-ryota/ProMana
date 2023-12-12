package com.example.ProMana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProMana.Service.LinesService;
import com.example.ProMana.Service.PlansService;
import com.example.ProMana.form.PlansForm;

import jakarta.validation.Valid;

@Controller
public class PlansController {

	@Autowired
	private PlansService plansService;

	@Autowired
	private LinesService linesService;

	@GetMapping("/plans/new")
	public String showRegistrationForm(Model model, PlansForm plansForm) {
		model.addAttribute("lines", linesService.getAllLines());
		return "plans/new";
	}

	@GetMapping("/savePlans")
	public String create(@Valid @ModelAttribute("plansForm") PlansForm plansForm,
			BindingResult bindingResult, @RequestParam("lineId") long lineId,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("lines", linesService.getAllLines());
			return "plans/new";
		}

		plansService.registerPlan(lineId, plansForm.getPlannedCaseCount());
		return "redirect:/plans/index";

	}

}