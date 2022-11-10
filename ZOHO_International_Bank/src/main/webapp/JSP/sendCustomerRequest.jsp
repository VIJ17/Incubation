<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Create Customer ID Request </title>
<style type="text/css">

.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	background-size:100% 100%;
	height:60em;
	width:100%;
}

input
{
	font-size:20px;
	width:250px;
	border:solid;
	border-color:#0000cc;
	background-color:#e6e6ff;
}

button
{
	border:solid;
	border-color:#0000cc;
	font-size:15px;
	margin-left:20%;
	background-color:#e6e6ff;
}

label
{
	font-size:25px;
}

</style>
</head>
<body>
<div class = "back-ground">
	<h1 style = "margin-left:30%"> <mark style = "background-color:#b3b3ff"> Your Customer ID is Inactive </mark> </h1>
	<h1 style = "margin-left:25%"> <mark style = "background-color:#b3b3ff"> To Active your ID make a request to Admin </mark> </h1>
	<div style = "margin-left:25%">

		<h2 style = "font-size:30px; margin-left:4%"> CREATE CUSTOMER ID REQUEST </h2>
		<div>
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "_parent">
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "customerID"> Customer ID : </label> </th>
					<th> <input style = "background-color:grey" type = "number" value = "${ userDetails.getUserID() }" name = "customerID" placeholder = "${ userDetails.getUserID() }" readonly>
				</tr>
				</table><br>
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "customerStatus"> Customer Status : </label> </th>
					<th> <input style = "background-color:grey" type = "text" value = "${ customerDetails.getCustomerStatus() }" name = "customerStatus" placeholder = "${ customerDetails.getCustomerStatus() }" readonly>
				</tr>
				</table><br>
				<table>
				<tr>
					<th style = "width:250px; text-align:left"> <label for = "description"> Request Message : </label> </th>
					<th> <input type = "text" style = "height:100px; width:500px" type = "text" id = "description" name = "description" placeholder = "Type a Message"> </th>
				</tr>
				</table> <br>
				<button style = "margin-left:19%" value = "Send Customer ID Request" name = "action"> Send Request </button>
				<button style = "font-size:15px; margin-left:1%" type = "submit" value ="Logout" name = "action"> Cancel </button> <br>
			</form>
		</div>
	</div>
</div>
</body>
</html>