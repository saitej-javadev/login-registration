package com.saitej.service;

import com.saitej.model.User;
import com.saitej.repos.UserRepository;

public class UserServiceImpl implements UserService {
	
     


	@Override
	public int saveUser(User user) {
		UserRepository userRepository
	                    = new UserRepository();
		return userRepository.saveUser(user);
	}

}
