package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.daoImplimentations.UserDao;
import com.entities.Users;
import com.jdbcdao.LoginDao;
import com.validations.ValidPassword;
import com.validations.ValidPhone;
import com.validations.Validation;

public class UserService {
	@Autowired
	UserDao dao;
	public String loginjdbcService(Users users, Model model) throws Exception {

		String mail = users.getUser_email();
		String pwd = users.getUser_password();

		if (mail == null || pwd == null && mail.isEmpty() || pwd.isEmpty()) {

			System.out.println("entered email and password Wrong...!!!");
			return "login";
		}

		LoginDao loginDao = new LoginDao();
		List<Users> loginuserDao = loginDao.loginuserDao(users, model);
		List<Users> list = loginDao.getAll(users);
		 if(loginuserDao.isEmpty()) { 
			 model.addAttribute("errMsg", "Please enter valid credentials");
			 return "login"; 
		 }
		 model.addAttribute("usersList", list);
		return "home";

	}

	public String updateuser(Users users, Model model) {

		
		List<Users> list = dao.update(users);
		model.addAttribute("usersList", list);

		return "home";

	}

	public String editServices(String email, Users users, Model model) {

		/*UserDao dao=new UserDao();*/
			List<Users> edituser = dao.edituser(email, users);
		model.addAttribute("user", edituser.get(0));

		return "edit";

	}

	public String loginServices(Users users, Model model) {

		String email = users.getUser_email();
		String password = users.getUser_password();

		if (email == null || email.isEmpty() && password == null || password.isEmpty()) {

			System.out.println("Email & Password are Empty...!!!");

			return "login";

		} else {
			/*UserDao dao=new UserDao();*/
				List<Users> list = dao.loginuser(users, model);

			if (list.isEmpty()) {
				System.out.println("User mail  and Password Not In DataBase..!!!");
				return "login";
			} else {

				return "home";
			}
		}

	}

	public String registerservices(Users users) {

		String email = users.getUser_email();
		String password = users.getUser_password();
		String mobile = users.getUser_mobile();

		boolean isValidemail = Validation.validate(email);

		ValidPhone phone = new ValidPhone();
		boolean isValidphone = phone.isValidphone(mobile);

		ValidPassword validPassword = new ValidPassword();
		boolean isValidatePassword = validPassword.isValidateP(password);

		if (!isValidatePassword || !isValidemail || !isValidphone) {
			System.out.println("Validations Creadentials:: validation Class");
			return "index";
		}

		else {
			/*UserDao dao=new UserDao();*/
			dao.registeruser(users);
			return "login";

		}

	}
}
