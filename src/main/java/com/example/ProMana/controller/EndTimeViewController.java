package com.example.ProMana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ProMana.Service.EndTimeService;
import com.example.ProMana.entity.Line;
import com.example.ProMana.repository.LinesRepository;

@Controller
public class EndTimeViewController {

	@Autowired
	LinesRepository linesRepository;

	@Autowired
	EndTimeService endTimeService;

	@GetMapping("/endTimeView/index")

	public String calc(Model model) {
		List<Line> linesWithCounts = endTimeService.getLinesWithPlannedAndProducedCounts();
		model.addAttribute("lines", linesWithCounts);

		return "endTimeView/index";
	}

}
