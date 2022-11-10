<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> Customer Layer </title>
<style>

.back-ground
{
	background-image:url(<%= request.getContextPath() %>/images/34.jpg);
	overflow:hidden;
}

.para
{
	color:white;
	font-size:60px;
	font-weight:800;
	padding:2%;
}

</style>
</head>
<body class = "back-ground">
	
	<header style="background-color:#3333cc; height:10vh">
		
		<img style = "padding-right:1%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png2.png" alt="Request Image">
		<img style = "padding-right:2%; float:left; height:10vh" src="<%= request.getContextPath() %>/images/Logo-png3.png" alt="Request Image">
		<p class = "para"> <span style="color: #b30000">Z</span><span style="color: #00b300">O</span><span style="color: #0099ff">H</span><span style="color: #ffcc00">O</span> International Bank </p>
		
	</header>
	<div style = "height:90vh; overflow:hidden; display:flex">
		<div style = "overflow:hidden; width:15%; height:100vh">
		
			<iframe src = "JSP/customerMenu.jsp" style = "width:100%; height:1000px; border:none"></iframe>
		
		</div>
		<div style = "overflow:hidden; width:85%; height:100vh">
		
			<iframe src = "JSP/home.jsp" name = "actionFrame" style = "width:100%; height:1000px; border:none"></iframe>
		
		</div>
	</div>
</body>
</html>