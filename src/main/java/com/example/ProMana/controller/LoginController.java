package com.example.ProMana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProMana.entity.User;
import com.example.ProMana.form.LoginForm;
import com.example.ProMana.form.UserForm;
import com.example.ProMana.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String root(LoginForm loginForm) {
		return "login";
	}

	@GetMapping("/signup")
	public String showAccountPage(UserForm userForm) {
		return "signup";
	}

	@GetMapping("/login")
	public String checkLoginInfo(@Validated @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "login";
		}

		return "redirect:/menus/index";
	}

	@PostMapping("/register")
	public String checkUserInfo(@Validated @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "signup";
		}

		User user = new User();
		user.setUsername(userForm.getUsername());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		userRepository.save(user);

		return "redirect:/";
	}

}
//UserController.java
/*@PostMapping("/register")
public String register(@ModelAttribute("user") User user) {
 String hashedPassword = passwordEncoder.encode(user.getPassword());
 user.setPassword(hashedPassword);
 userRepository.save(user);
 return "redirect:/login";
}*/
