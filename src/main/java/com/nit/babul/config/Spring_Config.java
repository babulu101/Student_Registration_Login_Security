package com.nit.babul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nit.babul.service.Student_Service_Imp;

@Configuration
public class Spring_Config {

	
	
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		http.authorizeRequests(ate->ate.requestMatchers("/student/home").authenticated().anyRequest().permitAll())
		.formLogin(form->form.loginPage("/student/login")
				.loginProcessingUrl("/login")
				.permitAll()
				);
		return http.build();
	}
	@Bean
	public BCryptPasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationProvider provider(Student_Service_Imp service) {
		DaoAuthenticationProvider pro=new DaoAuthenticationProvider();
		pro.setUserDetailsService(service);
		pro.setPasswordEncoder(password());
		return pro;
	}
	@Bean
	public AuthenticationManager mana(AuthenticationProvider provi) {
		return new ProviderManager(provi);
	}
	
	
	
	
	
	
}
