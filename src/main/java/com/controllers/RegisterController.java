package com.controllers;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Student;
import com.entities.University;
import com.entities.Users;
import com.jdbcdao.LoginDao;
import com.jdbcdao.RegisterDao;
import com.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService service;
	
	@Autowired
	Student student1;
	
	@Autowired
	Student student2;
	
	@Autowired
	Student student3;
	
	@Autowired
	University university;
	

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	private String registeruser(Users users, Model model) {
		System.out.println("entering to registeruser :: RegisterController");

		/*
		 * RegisterDao register=new RegisterDao(); String string =
		 * register.register(users, model);
		 */
		/* UserService service=new UserService(); */
		String result = service.registerservices(users);

		System.out.println("Existing from  registeruser :: RegisterController");
		return result;

	}
	
	@RequestMapping(value="/getall")
	private String getAllUsers(Users users,Model model) {
		Session openSession = new Configuration().configure().buildSessionFactory().openSession();
		
		Query queryAll = openSession.createQuery("From Users");
		List<Users> userList = queryAll.list();
		model.addAttribute("usersList", userList);
		
		return "home";
		
	
	}
	
	
	@RequestMapping(value="/sTone",method=RequestMethod.POST)
	public String singleToneTest1() {
	
		
		System.out.println("enterd...............");
		
		student1.setStdid(101);
		student1.setStdname("Srikanth");
//		student1.setStdcollege("chitanya");
		student1.setStdbranch("ece");
		student1.getUniversity().setUname("sv");
		
//		Student student2=new Student();
		student2.setStdid(102);
		student2.setStdname("Srinivas");
//		student2.setStdcollege("narayana");
		student2.setStdbranch("cse");
		student2.getUniversity().setUid(1250);
		student2.getUniversity().setUname("jntuh");
		
		
		student3.setStdid(103);
		student3.setStdname("Anil");
//		student3.setStdcollege("gayatri");
		student3.setStdbranch("eee");
		student3.getUniversity().setUname("ou");
		
		
		System.out.println(student1.getStdname()+"---"+student1.getStdcollege()+"-----"+student1.getUniversity().getUname()+"------"+student1.getUniversity().getUaddress());
		System.out.println(student2.getStdname()+"---"+student2.getStdcollege()+"-----"+student2.getUniversity().getUname()+"----"+student2.getStdcollege());
		System.out.println(student3.getStdname()+"---"+student3.getStdcollege()+"-----"+student3.getUniversity().getUname()+"----"+student3.getUniversity().getUaddress());
		
		System.out.println("ended...............");
		
		
		
		return "index";

	}

}
