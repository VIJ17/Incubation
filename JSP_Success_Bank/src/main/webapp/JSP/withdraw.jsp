<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Withdraw </title>
<style type="text/css">
.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	background-size:100% 100%;
	height:56em;
	width:100%;
}

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
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:36%;
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

label
{
	font-size:25px;
}

input
{
	font-size:20px;
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
	width:30%;
	height:20vh;
}

h2
{
	padding-left:1%;
	font-size:30px;
	background-color:#3333cc;
	color:white;
}

</style>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2> Withdraw </h2>

<div class = "back-ground">

	<img style = "padding-left:5%; float:left; height:29%; width:18%" src="<%= request.getContextPath() %>/images/png20.png" alt="Request Image">
	<img style = "padding-right:12%; float:right; height:29%; width:18%" src="<%= request.getContextPath() %>/images/png20.png" alt="Request Image">
	<div style = "margin-left:30%" class = "border">

		<div style = "margin-top:5%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th style = "width:160px; text-align:left"> <label for = "accountNo"> Account No </label> </th>
					<th>
						<select name= "accountNo" required>
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
					<th style = "width:160px; text-align:left"> <label for = "amount"> Amount </label> </th>
					<th> <input type = "number" id = "amount" name = "amount" min = "100" placeholder = "Enter Amount" required> </th>
				</tr>
				</table> <br>
				<p style = "background-color:#e6e6ff; width:${ Message.length() }%; padding-left:8%; padding-right:4%; font-size:20px; color:red"> ${ Message } </p>
				<button value = "Make Withdraw" name = "action"> Withdraw </button>
			</form>
		</div>
	</div><br><br><br><br>
	<img style = "padding-left:25%; float:left; height:45%; width:45%" src="<%= request.getContextPath() %>/images/png32.png" alt="Request Image">
</div>
</body>
</html>