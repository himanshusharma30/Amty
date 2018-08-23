<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="test.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Dashboard</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="css/mdb.min.css" rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
body, html {
	height: 70%;
	margin: 0;
	
}

.bg {
	/* The image used */
	background-image: url("img/dashboard.jpg");
	
	/* Full height */
	height: 70%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<script>
function preventBack() {
	window.history.forward();
}
setTimeout("preventBack()", 0);
window.onunload = function() {
	null
};
</script>
</head>
<body class="bg">
	<div align="center" class="z-index-4"
		style="margin-top: 10%; color: white; opacity: 1.0;">
		<h1>
			<b>Welcome On Board <%=session.getAttribute("user")%></b>
		</h1>
	</div>
	<div class="jumbotron z-index-1" style="color:black;opacity:0.8;margin-right:5%;margin-left:5%;">Lorem Ipsum is simply dummy text of the
		printing and typesetting industry. Lorem Ipsum has been the industry's
		standard dummy text ever since the 1500s, when an unknown printer took
		a galley of type and scrambled it to make a type specimen book. It has
		survived not only five centuries, but also the leap into electronic
		typesetting, remaining essentially unchanged. It was popularised in
		the 1960s with the release of Letraset sheets containing Lorem Ipsum
		passages, and more recently with desktop publishing software like
		Aldus PageMaker including versions of Lorem Ipsum</div>

</body>
</html>