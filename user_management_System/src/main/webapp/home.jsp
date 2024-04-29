<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.userDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component folder/allcss.jsp" %>
</head>
<body>

	<%@ include file="component folder/user_home_navbar.jsp" %>
	<h1 class="center">Welcome to home page </h1>
	<a class="btn btn-md btn-primary" href="add_user.jsp">Add User</a>
	<br> <br>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Mobile</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<%
								userDao dao=new userDao();
								List<User> users =dao.fetchAllUsers();
								User user=(User)  session.getAttribute("userobject");
								for (User u : users){
									if(user.getId()== Id){
										continue;
									}
								%>
								<tr>
								<td><%=u.getName() %> </td>
								<td><%=u.getAge() %> </td>
								<td><%=u.getEmail() %> </td>
								<td><%=u.getMobile() %></td> 
								
								<td><a class="btn btn-primary">Update</a>
								<a class="btn btn-danger">Delete</a></td>
								</tr>
								
										
								<% }%>		
							</tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
	
</body>
</html>