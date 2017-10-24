<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied</title>
</head>
<body>
	<h3>Dear <strong>${loggedinuser}</strong>, You are not authorized to access this page.</h3>
	<h2> <a href="<c:url value="/logout" />">Logout</a></h2>
	<h1>Click to go back to <a href="/home" >Home</a></h1>
</body>
</html>