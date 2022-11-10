<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
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
	
	<p style = "padding-left:4%; font-size:20px; color:red"> ${ Message } </p>

</div>
</body>
</html>