<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">

.border
{
	margin-left:27%;
	margin-top:5%;
	border:groove;
	border-radius:20px 60px;
	border-color:#e6e6ff;
	box-shadow:15px 15px 20px #f3e6ff;
	width:40%;
	height:43vh;
}

.para
{
	font-weight:100;
	padding:1%;
	margin-top:0px;
}

.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	overflow:hidden;
	background-size:100% 100%;
	height:60em;
	width:100%;
}

</style>
</head>
<body>
<div class = "back-ground">
	<div class = "border">
		<div style = "margin-top:5%; margin-left:3%">
			<p class = "para"> Thank you so much for allowing us to help you with your recent account opening.We are committed to provide our customers with the highest level of service and the most innovative banking products possible.
				<br><br>
				We are very glad you choose us as your financial institution and hope you will take advantage of our wide variety of savings, investment and loan products, all designed to meet your specific needs.
				<br><br>
				For more detailed information about any of our products or services, please refer to our website, www.zohointernationalbank.com, or visit any of our convenient locations. You may contact us by mail at zohointernationalbank@gmail.com.
				<br><br>
				We are concerned about what is best for you!
				<br><br>
				Please do not hesitate to contact us, should you have any questions. We will contact you in the very near future to ensure you are completely satisfied with the service you have received thus far.
				<br><br><span style = "margin-left:65%">	Respectfully </span>
				<br><span style = "margin-left:65%">	ZOHO International Bank</span>
			</p>
		</div>
	</div>
	<p style = "padding-left:4%; font-size:20px; color:red"> ${ Message } </p>

</div>
</body>
</html>