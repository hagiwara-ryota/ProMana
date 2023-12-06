package com.example.ProMana.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

	@Column(name = "created_at")
	private LocalDateTime created_at;

	@Column(name = "updated_at")
	private LocalDateTime updated_at;

	@PrePersist
	public void onPrePersist() {
		LocalDateTime dateTime = LocalDateTime.now();
		setCreated_at(dateTime);
		setUpdated_at(dateTime);
	}

	@PreUpdate
	public void onPreUpdate() {
		setUpdated_at(LocalDateTime.now());
	}
}