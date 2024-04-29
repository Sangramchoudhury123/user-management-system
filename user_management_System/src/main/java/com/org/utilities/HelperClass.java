package com.org.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass 
{
private static Connection con;
static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt1","root","root");
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}
public static Connection getDBConnection() {
	return con;
	
}

}
