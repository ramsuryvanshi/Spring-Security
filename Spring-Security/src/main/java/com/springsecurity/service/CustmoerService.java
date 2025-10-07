package com.springsecurity.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entities.Customer;
import com.springsecurity.repository.CustmoerRepository;

@Service
public class CustmoerService implements UserDetailsService{

	@Autowired
	public BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	public CustmoerRepository customRepo;
	
	
	
	public boolean saveCustomer(Customer c)
	{
		  String encodepwd=  pwdEncoder.encode(c.getPwd());
		  c.setPwd(encodepwd);
		Customer savedpwd= customRepo.save(c);
		 return savedpwd.getCid()!=null;
		  
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Customer c= customRepo.findByEmail(email);
		return new User(c.getEmail(),c.getPwd(),Collections.emptyList());
	}


	
	
	
}
