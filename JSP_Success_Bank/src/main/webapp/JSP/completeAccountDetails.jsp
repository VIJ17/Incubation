<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Account Details </title>
<style type="text/css">
.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	background-size:100% 100%;
	height:56em;
	width:100%;
}

td
{
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

</style>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2> Account Details </h2>

<div class = "back-ground">
	
	<div>
		<table style = "height:250px; width:1100px; margin-left:15%">
		
			<tr style = "background-color:#3333cc">
				<th>CUSTOMER ID</th>
				<th>ACCOUNT NO</th>
				<th>ACC_TYPE</th>
				<th>ACC_STATUS</th>
				<th>IFSC_CODE</th>
				<th>BRANCH</th>
				<th>BALANCE</th>
			</tr>
				<c:forEach items="${ completeAccountsMap }" var="innerMap">
					<c:forEach items="${innerMap.value}" var="entry">
						<tr>
							<td>${ entry.value.getCustomerID() }</td>
							<td>${ entry.value.getAccountNo() }</td>
							<td>${ entry.value.getAccountType() }</td>
							<td>${ entry.value.getAccountStatus() }</td>
							<td>${ entry.value.getIfscCode() }</td>
							<td>${ entry.value.getBranch() }</td>
							<td>${ entry.value.getBalance() }</td>
						</tr>
					</c:forEach>
				</c:forEach>
		</table>
	</div>
	<img style = "float:left; height:20%; width:15%" src="<%= request.getContextPath() %>/images/png17.png" alt="Request Image">
	<img style = "float:right; height:20%; width:15%" src="<%= request.getContextPath() %>/images/png17a.png" alt="Request Image">
</div>
</body>
</html>