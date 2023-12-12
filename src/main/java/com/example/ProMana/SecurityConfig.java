package com.example.ProMana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.example.ProMana.filter.FormAuthenticationProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private FormAuthenticationProvider authenticationProvider;

	@Autowired
	UserDetailsService service;

	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
	        http.authorizeRequests().antMatchers("/", "/login", "/signup", "/register").permitAll()
	                .anyRequest().authenticated()
	                // ログアウト処理
	                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").clearAuthentication(true)
	                .deleteCookies("JSESSIONID")
	                .invalidateHttpSession(true).permitAll().and().csrf()
	                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	                // form
	                .and().formLogin().loginPage("/login").defaultSuccessUrl("/menus/index").failureUrl("/login")
	                .permitAll();
	    }
		

		
		  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		        auth.authenticationProvider(authenticationProvider);
		    }

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
