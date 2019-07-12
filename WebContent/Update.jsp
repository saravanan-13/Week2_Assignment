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
<title>Update</title>
</head>
<body style="text-align:center;">
<h1 class="sign_in">Update Employee Details</h1>

<br><br>
<h2>Enter the username to search the employee details</h2>
<form action="" method="post">
		<input type="text" name="username" placeholder="Username" /> 
		<input type="submit" value="Search" />
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
				<br><br>
	<form action="update" method="post" onsubmit="return passwordCheck()">
		USERNAME : <input type="text" name="username" placeholder="Username" value="<%=emp.getUsername() %>" readonly />
		<br>
		<br> 
		PASSWORD : <input type="text" name="password" id="pwd1" placeholder="Password" value="<%=emp.getPassword() %>" />
		<br>
		<br>
		CONFIRM PASSWORD : <input type="text" name="password2" id="pwd2" placeholder="Confirm Password" value="<%=emp.getPassword() %>" />
		<br>
		<br> 
		AGE : <input type="number" name="age" placeholder="Age" value="<%=emp.getAge() %>"/>
		<br>
		<br> 
		EMAIL : <input type="email" name="email" placeholder="Email" value="<%=emp.getEmail() %>"/>
		<br>
		<br> 
		DEPARTMENT : <input type="text" name="department" placeholder="Department" value="<%=emp.getDepartment() %>" />
		<br>
		<br>
		ROLE : <input type="text" name="role" placeholder="Role" value="<%=emp.getRole() %>" />
		<br>
		<br> 
		<input type="submit" value="Update" />
		<br>
		<br>
		<input type="reset" value="Reset" />
	</form>
	
		<% 
		
	  	
	} else {
	  	System.out.println("Failure");
	}
	%>
<script>
	function passwordCheck(){
		var pwd1 = document.getElementById("pwd1").value;
		var pwd2 = document.getElementById("pwd2").value;
		if(pwd1 === pwd2){
			return true;
		}
		else{
			alert("Both the password fields are not same !");
			return false;
		}
	}
</script>
</body>
</html>