<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Profile </title>
<style type="text/css">

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:35.5%;
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
	border-bottom: 1px solid #0000cc;
}

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:38%;
	height:50vh;
}

.border-admin
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:38%;
	height:40vh;
}

.read-only
{
	background-color:#f3e6ff;
}

label
{
	font-size:20px;
}

th
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2> Profile </h2>

<div class = "back-ground">

	<img style = "padding-left:5%; padding-top:2%; float:left; height:50%; width:18%" src="<%= request.getContextPath() %>/images/png14.png" alt="Request Image">
	<img style = "padding-right:6%; padding-top:2%; float:right; height:50%; width:18%" src="<%= request.getContextPath() %>/images/png12.png" alt="Request Image">
	
	<c:set var = "test" value = "CUSTOMER" />
	<c:if test="${ userDetails.getUserType().equals(test) }">
	
	<div style = "margin-left:30%" class = "border">
		
		<div style = "margin-top:7%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th> <label for = "userID"> User ID </label> </th>
					<th> <input class = "read-only" type = "number" id = "userID" name = "userID" value = "${ userDetails.getUserID() }" readonly> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "name"> Name </label> </th>
					<th> <input type = "text" id = "name" name = "name" value = "${ userDetails.getName() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "mobile"> Mobile No </label> </th>
					<th> <input type = "number" id = "mobile" name = "mobile" value = "${ userDetails.getMobile() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "emailID"> Email ID </label> </th>
					<th> <input type = "email" id = "emailID" name = "emailID" value = "${ userDetails.getEmailID() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "dateOfBirth"> Date Of Birth </label> </th>
					<th> <input class = "read-only" type = "text" id = "dateOfBirth" name = "dateOfBirth" value = "${ userDetails.getDateOfBirth() }" readonly> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "aadharNo"> Aadhar No </label> </th>
					<th> <input class = "read-only" type = "number" id = "aadharNo" name = "aadharNo" value = "${ customerDetails.getAadharNo() }" readonly> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "panNo"> PAN No </label> </th>
					<th> <input class = "read-only" type = "text" id = "panNo" name = "panNo" value = "${ customerDetails.getPanNo() }" readonly> </th>
				</tr>
				</table><br>
				<p style = "margin-left:20%; font-size:20px; color:red"> ${ Message } </p>
				<button type = "submit" value = "Update Profile" name = "action"> Save </button>
			</form>
		</div>
	</div>
	</c:if>
	
	<c:set var = "test" value = "ADMIN" />
	<c:if test="${ userDetails.getUserType().equals(test) }">
	
	<div style = "margin-left:30%" class = "border-admin">
		
		<div style = "margin-top:7%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th> <label for = "userID"> User ID </label> </th>
					<th> <input class = "read-only" type = "number" id = "userID" name = "userID" value = "${ userDetails.getUserID() }" readonly> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "name"> Name </label> </th>
					<th> <input type = "text" id = "name" name = "name" value = "${ userDetails.getName() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "mobile"> Mobile No </label> </th>
					<th> <input type = "number" id = "mobile" name = "mobile" value = "${ userDetails.getMobile() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "emailID"> Email ID </label> </th>
					<th> <input type = "email" id = "emailID" name = "emailID" value = "${ userDetails.getEmailID() }"> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th> <label for = "dateOfBirth"> Date Of Birth </label> </th>
					<th> <input class = "read-only" type = "text" id = "dateOfBirth" name = "dateOfBirth" value = "${ userDetails.getDateOfBirth() }" readonly> </th>
				</tr>
				</table><br>
				<p style = "margin-left:20%; font-size:20px; color:red"> ${ Message } </p>
				<button type = "submit" value = "Update Profile" name = "action"> Save </button>
			</form>
		</div>
	</div>
	</c:if>
</div>
</body>
</html>