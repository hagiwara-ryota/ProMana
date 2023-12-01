package com.example.ProMana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProMana.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}