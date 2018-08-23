<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Login</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
  
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<style>
			body, html {
		    height: 70%;
		    margin: 0;
			}
			
			.bg {
			    /* The image used */
			    background-image: url("img/login.jpg");
			
			    /* Full height */
			    height: 100%; 
			
			    /* Center and scale the image nicely */
			    background-position: center;
			    background-repeat: no-repeat;
			    background-size: cover;
			}
</style>
</head>
<body class="bg">

${value }

<div class="card z-index-2" style="background-color: rgba(245,245,245,0.9); margin-left:30%; margin-right:30%; margin-top:10%;">
<center><h2 style="color:blue">Welcome back <%=session.getAttribute("email") %></h2></center>
<div class="card-body">
<form action="login">
<center>
<input type="hidden" name="email" value="<%=session.getAttribute("email") %>">
<input type="password" name="password" placeholder="Your password" class="form-control" required autofocus><br>
<button class="btn btn-info">Login</button>
</center>
</form>
</div>
</div>
</body>
</html>