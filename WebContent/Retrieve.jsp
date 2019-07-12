<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve</title>
</head>
<body>
	<%@page import="com.bean.Employee"%>
	<%@page import="org.springframework.context.ApplicationContext"%>
	<%@page
		import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
	<%!ArrayList<Employee> empList = new ArrayList<Employee>();%>
	<%
		ApplicationContext factory = new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDAO obj = (EmployeeDAO) factory.getBean("empimpl");
		empList = obj.getAllEmp();
	%>
	<table border="1">
		<tr>
			<th>User name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Department</th>
			<th>Role</th>
		</tr>
		<%
			for (Employee emp : empList) {
				%>
				 <tr>
				    <td> <% out.println(emp.getUsername()); %></td>
				    <td> <% out.println(emp.getAge()); %></td>
				    <td> <% out.println(emp.getEmail()); %></td>
				    <td> <% out.println(emp.getDepartment()); %></td>
				    <td> <% out.println(emp.getRole()); %></td>				    
				  </tr>
				
				<%
			}
		%>
	</table>
	<br><br>
<jsp:include page='Options.html' />
</body>
</html>