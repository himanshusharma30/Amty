<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
  
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Admin Login</title>
</head>
<body>
<center><h1>RoomMarket</h1></center>
<div class="container" align="center">
<h2>Admin Login</h2>
<div>${info } </div>
<div>${error }</div>
<form:form action="adminlogin" method="post" modelAttribute="admin">
<div class="row mb-1">
<div class="col-lg-6" align="center">
Email
</div>
<div class="col-lg-6" align="center">
<form:input path="email" required="required"/>
</div>
</div>
<div class="row mb-1">
<div class="col-lg-6" align="center">
Password
</div>
<div class="col-lg-6" align="center">
<form:password path="password" required="required"/>
</div>
</div>
<div class="row mb-1">
<div class="col-lg-12" align="center">
<button class="btn btn-success">Login</button>
</div>
</div>
</form:form>
</div>
</body>
</html>