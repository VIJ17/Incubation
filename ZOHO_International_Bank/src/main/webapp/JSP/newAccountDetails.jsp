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
		
			<h2 style = "margin-left:0%"> NEW ACCOUNT ADDED SUCCESSFULLY<br><br>||ACCOUNT DETAILS|| </h2>
			
			<table>
		
				<tr style = "background-color:#3333cc">
					<th>CUSTOMER ID</th>
					<th>ACCOUNT_NO</th>
					<th>ACC_TYPE</th>
					<th>ACC_STATUS</th>
					<th>IFSC_CODE</th>
					<th>BRANCH</th>
					<th>BALANCE</th>
				</tr>
				<tr>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "customerID" name = "customerID" value = "${ accountDetails.getCustomerID() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "accountNo" name = "accountNo" value = "${ accountDetails.getAccountNo() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "text" id = "accountType" name = "accountType" value = "${ accountDetails.getAccountType() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "text" id = "accountStatus" name = "accountStatus" value = "${ accountDetails.getAccountStatus() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "text" id = "ifscCode" name = "ifscCode" value = "${ accountDetails.getIfscCode() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "text" id = "branch" name = "branch" value = "${ accountDetails.getBranch() }" readonly> </td>
					<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "balance" name = "balance" value = "${ accountDetails.getBalance() }" readonly> </td>
				</tr>
			</table>
				
		</div>
	</div>
</body>
</html>