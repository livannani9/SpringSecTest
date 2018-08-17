package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IuserDao.Daos;
import com.entities.Users;
import com.services.UserService;

@Controller
public class UpdateUser {
	@Autowired
	UserService service;
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateuser(Users users,Model model) {
		System.out.println("entering into Updateuser :: UpdateUser");
		
		/*UserService service=new UserService();*/
		String updateuser = service.updateuser(users, model);
		
		
		System.out.println("Exiting from updateuser :: UpdateUser");
		return updateuser;
		

	}

}
