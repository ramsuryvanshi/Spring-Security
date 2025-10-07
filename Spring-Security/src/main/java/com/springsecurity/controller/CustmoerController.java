package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entities.Customer;
import com.springsecurity.service.CustmoerService;

@RestController
public class CustmoerController {

	
	@Autowired
	public CustmoerService custservice;
	
	@Autowired
	public AuthenticationManager authmanager;
	

	
	@PostMapping("/login")
	
		public ResponseEntity<String>login(@RequestBody Customer c)
		{
			UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(c.getEmail(),c.getPwd());
			
			//verify login details valid or not
		Authentication authenticate=	authmanager.authenticate(token);
		
		
		
		    boolean status=authenticate.isAuthenticated();
		    
		    if(status)
		    {
		    	return new ResponseEntity<String>("sucess",HttpStatus.OK);
		    }
		    else {
		    	return new ResponseEntity<String>("Invalid",HttpStatus.BAD_REQUEST);
		    }
		}
		   
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String>createUser(@RequestBody Customer c)
	{
		boolean status=custservice.saveCustomer(c);
		if(status)
		{
			return new ResponseEntity<>("sucess",HttpStatus.CREATED);
			
		}
		else {
			return new ResponseEntity<>("Failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
