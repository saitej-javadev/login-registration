package com.saitej.service;

import com.saitej.model.User;
import com.saitej.repos.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServiceImpl implements UserService {


	UserRepository userRepository
			= new UserRepository();

	@Override
	public int saveUser(User user) {

		return userRepository.saveUser(user);
	}

	@Override
	public void loginUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("UserServiceImpl.loginUser()");
		userRepository.loginUser(request,response);

	}


}
