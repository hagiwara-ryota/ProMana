package com.example.ProMana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Line;
import com.example.ProMana.entity.Produced_case_count;
import com.example.ProMana.repository.LinesRepository;
import com.example.ProMana.repository.Produced_case_countRepository;

@Service
public class Produced_case_countService {

	@Autowired
	LinesRepository linesRepository;

	@Autowired
	Produced_case_countRepository produced_case_countRepository;

	public void registerProduced_case_count(Long line_id, int count) {
		System.out.println(line_id);
		System.out.println("ここをみろ２");

		Line line = linesRepository.findById(line_id)
				.orElseThrow(() -> new RuntimeException("Lines with id " + line_id + " not found"));
		System.out.println(line_id);
		System.out.println("ここをみろ３");
		
		Produced_case_count produced_case_count = new Produced_case_count();
		produced_case_count.setLines(line);
		produced_case_count.setCount(count);
		
		System.out.println(line);
		System.out.println("ここをみろ４");

		produced_case_countRepository.saveAndFlush(produced_case_count);
	}

}
