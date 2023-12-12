package com.example.ProMana.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
}