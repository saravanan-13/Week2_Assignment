<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Employee</title>
</head>
<body>
	<h1 class="sign_in">Create Employee</h1>
	<form action="create" method="post" onsubmit="return passwordCheck()">
		USERNAME : <input type="text" name="username" placeholder="Username" />
		<br>
		<br> 
		PASSWORD : <input type="password" name="password" id="pwd1" placeholder="Password" />
		<br>
		<br>
		CONFIRM PASSWORD : <input type="password" name="password2" id="pwd2" placeholder="Confirm Password" />
		<br>
		<br> 
		AGE : <input type="number" name="age" placeholder="Age" />
		<br>
		<br> 
		EMAIL : <input type="email" name="email" placeholder="Email" />
		<br>
		<br> 
		DEPARTMENT : <input type="text" name="department" placeholder="Department" />
		<br>
		<br>
		ROLE : <input type="text" name="role" placeholder="Role" />
		<br>
		<br> 
		<input type="submit" value="Create" />
		<br>
		<br>
		<input type="reset" value="Reset" />
	</form>
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