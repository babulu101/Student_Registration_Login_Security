package com.nit.babul.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.babul.entity.Student;
import com.nit.babul.repo.Student_Repos;

@Service
public class Student_Service_Imp implements Student_Service,UserDetailsService{

	@Autowired
	private BCryptPasswordEncoder pass;
	@Autowired
	private Student_Repos repo;
	
	
	@Override
	public int save(Student s) {

		String s2=s.getPassword();
		s.setPassword(pass.encode(s2));
		repo.save(s);
		return s.getId();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		int a=Integer.parseInt(username);
		Student student=repo.findById(a);
		return new User(String.valueOf(student.getId()), student.getPassword(),Collections.emptyList());
	}

}
