package com.example.ProMana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProMana.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long> {

}
