package com.example.ProMana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ProMana.form.PlansForm;
import com.example.ProMana.repository.LinesRepository;

import jakarta.validation.Valid;

@Controller
public class PlansController {

	@Autowired
	private LinesRepository linesRepository;

	@GetMapping("/plans/new")
	public String showRegistrationForm(Model model, PlansForm plansForm) {
		model.addAttribute("lines", linesRepository.findAll());
		//model.addAttribute("lines", linesService.getAllLines());
		return "plans/new";
	}

	@GetMapping("/savePlans")
	public String create(@Valid @ModelAttribute("plansForm") PlansForm plansForm, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("lines", linesRepository.findAll());
			return "plans/new";
		}
		return "a";

	}
	/*@RequestMapping(value = "/topics/{topicId}/comments/new")
	public String newComment(@PathVariable("topicId") long topicId, Model model) {
	    CommentForm form = new CommentForm();
	    form.setTopicId(topicId);
	    model.addAttribute("form", form);
	
	    return "comments/new";*/

}