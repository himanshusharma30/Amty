<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Amtica</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="css/mdb.min.css" rel="stylesheet">
  
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
<div class="container">
<h1><b>RoomMarket</b></h1><br>
<h2><b>Market where owners and people in search on room come together</b></h2><hr>
<div class="row" align="right">
<div class="col-lg-12" align="right">
<a href="admin">Admin</a>
</div>
</div>
<form>
<div class="row">

<div class="col-lg-6" align="center">
<button class="btn btn-success" formaction="owner">Owner</button>
</div>
<div class="col-lg-6" align="center">
<button class="btn btn-success" formaction="rental">Need a room</button>
</div>

</div>
</form>
</div>
</body>
</html>