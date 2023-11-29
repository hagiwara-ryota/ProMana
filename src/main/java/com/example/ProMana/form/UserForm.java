package com.example.ProMana.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserForm {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
}