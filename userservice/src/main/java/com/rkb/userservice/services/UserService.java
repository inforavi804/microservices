package com.rkb.userservice.services;

import java.util.List;
import java.util.Optional;

import com.rkb.userservice.entities.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> userList();

	User getUserById(Integer id);

}
