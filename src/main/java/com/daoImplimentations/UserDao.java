package com.daoImplimentations;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;

import com.IuserDao.Daos;
import com.entities.Users;

public class UserDao implements Daos {

	Session session = null;

	public void sessions() {
		session = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("sessions Open:: UserDao");
		
	}

	public List<Users> update(Users users) {

		sessions();
		Query query = session.createQuery(
				"Update Users set user_mobile =:mymobile,user_name=:myname,user_password=:mypassword where user_email=:mymail");
		query.setParameter("mymobile", users.getUser_mobile());
		query.setParameter("myname", users.getUser_name());
		query.setParameter("mypassword", users.getUser_password());
		query.setParameter("mymail", users.getUser_email());

		int update = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("update count=" + update);

		Criteria criteria = session.createCriteria(Users.class);
		List<Users> list = criteria.list();
		

		return list;

	}

	// Edit User
	public List<Users> edituser(String email, Users users) {
		sessions();
		Query query = session.createQuery("from Users where user_email=:mymail");
		query.setParameter("mymail", email);
		List<Users> userList = query.list();
		return userList;

	}

	public void registeruser(Users users) {
		sessions();
		session.save(users);
		session.beginTransaction().commit();
		System.out.println("Exit from registerUser :: UserDao...!!!");
		System.out.println("sessions Closed:: UserDao");

	}

	public List<Users> loginuser(Users users, Model model) {
		sessions();
		Query query = session.createQuery("from Users where user_email= :mymail and user_password= :mypwd ");
		query.setParameter("mymail", users.getUser_email());
		query.setParameter("mypwd", users.getUser_password());
		List<Users> list = query.list();

		Query queryAll = session.createQuery("From Users");
		List<Users> userList = queryAll.list();
		model.addAttribute("usersList", userList);
		for (Users users2 : userList) {
			System.out.println("UserName=" + users2.getUser_name());

		}
		model.addAttribute("username", list.get(0));

		return list;

	}

	public String delete(String  mail, Model model) {
		sessions();
		Query query = session.createQuery("delete from Users where user_email=:mymail");
		query.setParameter("mymail", mail);
		int update = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("Delete count=" + update);

		Criteria criteria = session.createCriteria(Users.class);
		List<Users> list = criteria.list();
		model.addAttribute("usersList", list);

		return "home";

	}

}
