<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Customer Layer </title>
<style>

.dropdown-button
{
	font-size: 80%;
	width:80%;
}

button
{
	color:white;
	background-color:#3333cc;
	padding:20px;
	font-size:20px;
	border:none;
}

button:hover
{
	background-color:#8080ff;
}

button:active
{
	color:blue;
}

.dropdown-content
{
	display: none;
	position: absolute;
	min-width: 160px;
}

.dropdown
{
	background-color:#3333cc;
	overflow:hidden;
	float:right;
	padding-right:5%;
	padding-top:1%;
}

.dropdown .dropbtn
{
	font-size: 40px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: #3333cc;
	font-family: inherit;
}

.dropdown:hover .dropdown-content
{
	display: block;
}

.para
{
	color:white;
	font-size:60px;
	font-weight:800;
	padding:1%;
	margin-top:0px;
}

.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	overflow:hidden;
	margin:0px;
	padding:0px;
}

</style>
</head>
<body class = "back-ground">
	
	<header style="background-color:#3333cc; height:10vh">
		
		<div class="dropdown">
			<button class="dropbtn">
				&#128100;
			</button>
			<div class = "dropdown-content">
				<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
					<button class = "dropdown-button" type = "submit" value ="Profile" name = "action"> Profile </button> <br>
					<!-- <a href = "JSP/profile.jsp" target = "menu"> Profile </a> <br> -->
					<button class = "dropdown-button" type = "submit" value ="Change Password" name = "action"> Change Password </button> <br>
					<!-- <a href = "JSP/changePassword.jsp" target = "menu"> Change Password </a> <br> -->
				</form>
				<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "_parent">
					<button class = "dropdown-button" type = "submit" value ="Logout" name = "action"> Logout </button>
					<!-- <a href = "JSP/UserLogin.jsp"> Logout </a> <br> -->
				</form>
			</div>
		</div>
		<img style = "padding-right:1%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png2.png" alt="Request Image">
		<img style = "padding-right:2%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png3.png" alt="Request Image">
		<p class = "para"> <span style="color: #b30000">Z</span><span style="color: #00b300">O</span><span style="color: #0099ff">H</span><span style="color: #ffcc00">O</span> International Bank </p>
		
	</header>
	<div style = "height:90vh; overflow:hidden; display:flex">
		<div style = "overflow:hidden; width:15%; height:100vh">
		
			<iframe src = "JSP/customerMenu.jsp" style = "width:100%; height:1000px; border:none"></iframe>
		
		</div>
		<div style = "overflow:hidden; width:85%; height:100vh">
		
			<iframe src = "JSP/home.jsp" name = "actionFrame" style = "width:100%; height:1000px; border:none"></iframe>
		
		</div>
	</div>
</body>
</html>