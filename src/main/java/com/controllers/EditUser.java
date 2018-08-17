package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.IuserDao.Daos;
import com.entities.Users;
import com.services.UserService;

@Controller
public class EditUser {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/editMode")
	public String openInEditMode(@RequestParam("mail") String email, Users users, Model model) {

		System.out.println("Entering into OpenInEditMode :: EditUser");

/*		UserService userService = new UserService();*/
		String editServices = userService.editServices(email, users, model);
		
		System.out.println(" exiting from OpenInEditMode :: EditUser");
		return editServices;

	}
}
