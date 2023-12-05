package com.example.ProMana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Lines;
import com.example.ProMana.entity.Plans;
import com.example.ProMana.repository.LinesRepository;
import com.example.ProMana.repository.PlansRepository;

@Service
public class PlansService {

	@Autowired
	private PlansRepository plansRepository;

	@Autowired
	private LinesRepository linesRepository;

	public void registerPlans(Long lines_id, int planned_case_count) {

		Lines lines = linesRepository.findById(lines_id)
				.orElseThrow(() -> new RuntimeException("Lines with id " + lines_id + " not found"));

		Plans plans = new Plans();
		plans.setLines(lines);
		plans.setPlanned_case_count(planned_case_count);

		plansRepository.save(plans);
	}
}
