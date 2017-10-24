<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <title>Update Role</title>
    <script>
        function updateRole() {
            var role=document.getElementById('role').value;
            location.href='/admin/editRole/'+role;
        }
    </script>
</head>
<body>
${message}
Enter ID To Update:<input type="text" id="role" name="role"/><br/>
<input type="submit" value="Update Role" onclick="updateRole()" >
<form action="back">
    <button type="submit">Back</button>
</form>
</body>
</html>