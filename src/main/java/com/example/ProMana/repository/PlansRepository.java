package com.example.ProMana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProMana.entity.Plan;

@Repository
public interface PlansRepository extends JpaRepository<Plan, Long> {

}
