package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ProMana.Service.LinesService;
import com.example.ProMana.entity.Lines;
import com.example.ProMana.form.LinesForm;
import com.example.ProMana.repository.LinesRepository;

import jakarta.validation.Valid;

@Controller
public class LinesController {

	@Autowired
	LinesService linesService;

	@Autowired
	LinesRepository linesRepository;

	@GetMapping("/lines/new")
	public String showRegistrationForm(LinesForm linesForm) {
		return "lines/new";
	}

	@GetMapping("/saveLines")
	public String create(@Valid @ModelAttribute("linesForm") LinesForm linesForm,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "lines/new";
		}
		linesService.registerLines(linesForm.getName(), linesForm.getProduct_name(),
				linesForm.getCase_count_per_hour());

		List<Lines> linesList = linesRepository.findAll();
		model.addAttribute("lines", linesList);
		return "lines/index";
	}

}
