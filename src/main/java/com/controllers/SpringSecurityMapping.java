package com.controllers;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daoImplimentations.UserDao;
import com.entities.Users;

@Controller
public class SpringSecurityMapping {

	@Autowired
	UserDao dao;

	final static Logger logger = Logger.getLogger(SpringSecurityMapping.class);

	@RequestMapping(value = "/openLogin")
	private String openLogin() {

		logger.info("entered Into openLogin  :: method");

		return "login";
 
	}

	@RequestMapping(value = "/login")
	private String openFailure(Model model) {

		logger.info("entered Into openFailure  :: method");
		model.addAttribute("msg", "Invalid Credentials Please Try With Valid Ones Again...!!");

		return "login";
	}

	@RequestMapping(value = "/default")
	private String defaulePage(Users users, Model model) {

		logger.info("entered Into defaulePage  :: method");

		model.addAttribute("msg", "Invalid ");

		return "index";
	}

	@RequestMapping(value = "/403", method = RequestMethod.POST)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
