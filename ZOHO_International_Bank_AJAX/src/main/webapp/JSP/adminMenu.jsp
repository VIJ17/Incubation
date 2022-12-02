<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Admin Menu</title>
<style type="text/css">
.back-ground
{
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

	<p style = "padding-left:5%; font-size:23px; font-weight:400; font-family: system-ui"> WELCOME &nbsp; ${ userDetails.getName() } </p>
	
	<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
		<button type = "submit" value ="Home" name = "action"> Home </button> <br>
		<!-- <a href = "JSP/profile.jsp" target = "menu"> Home </a> <br> -->
		<button type = "submit" value ="Admin Deposit" name = "action"> Deposit </button> <br>
		<!-- <a href = "JSP/deposit.jsp" target = "menu"> Deposit </a> <br> -->
		<button type = "submit" value ="Add New User" name = "action"> Create User </button> <br>
		<!-- <a href = "JSP/addNewUser.jsp" target = "menu"> Add New User </a> <br> -->
		<button type = "submit" value ="Create Account" name = "action"> Create Account </button> <br>
		
		<button type = "submit" value ="Complete Account Details" name = "action"> Account Details </button> <br>
		<!-- <a href = "JSP/completeAccountDetails.jsp" target = "menu"> CompleteAccountDetails </a> <br> -->
		<button type = "submit" value ="Account Statement" name = "action"> Account Statement </button> <br>
		<!-- <a href = "JSP/statement.jsp" target = "menu"> Account Statement </a> <br> -->
		<button type = "submit" value ="Account Requests" name = "action"> Account Request </button> <br>
		<!-- <a href = "JSP/accountRequest.jsp" target = "menu"> Account Requests </a> <br> -->
		<button type = "submit" value ="Customer Requests" name = "action"> Customer Request </button> <br>
		<!-- <a href = "JSP/customerRequest.jsp" target = "menu"> Account Requests </a> <br> -->
		<button type = "submit" value ="Transaction Requests" name = "action"> Transaction Request </button> <br>
		<!-- <a href = "JSP/transactionRequest.jsp" target = "menu"> Transaction Requests </a> <br> -->
	</form>
	
</div>
</body>
</html>