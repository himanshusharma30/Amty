<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page import="java.util.*,test.entity.Property" %>
    <%!
    String property;
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
<title>Owner</title>
</head>
<body>
<%
ArrayList al=(ArrayList)request.getAttribute("property");

%>
<form:form action="postAdvertisement" method="POST" modelAttribute="RoomModel">
<input type="hidden" name="id" value="0"/>
<div class="container" align="center">
<h1><b>RoomMarket</b></h1><br>
<h2><b>Market where owners and people in search on room come together</b></h2>
<h3>Fill up the below details to post your advertisement</h3><br><hr>
<div class="row mb-1">
<div class="col-lg-5">Number of rooms you have</div>
<div class="col-lg-7"><form:input path="rooms" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Number of bedrooms</div>
<div class="col-lg-7"><form:input path="bedrooms" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Number of rooms already occupied</div>
<div class="col-lg-7"><form:input path="occupied" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Email address</div>
<div class="col-lg-7"><form:input type="email" path="email" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Monthly Rent</div>
<div class="col-lg-7"><form:input  path="rent" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Size of rooms</div>
<div class="col-lg-7"><form:select path="size">
<form:option value="Single Bedroom" label="Single bedroom"/>
<form:option value="Double Bedroom" label="Double bedroom"/>
</form:select>
</div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Property type</div>
<div class="col-lg-7"><form:select path="propertyType">
<%
	for(int i=0;i<al.size();i++)
	{
		property=al.get(i)+"";
		%>
			<form:option value="<%=property %>" label="<%=property %>"/>		
		<%
	}
%>
</form:select>
</div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Security deposit</div>
<div class="col-lg-7"><form:input  path="security"/></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Maximum number of roommates allowed</div>
<div class="col-lg-7"><form:input  path="max_roommate" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Internet connection charges included</div>
<div class="col-lg-7"><form:radiobutton path="internet" value="Yes"/>Yes 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton path="internet" value="No"/>No</div>
</div>
<div class="row">
<div class="col-lg-5">Bills included</div>
<div class="col-lg-7"><form:radiobutton path="bills" value="Yes"/>Yes 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton path="bills" value="No"/>No</div>
</div>
<hr>
<h3>Address Details</h3>
<br>
<div class="row mb-1">
<div class="col-lg-5">Address Line 1</div>
<div class="col-lg-7"><form:input path="add1" required="required" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Address Line 2</div>
<div class="col-lg-7"><form:input path="add2"/></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Town</div>
<div class="col-lg-7"><form:input type="text" path="town"/></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">County</div>
<div class="col-lg-7"><form:input type="text" path="county"/></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Post code</div>
<div class="col-lg-7"><form:input type="text" path="postcode" required="required" /></div>
</div>
<hr>
<div class="row mb-1">
<div class="col-lg-5">Title of advertisement</div>
<div class="col-lg-7"><form:input type="text" path="title"/></div>
</div>
<div class="row mb-1">
<div class="col-lg-5">Description(along with rules)</div>
<div class="col-lg-7"><form:textarea path="description" rows="5" cols="30" /></div>
</div>
<div class="row mb-1">
<div class="col-lg-12"><button class="btn btn-success">Proceed to upload photos >>></button></div>
</div>
</div>
</form:form>
</body>
</html>