<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

button
{
	color:#f3e6ff;
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:34.5%;
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

.border
{
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 50px #f3e6ff;
	width:40%;
	height:63vh;
}

.radio
{
	text-align:left;
	font-size:20px;
	border:none;
	background:transparent;
}

label
{
	font-size:20px;
}

.lable-th
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

<h2 style = "font-size:30px"> Create Account </h2>

<div class = "back-ground">
	
	<img style = "padding-top:8%; padding-right:5%; float:right; height:35%; width:15%" src="<%= request.getContextPath() %>/images/png18.png" alt="Request Image">
	<img style = "padding-top:8%; padding-left:5%; float:left; height:35%; width:15%" src="<%= request.getContextPath() %>/images/png18a.png" alt="Request Image">
	<div style = "margin-left:30%" class = "border">
		
		<div style = "margin-top:5%; margin-left:3%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th class = "lable-th"> <label for = "customerID"> Customer ID </label> </th>
					<th> <input type = "number" id = "customerID" name = "customerID" placeholder = "Customer ID" value = "${ customerID }" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "panNo"> PAN No </label> </th>
					<th> <input type = "text" id = "panNo" name = "panNo" placeholder = "PAN" required>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "aadharNo"> Aadhar </label> </th>
					<th> <input type = "text" id = "aadharNo" name = "aadharNo" placeholder = "Aadhar" required>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "address"> Address </label> </th>
					<th> <input type = "text" id = "address" name = "address" placeholder = "Address" required>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for= "customerStatus"> Customer Status </label> </th>
					<th> <input class = "radio" type="radio" id="active" name="customerStatus" value="ACTIVE" required>
  						 <label for="active"> Active </label>
						 <input class = "radio" type="radio" id="inactive" name="customerStatus" value="INACTIVE" required>
  						 <label for="inactive"> Inactive </label>
					</th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for= "accountType"> Account Type </label> </th>
					<th> <input class = "radio" type="radio" id="current" name="accountType" value="CURRENT" required>
  						 <label for="current"> Current </label>
						 <input class = "radio" type="radio" id="savings" name="accountType" value="SAVINGS" required>
  						 <label for="savings"> Savings </label>
						 <input class = "radio" type="radio" id="dmat" name="accountType" value="DMAT" required>
  						 <label for="dmat"> DMAT </label>
					</th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for= "accountStatus"> Account Status </label> </th>
					<th> <input class = "radio" type="radio" id="Active" name="accountStatus" value="ACTIVE" required>
  						 <label for="Active"> Active </label>
						 <input class = "radio" type="radio" id="Inactive" name="accountStatus" value="INACTIVE" required>
  						 <label for="Inactive"> Inactive </label>
					</th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "ifscCode"> IFSC Code </label> </th>
					<th> <input type = "text" id = "ifscCode" name = "ifscCode" placeholder = "IFSC Code" required> </th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for= "branch"> Branch </label> </th>
					<th> <input class = "radio" type="radio" id="karaikudi" name="branch" value="KARAIKUDI" required>
  						 <label for="karaikudi"> Karaikudi </label>
						 <input class = "radio" type="radio" id="madurai" name="branch" value="MADURAI" required>
  						 <label for="madurai"> Madurai </label>
						 <input class = "radio" type="radio" id="trichy" name="branch" value="TIRUCHIRAPPALLI" required>
  						 <label for="trichy"> Trichy </label>
					</th>
				</tr>
				</table><br>
				<table>
				<tr>
					<th class = "lable-th"> <label for = "balance"> Balance </label> </th>
					<th> <input type = "number" id = "balance" name = "balance" min = "1000" placeholder = "Balance" required> </th>
				</tr>
				</table><br>
				
				<p style = "padding-left:32%; font-size:20px; color:red"> ${ Message } </p>
				<button type = "submit" value = "Create Account" name = "action"> Create Account </button>
			</form>
		</div>
	</div>
</div>
</body>
</html>