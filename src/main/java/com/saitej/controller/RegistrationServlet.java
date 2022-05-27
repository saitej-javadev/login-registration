package com.saitej.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saitej.model.User;
import com.saitej.service.UserService;
import com.saitej.service.UserServiceImpl;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher = null;
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RegistrationServlet.doPost()");

		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPass(request.getParameter("pass"));
		user.setEmail(request.getParameter("email"));
		user.setContact(request.getParameter("contact"));
		System.out.println("User: " + user);
        UserService userService = new UserServiceImpl();
		int rowCount = userService.saveUser(user);
		dispatcher = request.getRequestDispatcher("registration.jsp");
		if (rowCount > 0) {
			request.setAttribute("status", "Record inserted successfully..");
		} else {
			request.setAttribute("failed", "insert operation failed!!!");
		}
		dispatcher.forward(request, response);

	}

}
