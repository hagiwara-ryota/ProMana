package com.example.ProMana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.ProMana.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/login/home", "/login/signup", "/auth", "/register").permitAll()
				//.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin((form) -> form
						.loginPage("/login")
						//.defaultSuccessUrl("/hello", true)
						.permitAll())
				.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}