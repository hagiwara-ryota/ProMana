package com.example.ProMana.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Line;
import com.example.ProMana.entity.ProducedCaseCount;
import com.example.ProMana.repository.LinesRepository;
import com.example.ProMana.repository.ProducedCaseCountRepository;

@Service
public class ProducedCaseCountService {

	@Autowired
	LinesRepository linesRepository;

	@Autowired
	ProducedCaseCountRepository producedCaseCountRepository;

	public void registerProducedCaseCount(Long lineId, int count) {

		Line line = linesRepository.findById(lineId)
				.orElseThrow(() -> new RuntimeException("Lines with id " + lineId + " not found"));

		ProducedCaseCount producedCaseCount = new ProducedCaseCount();
		producedCaseCount.setLines(line);
		producedCaseCount.setCount(count);

		producedCaseCountRepository.saveAndFlush(producedCaseCount);
	}

}
