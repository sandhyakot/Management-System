<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>

<link rel="stylesheet" href="css/style.css">
</head>

<body>
<header>
   <h1 >Welcome to Appointment Page</h1><br> 
  
</header>
<h2 style="color: red" align="center">${requestScope.msg }</h2>  <!-- Status of login --> 
<h2 style="color: blue;" align="center">${requestScope.registerMsg }</h2> <!-- Status of Registration -->


		
			<form action="Validator" method="post">
				<h1>Login Form</h1>
				<div>
					<input type="text" placeholder="UserID" required="" name="empid" />
				</div>
				<div>
					<input type="password" placeholder="Password" required=""
						name="password" />
				</div>
				<div>
					<input type="submit" value="Log in" /> 
					<a  href="http://localhost:8081/AppointmentManagementSystem/Register.jsp">Register</a>
				</div>
			</form>
			<!-- form -->

		
	<!-- container -->
</body>


</html>