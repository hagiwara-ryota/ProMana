package com.example.ProMana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ProMana.entity.Line;

@Repository
public interface LinesRepository extends JpaRepository<Line, Long> {

	@Query("SELECT l FROM Line l JOIN FETCH l.plan")
	List<Line> findLinesWithPlan();
	
	@Query("SELECT l FROM Line l JOIN FETCH l.producedCaseCount")
	List<Line> findLinesWithProducedCaseCount();
}

