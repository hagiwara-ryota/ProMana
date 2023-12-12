package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProMana.Service.LinesService;
import com.example.ProMana.Service.ProducedCaseCountService;
import com.example.ProMana.entity.Line;
import com.example.ProMana.form.ProducedCaseCountForm;
import com.example.ProMana.repository.LinesRepository;

@Controller
public class ProducedCaseCountController {

	@Autowired
	private LinesRepository linesRepository;

	@Autowired
	ProducedCaseCountService producedCaseCountService;

	@Autowired
	LinesService linesService;

	@GetMapping("/producedCaseCounts/index")
	public String producedCaseCountsIndex(ProducedCaseCountForm producedCaseCountForm, Model model) {
		List<Line> linesList = linesRepository.findLinesWithProducedCaseCount();
		model.addAttribute("lines", linesList);
		return "producedCaseCounts/index";
	}

	@GetMapping("/producedCaseCounts/new")
	public String showRegistrationForm(ProducedCaseCountForm producedCaseCountForm, Model model) {
		model.addAttribute("lines", linesService.getAllLines());
		return "producedCaseCounts/new";
	}

	@GetMapping("/saveProducedCaseCount")
	public String creat(@Validated @ModelAttribute("producedCaseCountForm") ProducedCaseCountForm producedCaseCountForm,
			BindingResult bindingResult, @RequestParam("lineId") long lineId, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("lines", linesService.getAllLines());
			return "producedCaseCounts/new";

		}

		producedCaseCountService.registerProducedCaseCount(lineId, producedCaseCountForm.getCount());
		System.out.println(lineId);
		return "redirect:/producedCaseCounts/index";
	}
}
