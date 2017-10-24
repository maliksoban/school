<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update Role</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function sendData() {

            var json = {
                "roleId":parseInt(document.getElementById('role').value),
                "roleName": document.getElementById('roleName').value};
            $.ajax({
                url: '../saveRole',
                type: 'POST',
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function () {
                    alert("Role Updated Successfull: " + json.roleName);
                },
                error: function () {
                    alert(" Failed to Update Role: " + json.roleName);
                }
            });

        }

    </script>
</head>
<body>

<h1>Edit Roles</h1>
<c:set var="user" value="${command}"></c:set>
role:<input type="text" id="role" value="${user.id}" readonly><br/>
RoleName:<input type="text" id="roleName" name="roleName" value="${user.roleName}"/><br/>
<button type="submit" onclick="sendData()">Update Role</button>
<form action="../back">
    <button type="submit">Back</button>
</form>
</body>
</html>