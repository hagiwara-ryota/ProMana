package com.example.ProMana.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProMana.entity.Line;
import com.example.ProMana.repository.LinesRepository;

@Service
public class EndTimeService {

	@Autowired
	private LinesRepository linesRepository;
	 public List<Line> getLinesWithPlannedAndProducedCounts() {
	        List<Line> linesWithPlan = linesRepository.findLinesWithPlan();
	        List<Line> linesWithProducedCount = linesRepository.findLinesWithProducedCaseCount();

	        for (Line line : linesWithPlan) {
	            for (Line producedLine : linesWithProducedCount) {
	                if (line.getId().equals(producedLine.getId())) {
	                    // 計算結果を設定
	                    int remainingCases = line.getPlannedCaseCount() - producedLine.getCount();
	                    double calculatedValue = (double) remainingCases / line.getCase_count_per_hour();
	                    LocalDateTime now = LocalDateTime.now();
	                    LocalDateTime calculatedTime = now.plusHours((long) calculatedValue);
	                    line.setCalculatedValue(calculatedTime);
	                }
	            }
	        }

	        return linesWithPlan;
	    }
	}
