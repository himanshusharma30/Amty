<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,test.entity.Property" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%!
int j=0;
%>
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
<title>Admin Panel</title>
</head>
<%
ArrayList al=(ArrayList)request.getAttribute("prop");
%>
<body>
<center><h1>RoomMarket</h1>
<h2>RootAdmin Panel</h2></center>
<hr>
<div class="container">

<%
for(j=0;j<al.size();j++)
{
	String pro=al.get(j)+"";
	%>
	<form:form action="deleteProperty" method="post" modelAttribute="property">
	<div class="row mb-1" align="center">
	
	<div class="col-lg-6" align="center"><%=pro %></div>
	<form:hidden value="<%=pro %>" path="property_name"/>
	<div class="col-lg-6" ><button class="btn btn-danger">Delete</button></div>
	
	</div>
	</form:form>
<%
}
%>
<hr>
<form:form method="post" action="addProperty" modelAttribute="property" id="addproperty">
<div class="row mb-3" align="center">
<div class="col-lg-6"><form:input path="property_name"/></div>
<div class="col-lg-6"><button class="btn btn-info"> + Add Property</button></div>
</div>
</form:form>
<hr>
<div class="row mb-2">
<div class="col-lg-12"><h3>Change your password</h3></div>
</div>
<form:form action="changepassword" method="post" id="changepwd" modelAttribute="admin">
<form:hidden path="email" value="${adminEmail }" />
<div class="row mb-2">
<div class="col-lg-6">New password</div>
<div class="col-lg-6"><form:password path="password"/></div>
</div>
<div class="row mb-2">
<div class="col-lg-12"><button class="btn btn-info">Change password</button></div>
</div>
</form:form>
<hr>
<div class="row mb-2">
<div class="col-lg-12"><h3>Add a new Admin</h3></div>
</div>
<form:form action="addAdmin" method="post" id="addAdmn" modelAttribute="admin">
<div class="row mb-2">
<div class="col-lg-6">Enter email</div>
<div class="col-lg-6"><form:input path="email" /><font color="red">*${errorAdmin }</font></div>
</div>
<div class="row mb-2">
<div class="col-lg-6">New password</div>
<div class="col-lg-6"><form:password path="password"/></div>
</div>
<div class="row mb-2">
<div class="col-lg-12"><button class="btn btn-info">Add Admin</button></div>
</div>
</form:form>
<div class="row mb-2" align="center">
<div class="col-lg-12">
<a href="logout" class="bg-danger">Logout</a>
</div>
</div>
</div>
</body>
</html>