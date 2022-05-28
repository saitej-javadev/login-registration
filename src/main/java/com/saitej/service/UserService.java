package com.saitej.service;

import com.saitej.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	
	public int saveUser(User user);
	public void loginUser(HttpServletRequest request, HttpServletResponse response);

}
