package com.example.ProMana.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Line;
import com.example.ProMana.repository.LinesRepository;

@Service
public class LinesService {

	@Autowired
	private LinesRepository linesRepository;

	public void registerLines(String name, String product_name, int case_count_per_hour) {
		Line lines = new Line();
		lines.setName(name);
		lines.setProduct_name(product_name);
		lines.setCase_count_per_hour(case_count_per_hour);

		linesRepository.save(lines);
	}
	
	public List<Line> getAllLines() {
		return linesRepository.findAll();
	}

}