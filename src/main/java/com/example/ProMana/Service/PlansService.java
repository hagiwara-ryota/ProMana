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

	public void registerPlan(Long lines_id, int planned_case_count) {

		Line line = linesRepository.findById(lines_id)
				.orElseThrow(() -> new RuntimeException("Lines with id " + lines_id + " not found"));

		Plan plan = new Plan();
		plan.setLines(line);
		plan.setPlanned_case_count(planned_case_count);

		plansRepository.save(plan);
	}
}
