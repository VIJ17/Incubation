<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Online Transfer </title>
<style type="text/css">

select
{
	border:none;
	background:transparent;
	border-bottom: 2px solid #0000cc;
	border-color:#0000cc;
	font-size:20px;
	width:130%;
}

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:48%;
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
	width:250px;
	border:none;
	background:transparent;
	border-bottom: 2px solid #0000cc;
}

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:35%;
	height:35vh;
}

label
{
	font-size:25px;
}

h2
{
	padding-left:1%;
	font-size:30px;
	background-color:#3333cc;
	color:white;
}

back-ground
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

<h2> Transfer </h2>

<div class = "back-ground">
	<img style = "padding-left:10%; padding-top:3%; float:left; height:40%; width:15%" src="<%= request.getContextPath() %>/images/png9.png" alt="Transfer Image">
	<img style = "padding-right:10%; padding-top:3%; float:right; height:40%; width:15%" src="<%= request.getContextPath() %>/images/png7.png" alt="Transfer Image">
	<div style = "margin-left:30%" class = "border">

		<div style = "margin-top:7%; margin-left:3%">
		<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
			<table>
			
			<tr>
				<th style = "width:250px; text-align:left; font-size:25px"> <label for = "fromAccountNo"> From Account </label> </th>
				<th style = "font-size:15px">
					<select name= "fromAccountNo" required>
					<option value="">Select an Account</option>
						<c:forEach items="${ activeAccountsList }" var="entry">
							<option value = "${entry.value}">${entry.value}</option>
						</c:forEach>
					</select>
				</th>
			</tr>
			</table><br>
			<table>
			<tr>
				<th style = "width:250px; text-align:left; font-size:25px"> <label for = "toAccountNo"> To Account </label> </th>
				<th> <input type = "number" id = "toAccountNo" name = "toAccountNo" placeholder = "Enter Receiver Account" required> </th>
			</tr>
			</table><br>
			<table>
			<tr>
				<th style = "width:250px; text-align:left; font-size:25px"> <label for = "amount"> Amount </label> </th>
				<th style = "font-size:15px"> <input type = "number" id = "amount" name = "amount" min = "1" max = "5000000" placeholder = "Enter Amount" required> </th>
			</tr>
			</table><br>
			<table>
			<tr>
				<th style = "width:250px; text-align:left; font-size:25px"> <label for = "description"> Remarks </label> </th>
				<th style = "font-size:15px"> <input type = "text" id = "description" name = "description" placeholder = "Remarks"> </th>
			</tr>
			</table> <br>
			<p style = "margin-left:7%; font-size:20px; background-color:#e6e6ff%; color:red"> ${Message} </p>
			<button value = "Make Transfer" name = "action"> Transfer </button>
		</form>
		</div>
	</div><br>
	<img style = "padding-top:1%; padding-left:4%; float:left; height:38%; width:38%" src="<%= request.getContextPath() %>/images/png11.png" alt="Transfer Image">
</div>
</body>
</html>