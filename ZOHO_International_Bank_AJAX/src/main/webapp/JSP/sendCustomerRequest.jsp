<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Create Customer ID Request </title>
<style type="text/css">

label
{
	font-size:25px;
}

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:27%;
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

table
{
	margin-left:60px;
}

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:40%;
	height:30vh;
}

h2
{
	padding-left:1%;
	font-size:30px;
	background-color:#3333cc;
	color:white;
}

.heading
{
	font-size:30px;
	font-weight:800;
	background-color:#3333cc;
	color:white;
}

.para
{
	color:white;
	font-size:60px;
	font-weight:800;
	padding:2%;
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
		
		<img style = "padding-right:1%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png2.png" alt="Request Image">
		<img style = "padding-right:2%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png3.png" alt="Request Image">
		<p class = "para"> <span style="color: #b30000">Z</span><span style="color: #00b300">O</span><span style="color: #0099ff">H</span><span style="color: #ffcc00">O</span> International Bank </p>
		
	</header>

<h2> Create Customer ID Request </h2>

<div >
	<div style = "background-color:#3333cc; margin-top:0px">
		<p class = "heading" style = "margin-left:38%"> Your Customer ID is Inactive </p>
		<p class = "heading" style = "margin-left:33%">  To Active your ID make a request to Admin </p>
	</div>
	
	<img style = "padding-left:8%; float:left; height:40%; width:15%" src="<%= request.getContextPath() %>/images/png23.png" alt="Request Image">
	<img style = "padding-right:10%; float:right; height:40%; width:15%" src="<%= request.getContextPath() %>/images/png22.png" alt="Request Image">
	
	<div style = "margin-left:28%" class = "border">

		<div style = "margin-top:5%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "_parent">
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "customerID"> Customer ID </label> </th>
					<th> <input type = "number" value = "${ userDetails.getUserID() }" name = "customerID" placeholder = "${ userDetails.getUserID() }" readonly>
				</tr>
				</table><br>
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "customerStatus"> Customer Status </label> </th>
					<th> <input type = "text" value = "${ customerDetails.getCustomerStatus() }" name = "customerStatus" placeholder = "${ customerDetails.getCustomerStatus() }" readonly>
				</tr>
				</table><br>
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "description"> Request Message </label> </th>
					<th> <input type = "text" type = "text" id = "description" name = "description" placeholder = "Type a Message"> </th>
				</tr>
				</table> <br><br>
				<button value = "Send Customer ID Request" name = "action"> Send Request </button>
				<button style = "margin-left:1%" type = "submit" value ="Logout" name = "action"> Cancel </button> <br>
			</form>
		</div>
	</div>
</div>
</body>
</html>