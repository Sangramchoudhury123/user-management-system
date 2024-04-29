package com.org.user_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.userDao;
import com.org.dto.User;
@WebServlet("/register_User")

public class Registeruser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobile=req.getParameter("mobile");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User();
		user.setName(name);
		user.setAge(Integer.parseInt(age));
		user.setMobile(Long.parseLong(mobile));
		user.setEmail(email);
		user.setPassword(password);
		
		userDao dao=new userDao();
		dao.saveUser(user);
		resp.sendRedirect("login.jsp");
		
		
	}

}
