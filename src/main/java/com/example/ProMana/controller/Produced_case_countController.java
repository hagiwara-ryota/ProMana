package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProMana.Service.Produced_case_countService;
import com.example.ProMana.entity.Line;
import com.example.ProMana.form.Produced_case_countForm;
import com.example.ProMana.repository.LinesRepository;

import jakarta.validation.Valid;

@Controller
public class Produced_case_countController {

	@Autowired
	private LinesRepository linesRepository;

	@Autowired
	Produced_case_countService produced_case_countService;

	@GetMapping("/saveProduced_case_count")
	public String create(
			@RequestParam("line_id") Long line_id,
			@Valid @ModelAttribute("produced_case_countForm") Produced_case_countForm produced_case_countForm,
			BindingResult bindingResult, Model model) {
		System.out.println(line_id);
		System.out.println("ここをみろ1");
		if (bindingResult.hasErrors()) {
			List<Line> linesList = linesRepository.findLinesWithPlan();
			model.addAttribute("lines", linesList);
			return "produced_case_counts/index";

		}

		produced_case_countService.registerProduced_case_count(line_id, produced_case_countForm.getCount());
		System.out.println(line_id);
		System.out.println("ここをみろ５");
		return "produced_case_counts/complete";
	}
}
