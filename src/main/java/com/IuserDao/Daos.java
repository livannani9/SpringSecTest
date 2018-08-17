package com.IuserDao;

import java.util.List;

import org.springframework.ui.Model;

import com.entities.Users;

public interface Daos  {

	public void sessions();
	public List<Users> update(Users users) ;
	public List<Users> edituser(String email, Users users);
	public void registeruser(Users users);
	public List<Users> loginuser(Users users, Model model);

	public String delete(String  mail, Model model);
		

	

}
