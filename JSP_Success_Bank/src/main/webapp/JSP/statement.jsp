<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Account Statement </title>
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
	border-bottom: 1px solid #0000cc;
	border-color:#0000cc;
	font-size:20px;
}

button
{
	text-align:center;
	border:groove;
	border-color:#9999ff;
	background-color:#6666ff;
	margin-left:16%;
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
	font-size:20px;
}

td
{
	width:120px;
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
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h2> Account Statement </h2>

	<div class = "back-ground">
		
		<div style = "float:right; padding-right:5%">
			<form action = "<%= request.getContextPath() %>/myServlet" method = "post" target = "actionFrame">
				<table>
				<tr>
					<th style = "width:160px; color:black"> <label for = "accountNo"> Account No </label> </th>
					<th>
						<select name= "accountNo" id = "accountNo" required>
							<c:choose>
								<c:when test="${ accountNo == null }">
									<option value="" disabled selected>Select an Account</option>
								</c:when>
								<c:otherwise>
									<option value="" disabled selected> ${ accountNo } </option>
								</c:otherwise>
							</c:choose>
							<c:forEach items="${ activeAccountsList }" var="entry">
								<option value = "${entry.value}">${entry.value}</option>
							</c:forEach>
						</select>
					</th>
					<th> <button value = "Account Statement" name = "action"> Ok </button> </th>
				</tr>
				</table>
			</form>
		</div>
		
		<p style = "padding-left:4%; font-size:20px; color:red"> ${ Message } </p>
		
		<c:if test="${ transactionList.size() > 0 }">
			<table style = "margin-left:2%; margin-right:2%; margin-bottom:5%">
			
				<tr style = "background-color:#3333cc">
					<th>CUSTOMER ID</th>
					<th>ID</th>
					<th>REFERENCE ID</th>
					<th>PRIMARY ACC</th>
					<th>SECONDARY ACC</th>
					<th>AMOUNT</th>
					<th>CLOSING BALANCE</th>
					<th>TRANSACTION TIME</th>
					<th>MODE OF TRANSACTION</th>
					<th>TYPE</th>
					<th>STATUS</th>
					<th>REMARKS</th>
				</tr>
				<c:forEach items="${ transactionList }" var="entry">
					<tr>
						<td>${ entry.getCustomerID() }</td>
						<td>${ entry.getID() }</td>
						<td>${ entry.getReferenceID() }</td>
						<td>${ entry.getPrimaryAccount() }</td>
						<td>${ entry.getSecondaryAccount() }</td>
						<td>${ entry.getAmount() }</td>
						<td>${ entry.getClosingBalance() }</td>
						<td> <jsp:useBean id="myDate" class="java.util.Date"/>  
		    				 <c:set target="${myDate}" property="time" value="${ entry.getMilliSeconds() }"/>    
		   		 			 <p>${myDate}</p>
		   		 		</td>
						<td>${ entry.getModeOfTransaction() }</td>
						<td>${ entry.getType() }</td>
						<td>${ entry.getStatus() }</td>
						<td>${ entry.getRemarks() }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>