package com.jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.entities.Users;

public class LoginDao {
	String CLASS_NAME = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/hibernatemappings";
	String USERNAME = "root";
	String PASSWORD = "root";
	Connection connection = null;

	public List<Users> loginuserDao(Users users, Model model) throws Exception {
		List<Users> checkLoginList = new ArrayList<Users>();

		try {
			Class.forName(CLASS_NAME);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where user_email=? and user_password=?");
			preparedStatement.setString(1, users.getUser_email());
			preparedStatement.setString(2, users.getUser_password());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Users user = new Users();
				user.setUser_email(rs.getString("user_email"));
				user.setUser_password(rs.getString("user_password"));
				checkLoginList.add(user);

			}
			System.out.println("Login User is Triggersd =" + rs);

		} catch (Exception e) {
			System.out.println("Login Failed...!!!");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				System.out.println("connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return checkLoginList;

	}

	public List<Users> getAll(Users users) {
		List<Users> listAll = new ArrayList<Users>();
		
		try {
			System.out.println("Entering to getAll Method....");
			Class.forName(CLASS_NAME);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement preparedStatement1 = connection.prepareStatement("select * from users");
			ResultSet resultSet = preparedStatement1.executeQuery();

			while (resultSet.next()) {
				Users users2=new Users();
				users2.setUser_id(resultSet.getInt("user_id"));
				users2.setUser_email(resultSet.getString("user_email"));
				users2.setUser_mobile(resultSet.getString("user_mobile"));
				users2.setUser_name(resultSet.getString("user_name"));
				users2.setUser_password(resultSet.getString("user_password"));
				listAll.add(users2);

			}

		} catch (Exception e) {
			System.out.println("failed get all method");
			e.printStackTrace();
		}
		return listAll;

	}

}
