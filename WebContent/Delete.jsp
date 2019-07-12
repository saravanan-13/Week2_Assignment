<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.bean.EmployeeDAO"%>
		<%@page import="com.bean.Employee"%>
	<%@page import="org.springframework.context.ApplicationContext"%>
	<%@page
		import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>

	<h1 class="sign_in">Delete</h1>
	<form action="" method="post">
		<input type="text" name="username" placeholder="Username" /> 
		<input type="submit" class="login__submit" value="Search" />
	</form>
	<br><br>
	<%!
		Employee emp = null;
	%>
	<%
	if ("POST".equalsIgnoreCase(request.getMethod())) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO obj = (EmployeeDAO) factory.getBean("empimpl");
		emp = obj.getEmp(request.getParameter("username"));
		%>
				<table border="1">
		<tr>
			<th>User name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Department</th>
			<th>Role</th>
		</tr>
	
				 <tr>
				    <td> <% out.println(emp.getUsername()); %></td>
				    <td> <% out.println(emp.getAge()); %></td>
				    <td> <% out.println(emp.getEmail()); %></td>
				    <td> <% out.println(emp.getDepartment()); %></td>
				    <td> <% out.println(emp.getRole()); %></td>				    
				  </tr>
	</table>
	<br><br>
	<form action="delete" method="post">
	<input type="hidden" name="username" value="<%= request.getParameter("username") %>" />
		<input type="submit" value="Delete" />
	</form>
		<% 
		
	  	
	} else {
	  	System.out.println("Failure");
	}
	%>
	

</body>
</html>