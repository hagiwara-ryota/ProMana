package com.example.ProMana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Line;
import com.example.ProMana.entity.Plan;
import com.example.ProMana.repository.LinesRepository;
import com.example.ProMana.repository.PlansRepository;

@Service
public class PlansService {

	@Autowired
	private PlansRepository plansRepository;

	@Autowired
	private LinesRepository linesRepository;

	public void registerPlan(Long linesId, int plannedCaseCount) {

		Line line = linesRepository.findById(linesId)
				.orElseThrow(() -> new RuntimeException("Lines with id " + linesId + " not found"));

		Plan plan = new Plan();
		plan.setLines(line);
		plan.setPlannedCaseCount(plannedCaseCount);

		plansRepository.saveAndFlush(plan);
	}
}
