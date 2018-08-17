package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Users;
import com.services.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	private String loginUser(Users users,Model model) throws Exception {
		System.out.println("entering into LoginUser :: LoginController");
		
		//Hibernate
		UserService service=new UserService();
		 String reString = service.loginServices(users,model);
		
		UserService service=new UserService();
		String loginjdbcService = service.loginjdbcService(users, model);
		
		System.out.println("Existing from  loginUser :: LoginController");
		return loginjdbcService;
		return reString;
	}*/

	
	
	
}
