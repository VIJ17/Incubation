<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>New User Details</title>
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
}
label
{
	font-size:20px;
}

</style>
</head>
<body>
	<div class = "back-ground">
		<div style = "text-align:center">
		
			<h2 style = "margin-left:0%"> NEW USER ADDED SUCCESSFULLY<br><br>||USER DETAILS|| </h2>
			<p style = "font-size:20px; color:red"> ${ Message } </p>
			<table style = "margin-left:7%">
		
				<tr style = "background-color:#0099ff">
					<th>USER ID</th>
					<th>PASSWORD</th>
					<th>NAME</th>
					<th>MOBILE</th>
					<th>EMAIL</th>
					<th>DATE_OF_BIRTH</th>
					<th>USER_TYPE</th>
				</tr>
				<tr>
					<td>${ userDetails.getUserID() }</td>
					<td>${ userDetails.getPassword() }</td>
					<td>${ userDetails.getName() }</td>
					<td>${ userDetails.getMobile() }</td>
					<td>${ userDetails.getEmailID() }</td>
					<td>${ userDetails.getDateOfBirth() }</td>
					<td>${ userDetails.getUserType() }</td>
				</tr>
			
			</table>
		</div>
	</div>
</body>
</html>