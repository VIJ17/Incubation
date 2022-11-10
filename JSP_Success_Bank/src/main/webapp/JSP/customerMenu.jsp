<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Customer Menu</title>
<style type="text/css">
.back-ground
{
	babackground-color:#b3b3ff;
	overflow:hidden;
	height:60em;
}

button
{
	color:white;
	background-color:#3333cc;
	padding:20px;
	width:100%;
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

</style>
</head>
<body>

<div class = "back-ground">

	<p style = "padding-left:5%; font-size:23px; font-weight:400; font-family: system-ui"> WELCOME &nbsp ${ userDetails.getName() } </p>
	
	<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
		<button type = "submit" value ="Home" name = "action"> Home </button> <br>
		<!-- <a href = "JSP/profile.jsp" target = "menu"> Home </a> <br> -->
		<button type = "submit" value ="Deposit" name = "action"> Deposit </button> <br>
		<!-- <a href = "JSP/deposit.jsp" target = "menu"> Deposit </a> <br> -->
		<button type = "submit" value ="Withdraw" name = "action"> Withdraw </button> <br>
		<!-- <a href = "JSP/withdraw.jsp" target = "menu"> Withdraw </a> <br> -->
		<button type = "submit" value ="Online Transfer" name = "action"> Online Transfer </button> <br>
		<!-- <a href = "JSP/transfer.jsp" target = "menu"> Online Transfer </a> <br> -->
		<button type = "submit" value ="Profile" name = "action"> Profile </button> <br>
		<!-- <a href = "JSP/profile.jsp" target = "menu"> Profile </a> <br> -->
		<button type = "submit" value ="Change Password" name = "action"> Change Password </button> <br>
		<!-- <a href = "JSP/changePassword.jsp" target = "menu"> Change Password </a> <br> -->
		<button type = "submit" value ="Account Details" name = "action"> Account Details </button> <br>
		<!-- <a href = "JSP/accountDetails.jsp" target = "menu"> Account Details </a> <br> -->
		<button type = "submit" value ="Account Statement" name = "action"> Account Statement </button> <br>
		<!-- <a href = "JSP/statement.jsp" target = "menu"> Account Statement </a> <br> -->
   		<button type = "submit" value ="Account Request" name = "action"> Send Account Request </button> <br>
	<!-- <button style = "font-size:20px; width:100%; border:groove; border-color:skyblue" type = "submit" value ="Customer ID Request" name = "action"> Send Customer Request </button> <br> -->
	</form>
	<form action = "../myServlet" method = "post" target = "_parent">
		<button type = "submit" value ="Logout" name = "action"> Logout </button>
		<!-- <a href = "JSP/UserLogin.jsp"> Logout </a> <br> -->
	</form>
</div>
</body>
</html>