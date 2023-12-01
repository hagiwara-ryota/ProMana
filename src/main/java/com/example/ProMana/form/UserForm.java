package com.example.ProMana.form;

import com.example.ProMana.validation.constraints.PasswordEquals;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@PasswordEquals
public class UserForm {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty
	private String passwordConfirmation;
}