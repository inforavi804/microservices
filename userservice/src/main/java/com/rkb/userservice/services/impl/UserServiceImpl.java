package com.rkb.userservice.services.impl;

import java.util.List;
//import java.util.UUID;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkb.userservice.entities.User;
import com.rkb.userservice.exceptions.ResourceNotFoundException;
import com.rkb.userservice.repositories.UserRepository;
import com.rkb.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id is Not Found on Server {} " + id));
		//return userRepository.findById(id).get();
		//User userObj = new User();
		//return userObj;
		//.orElseThrow(() -> new ResourceNotFoundException("User with given Id is Not Found on Server !!" + userId));
	}

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserid(randomUserId);	
		return userRepository.saveAndFlush(user);
	}

}
