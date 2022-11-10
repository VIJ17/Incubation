<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Customer Request </title>
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
	border:solid;
	border-color:#0000cc;
	font-size:20px;
	width:258px;
	background-color:#e6e6ff;
}

td
{
	text-align:center;
	background-color:#e6e6ff;
	height:5vh;
}

th
{
	color:#e6e6ff;
	height:5vh;
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

<h2 > Customer Request </h2>

<div class = "back-ground">
	<div style = "margin-left:0%">
	
		<c:choose>
			<c:when test="${ customerIDRequestMap != null }">
				<table style = "height:200px; width:1000px; margin-left:8%">
				
					<tr style = "background-color:#3333cc">
						<th>REQUEST_ID</th>
						<th>CUSTOMER ID</th>
						<th>CUS_STATUS</th>
						<th>STATUS</th>
						<th>DESCRIPTION</th>
					</tr>
					<c:forEach items="${ customerIDRequestMap }" var="entry">
					<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
						<tr>
							<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "requestID" name = "requestID" value = "${ entry.value.getRequestID() }" readonly> </td>
							<td> <input style = "font-size:15px; background:none; border:none; text-align:center" type = "number" id = "customerID" name = "customerID" value = "${ entry.value.getCustomerID() }" readonly> </td>
							<td> 
								<select name = "customerStatus" id = "customerStatus">
									<option value = "ACTIVE"> Active </option>
									<option value = "INACTIVE"> Inactive </option>
								</select><br>
							</td>
							<td>
								<select name = "status" id = "status">
									<option value = "APPROVED"> Approve </option>
									<option value = "REJECTED"> Reject </option>
								</select><br>
							</td>
							<td> <input style = "background:none; border:none; text-align:center" type = "text" id = "description" name = "description" value = "${ entry.value.getDescription() }" readonly>
								 <button style = "text-align:center; border:groove; border-color:#33bbff" type = "submit" value = "Respond To Customer Requests" name = "action"> Submit </button>
							</td>
						</tr>
					</form>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<div style = "text-align:center; color:#e6e6ff; font-size:20px">
					<p style = "background-color:#e6e6ff; padding-left:4%; padding-right:4%; font-size:20px; color:red"> No Requests has been Received </p>
				</div>
			</c:otherwise>
		</c:choose>
		<p style = "text-align:center; padding-left:4%; padding-right:4%; font-size:20px; color:red"> ${ Message } </p>
	</div>
</div>
</body>
</html>