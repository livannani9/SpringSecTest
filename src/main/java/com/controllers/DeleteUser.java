package com.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.IuserDao.Daos;
import com.daoImplimentations.UserDao;
import com.entities.Users;

@Controller
public class DeleteUser {

	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public String delete(@RequestParam("mail") String mail,Model model) {
		System.out.println("entering into delete :: DeleteUser");
		
		UserDao dao=new UserDao();
			String delete = dao.delete(mail, model);
		
		return delete;

	}
	
	
}
