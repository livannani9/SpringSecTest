package com.jdbcdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.ui.Model;

import com.entities.Users;
import com.validations.ValidPassword;
import com.validations.ValidPhone;
import com.validations.Validation;

public class RegisterDao {

	Connection connection = null;

	public String register(Users users,Model model) {
		
		String email=users.getUser_email();
		String mobile=users.getUser_mobile();
		String name=users.getUser_name();
		String password=users.getUser_password();
		
		
		try {
			System.out.println("entering  into register :: Register");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatemappings", "root", "root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into users(user_email,user_mobile,user_name,user_password) values(?,?,?,?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, mobile);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, password);
			
			boolean isValidname = Validation.isValid(name);
			boolean isValidEmail = Validation.validate(email);
			ValidPassword pwd=new ValidPassword();
			boolean isValidatePasssword = pwd.isValidateP(password);
			ValidPhone phone=new ValidPhone();
			boolean isValidphone = phone.isValidphone(mobile);
			
			if (!isValidname||!isValidEmail||!isValidphone||!isValidatePasssword) {
				 System.out.println("Invalid Credentials...!!!");
				
				 return "index";
				
			}
			
			int update = preparedStatement.executeUpdate();
			System.out.println("update="+update);
			return "login";
			
		} catch (Exception e) {
			System.out.println("registration failed :: Register");
			e.printStackTrace();
			
			return "index";
		}
		finally {
			try {
				System.out.println("Connection Closed....!!!");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
