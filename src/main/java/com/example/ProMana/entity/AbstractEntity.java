package com.example.ProMana.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {

	@Column(name = "created_at")
	private LocalDate created_at;

	@Column(name = "updated_at")
	private LocalDate updated_at;

	@PrePersist
	public void onPrePersist() {
		LocalDate dateTime = LocalDate.now();
		setCreated_at(dateTime);
		setUpdated_at(dateTime);
	}

	@PreUpdate
	public void onPreUpdate() {
		setUpdated_at(LocalDate.now());
	}
}