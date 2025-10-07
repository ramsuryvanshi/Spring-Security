package com.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springsecurity.service.CustmoerService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public CustmoerService customerservice;
	 
	@Bean
		public BCryptPasswordEncoder pwdEncoder(){
		return new  BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authprovider()
	{
		DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
		authprovider.setPasswordEncoder(pwdEncoder());
		authprovider.setUserDetailsService(customerservice);
		return authprovider;
		
	}

	@Bean
	public AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception
	{
		
		return config.getAuthenticationManager();
	}
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception
	{http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests((req)->{
		req.requestMatchers("/register")
		.permitAll()
		.anyRequest()
		.authenticated();
		});
		return http.build();
	}
	
	
}




