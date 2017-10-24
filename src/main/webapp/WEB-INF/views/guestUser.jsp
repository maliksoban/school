<%--
  Created by IntelliJ IDEA.
  User: MalikSoban
  Date: 28/08/2017
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guest User</title>
</head>
<body>
<h1>This is your profile page dear <strong>${pageContext.request.remoteUser}</strong> </h1>
Click to go back to <a href="/home" >Home</a>
</body>
</html>
