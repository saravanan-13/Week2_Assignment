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
<title>Employee</title>
</head>
<body>
	<h1>Welcome To Publicis Sapient</h1>
	<%
		Employee emp = (Employee) request.getAttribute("emp");
		
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


</body>
</html>