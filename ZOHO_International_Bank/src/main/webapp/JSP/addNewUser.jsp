<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Add New User </title>
<style type="text/css">

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:34.5%;
	font-size:20px;
	border-radius:20px;
}

button:hover
{
	background-color:#8080ff;
}

button:active
{
	background-color:cyan;
}

input
{
	font-size:20px;
	border:none;
	background:transparent;
	border-bottom: 2px solid #0000cc;
}

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:40%;
	height:48vh;
}

.radio
{
	text-align:left;
	font-size:20px;
	border:none;
	background:transparent;
}

label
{
	font-size:20px;
}

.lable-th
{
	width:200px;
	text-align:left;
}

h2
{
	padding-left:1%;
	font-size:30px;
	background-color:#3333cc;
	color:white;
}

.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	background-size:100% 100%;
	height:56em;
	width:100%;
}

</style>
</head>
<body>

<h2 style = "font-size:30px"> Create User </h2>

<div class = "back-ground">
	
	<img style = "padding-top:8%; padding-right:5%; float:right; height:35%; width:15%" src="<%= request.getContextPath() %>/images/png18.png" alt="Request Image">
	<img style = "padding-top:8%; padding-left:5%; float:left; height:35%; width:15%" src="<%= request.getContextPath() %>/images/png18a.png" alt="Request Image">
	<div style = "margin-left:30%" class = "border">
		
		<div style = "margin-top:5%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th class = "lable-th"> <label for = "name"> Name </label> </th>
					<th> <input type = "text" id = "name" name = "name" placeholder = "Enter User Name" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "mobile"> Mobile No </label> </th>
					<th> <input type = "number" id = "mobile" name = "mobile" placeholder = "Enter Mobile Number" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "emailID"> Email ID </label> </th>
					<th> <input type = "email" id = "emailID" name = "emailID" placeholder = "Enter Email ID" required></th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "dateOfBirth"> Date Of Birth </label> </th>
					<th> <input style = "width:128%" type = "date" id = "dateOfBirth" name = "dateOfBirth" placeholder = "Enter DOB" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for= "userType"> User Type </label> </th>
					<th> <input class = "radio" type="radio" id="customer" name="userType" value="CUSTOMER">
  						 <label for="customer"> Customer </label>
						 <input class = "radio" type="radio" id="admin" name="userType" value="ADMIN">
  						 <label for="admin"> Admin </label>
					</th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "password"> Password </label> </th>
					<th> <input type = "password" id = "password" name = "password" placeholder = "Set Password" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "confirmPassword"> Confirm Password </label> </th>
					<th> <input type = "Password" id = "confirmPassword" name = "confirmPassword" placeholder = "Confirm Password" required> </th>
				</tr>
				</table><br>
				<p style = "padding-left:32%; font-size:20px; color:red"> ${ Message } </p>
				<button type = "submit" value = "Add New User" name = "action"> Add User </button>
			</form>
		</div>
	</div>
</div>
</body>
</html>