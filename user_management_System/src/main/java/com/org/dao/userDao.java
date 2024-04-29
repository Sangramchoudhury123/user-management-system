package com.org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;
import com.org.utilities.HelperClass;

public class userDao 
{
public void saveUser(User user)
{
	Connection con=HelperClass.getDBConnection();
	try {
		PreparedStatement pst=con.prepareStatement(" insert into user(name,age,mobile,email,password)values(?,?,?,?,?)");
		pst.setString(1, user.getName());
		pst.setInt(2, user.getAge());
		pst.setLong(3, user.getMobile());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getPassword());
	pst.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}
public List<User> fetchAllUsers(){
	Connection con=HelperClass.getDBConnection();
	User user=null;
	List<User> list=new ArrayList<>();
	try {
		PreparedStatement pst=con.prepareStatement("select * from user");
		ResultSet rst=pst.executeQuery();
		while(rst.next()) {
					String name=rst.getString("name");
					int age=rst.getInt("age");
					Long mobile=rst.getLong("mobile");
					String email1=rst.getString("email");
					String password2=rst.getString("password");
					
					user=new User();
					user.setId(rst.getInt("id"));
					user.setName(name);
					user.setAge(age);
					user.setEmail(email1);
					user.setPassword(password2);
					user.setMobile(mobile);
					list.add(user);			
				}
		return list;	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return null;
}
public User fetchUserById(int id,User user) {
	return null;
	
}
public void updateUserById(int id) {
	
}
public void deleteUserById(int id) {
	
}
public User FetchUserByEmailAndPassword(String email,String Password) 

{
	
	Connection con=HelperClass.getDBConnection();
	try {
		PreparedStatement pst=con.prepareStatement("select * from user where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, Password);
		ResultSet rst=pst.executeQuery();
		User user=null;
		if(rst.next()) {
	//		int id=rst.getInt("id");
			String name=rst.getString("name");
			int age=rst.getInt("age");
			Long mobile=rst.getLong("mobile");
			String email1=rst.getString("email");
			String password2=rst.getString("password");
			
			user=new User();
			user.setId(rst.getInt("id"));
			user.setName(name);
			user.setAge(age);
			user.setEmail(email1);
			user.setPassword(password2);
			user.setMobile(mobile);
			
		}
		return user;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
}
}
