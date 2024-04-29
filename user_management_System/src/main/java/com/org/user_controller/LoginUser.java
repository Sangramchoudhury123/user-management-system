package com.org.user_controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.userDao;
import com.org.dto.User;
@WebServlet("/Login_user")

public class LoginUser  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String Password=req.getParameter("password");
		
		userDao dao=new userDao();
		User user=dao.FetchUserByEmailAndPassword(email, Password);
		HttpSession session=req.getSession();
		if(user!=null) {
	session.setAttribute("userobject",user);
			resp.sendRedirect("home.jsp");
		}
		else {
			
			session.setAttribute("fail", "Invalid Username or password");
			resp.sendRedirect("login.jsp");
		}
		
		
	}

}
