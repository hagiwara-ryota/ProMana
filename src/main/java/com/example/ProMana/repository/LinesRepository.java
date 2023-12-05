package com.example.ProMana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProMana.entity.Lines;

@Repository
public interface LinesRepository extends JpaRepository<Lines, Long> {


}
