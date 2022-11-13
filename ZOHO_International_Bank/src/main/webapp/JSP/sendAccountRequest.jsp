<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Create Account Request </title>
<style type="text/css">

label
{
	font-size:25px;
}

select
{
	border:none;
	background:transparent;
	border-bottom: 1px solid #0000cc;
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
	margin-left:37%;
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

table
{
	margin-left:60px;
}

p
{
	font-size:25px;
}

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:40%;
	height:50vh;
}

h2
{
	padding-left:1%;
	font-size:30px;
	background-color:#3333cc;
	color:white;
}

p
{
	margin-left:7%;
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

<h2> Make Request </h2>

<div class = "back-ground">

<img style = "padding-top:20%; padding-left:1%; float:left; height:40%; width:25%" src="<%= request.getContextPath() %>/images/png2.png" alt="Request Image">
<img style = "padding-right:1%; float:right; height:40%; width:25%" src="<%= request.getContextPath() %>/images/png2.png" alt="Request Image">
	
	<div style = "margin-left:27%" class = "border">
		<div style = "margin-top:5%">
			<img style = "float:left; height:10%; width:10%" src="<%= request.getContextPath() %>/images/png1.png" alt="Request Image">
			<hr style = "margin-left:0%; width:40%">
			
			<p><b> Inactive Accounts </b></p>
			
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th> <input type = "hidden" value = "ACTIVATE" name = "requestType"></th>
				</tr>
				</table>
				<table>
				<tr>
					<th style = "font-size:25px"> <label for = "accountNo"> Account No &nbsp &nbsp &nbsp </label> </th>
					<th style = "font-size:15px">
						<select name= "accountNo" required>
						<option value="">Select an Account</option>
							<c:forEach items="${ inActiveAccountsList }" var="entry">
								<option value = "${entry.value}">${entry.value}</option>
							</c:forEach>
						</select>
					</th>
				</tr>
				</table><br>
				<button type = "submit" value = "Send Account Request" name = "action"> Activate </button>
			</form><br><br>
			<img style = "float:left; margin-top:1.5%; height:10%; width:10%" src="<%= request.getContextPath() %>/images/png1.png" alt="Request Image">
			<hr style = "margin-left:0%; width:40%">
			
			<p><b> Active Accounts </b></p>
			
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th> <input type = "hidden" value = "DEACTIVATE" name = "requestType"></th>
				</tr>
				</table>
				<table>
				<tr>
					<th style = "font-size:25px"> <label for = "accountNo"> Account No &nbsp &nbsp &nbsp </label> </th>
					<th style = "font-size:15px">
						<select name= "accountNo" required>
						<option value="">Select an Account</option>
							<c:forEach items="${ activeAccountsList }" var="entry">
								<option value = "${entry.value}">${entry.value}</option>
							</c:forEach>
						</select>
					</th>
				</tr>
				</table><br>
				<button type = "submit" value = "Send Account Request" name = "action"> Deactivate </button>
			</form>
			
			<div style = "margin-left:15%">
				<p style = "background-color:#e6e6ff; width:${ Message.length() }%; padding-left:4%; padding-right:4%; font-size:20px; color:red"> ${ Message } </p>
			</div>
	<img style = "padding-left:25%; padding-top:14%; float:left; height:50%; width:39%" src="<%= request.getContextPath() %>/images/png3.png" alt="Request Image">
		</div>
	</div>
</div>
</body>
</html>