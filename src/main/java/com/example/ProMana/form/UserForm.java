package com.example.ProMana.form;

import javax.validation.constraints.NotEmpty;

import com.example.ProMana.validation.constraints.PasswordEquals;

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