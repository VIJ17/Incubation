<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>

<meta charset="UTF-8">
<title>New User Details</title>
<style type="text/css">

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
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

td
{
	height:25%;
	text-align:center;
	background-color:#e6e6ff;
}

th
{
	color:#e6e6ff;
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
	<div class = "back-ground">
		<div style = "text-align:center">
		
			<h2 style = "margin-left:0%"> NEW USER ADDED SUCCESSFULLY<br><br>||USER DETAILS|| </h2>
			
			<table>
		
				<tr style = "background-color:#3333cc">
					<th>USER ID</th>
					<th>PASSWORD</th>
					<th>NAME</th>
					<th>MOBILE</th>
					<th>EMAIL</th>
					<th>DATE_OF_BIRTH</th>
					<th>USER_TYPE</th>
				</tr>
				<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
					<tr>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "userID" name = "userID" value = "${ userDetails.getUserID() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "password" id = "password" name = "password" value = "${ userDetails.getPassword() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "text" id = "name" name = "name" value = "${ userDetails.getName() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "mobile" name = "mobile" value = "${ userDetails.getMobile() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "email" id = "emailID" name = "emailID" value = "${ userDetails.getEmailID() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "email" id = "dateOFBirth" name = "dateOFBirth" value = "${ userDetails.getDateOfBirth() }" readonly> </td>
						<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "email" id = "userType" name = "userType" value = "${ userDetails.getUserType() }" readonly> </td>
					</tr>
			</table> <br><br>
				<c:set var = "type" scope = "request" value = "CUSTOMER"/>
					<c:if test = "${ userDetails.getUserType().equals(type) }">
						<button type = "submit" value = "Create Account" name = "action"> Create Account </button>
					</c:if>
				</form>
		</div>
	</div>
</body>
</html>