<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Change Password </title>
<style type="text/css">

input
{
	font-size:20px;
	border:none;
	background:transparent;
	border-bottom: 1px solid #0000cc;
}

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:45.5%;
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

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:38%;
	height:30vh;
}

label
{
	font-size:20px;
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

<h2> Change Password </h2>

<div class = "back-ground">

	<img style = "padding-left:3%; float:left; height:30%; width:22%" src="<%= request.getContextPath() %>/images/png15.png" alt="Request Image">
	<img style = "padding-right:3%; float:right; height:30%; width:22%" src="<%= request.getContextPath() %>/images/png15a.png" alt="Request Image">
	<div style = "margin-left:30%" class = "border">
		
		<div style = "margin-top:5%; margin-left:3%">
		<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
			<table>
			<tr>
				<th style = "width:250px; text-align:left"> <label for = "oldPassword"> Old Password </label> </th>
				<th> <input type = "password" id = "oldPassword" name = "oldPassword" placeholder = "Enter Old Password"> </th>
			</tr>
			</table><br>
			<table>
			<tr>
				<th style = "width:250px; text-align:left"> <label for = "newPassword"> New Password </label> </th>
				<th> <input type = "Password" id = "newPassword" name = "newPassword" placeholder = "Enter New Password"> </th>
			</tr>
			</table><br>
			<table>
			<tr>
				<th style = "width:250px; text-align:left"> <label for = "confirmPassword"> Confirm Password </label> </th>
				<th> <input type = "Password" id = "confirmPassword" name = "confirmPassword" placeholder = "Confirm New Password"> </th>
				<th> <input type = "hidden" id = "customerID" name = "customerID" value = "${ userDetails.getUserID() }"> </th>
			</tr>
			</table><br>
			<p style = "padding-left:32%; font-size:20px; color:red"> ${ Message } </p>
			<button type = "submit" value = "Update Password" name = "action"> Save </button>
		</form>
		</div>
	</div><br><br>
	<img style = "padding-left:38%; float:left; height:30%; width:22%" src="<%= request.getContextPath() %>/images/png16.png" alt="Request Image">
</div>
</body>
</html>