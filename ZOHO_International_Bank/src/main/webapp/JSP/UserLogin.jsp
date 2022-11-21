<%@ page language = "java" contentType = "text/html; charset=UTF-8"
    pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>User Login</title>
<style>

th
{
	width:160px;
	text-align:left;
}

button
{
	color:white;
	width:50%;
	font-size:18px;
	margin-left:25%;
	text-align:center;
	border-radius:10px;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
}

button:hover
{
	background-color:#8080ff;
}

button:active
{
	color:cyan;
}

input::-webkit-inner-spin-button
{
  -webkit-appearance: none;
  margin: 0;
}

input
{
	outline:none;
	font-size:20px;
	width:165%;
	border:none;
	background:transparent;
	border-bottom: 1px solid #000000;
}

.border
{
	background-color:#b3b3ff;
	border-style:groove;
	border-radius:20px 60px;
	border-color:#9999ff;
	height:35vh;
	width:30%;
	margin-left:16%;
	margin-top:8%;
}

p
{
	color:white;
	font-size:60px;
	font-weight:800;
}

.login-body
{
	background-image:url(<%= request.getContextPath() %>/images/background_5.jpg);
	background-size:100% 100%;
	overflow:hidden;
	background-repeat:no-repeat;
	height:100vh;
}

</style>
</head>
<body class = login-body>

	<img style = "padding-right:2%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png2.png" alt="Request Image">
	<p style = "padding:2%"> <span style="color: #b30000">Z</span><span style="color: #00b300">O</span><span style="color: #0099ff">H</span><span style="color: #ffcc00">O</span> International Bank </p>

<div>
	
	<div class = "border">
		<h2 style = "font-family:monospace; margin-left:6%; margin-top:5%"> LOGIN </h2>
		<hr> <br><br>
		<form action = "<%= request.getContextPath() %>/myServlet" method = "post">
			<table style = "padding-left:25%">
			<tr>
				<th> <input placeholder = "User ID" type = "number" id = "userID" name = "userID" required> </th>
			</tr>
			</table>
			<table style = "padding-left:25%">
			<tr>
				<th> <br> <input placeholder = "Password	" type = "password" id = "password" name = "password" required> </th>
			</tr>
			
			</table> <br>
			<p style = "padding-left:25%; font-size:20px; color:red"> ${ Message } </p>
			<button type = "submit" value ="Login" name = "action"> Login </button>
			
		</form>
	</div>
</div>
</body>
</html>