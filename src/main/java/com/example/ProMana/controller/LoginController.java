package com.example.ProMana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ProMana.Service.UserService;
import com.example.ProMana.form.LoginForm;
import com.example.ProMana.form.UserForm;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String root() {
		return "login";
	}

	@GetMapping("/login")
	public String home(LoginForm loginForm) {
		return "login/home";
	}

	@GetMapping("/login/signup")
	public String showAccountPage(UserForm userForm) {
		return "login/signup";
	}

	@PostMapping("/auth")
	public String checkLoginInfo(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "login/home";
		}

		return "redirect:/hello";
	}

	@PostMapping("/register")
	public String checkUserInfo(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "login/signup";
		}

		userService.registerUser(userForm.getUsername(), userForm.getPassword());
		return "redirect:/hello";
	}

	/*@PostMapping("/aaaaaaaaaaaaaa")
	public String registerUser(@ModelAttribute("loginForm") User user, Model model) {
		// フォームデータを使ってユーザーを登録
		return "redirect:/menu"; // リダイレクト先を適切なページに変更
	}*/
}
//UserController.java
/*@PostMapping("/register")
public String register(@ModelAttribute("user") User user) {
 String hashedPassword = passwordEncoder.encode(user.getPassword());
 user.setPassword(hashedPassword);
 userRepository.save(user);
 return "redirect:/login";
}*/
