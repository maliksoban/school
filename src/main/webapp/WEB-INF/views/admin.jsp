<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Hello World!</title>
</head>
<body class="security-app">
	<div class="details">
		<h2 align="center">ADMIN PAGE</h2>
	</div>

		<h1 align="center">
			<b> Hello <c:out value="${pageContext.request.remoteUser}"></c:out> You Have Following Credentials To Perform</b>
		</h1>
	<table border="1" cellpadding="5" cellspacing="2" align="center">
		<thead align="center">
		<tr align="center">
			<td align="center" bgcolor="#808080">Operation To Perform</td>
			<td></td>
			<td></td>
			<td></td>
		<td bgcolor="#a52a2a">
			<form action="/login" method="post">
				<input type="submit" value="Sign Out" />
			</form>
		</td>
		</tr>
		</thead>
		<tbody>
		<tr align="center" bgcolor="#7fffd4">
			<td>
				Role Method :
			</td>
			<td>
				<form action="/admin/addRole">
					<button type="submit">Add Role</button>
				</form>
			<td>
				<form action="/admin/deleteRole">
					<button type="submit">Delete Role</button>
				</form>
			</td>
			<td>
				<form action="/admin/updateRoleId">
					<button type="submit">Update Role</button>
				</form>
			</td>
			<td>
				<form action="/admin/viewRoles">
					<button type="submit">View Role</button>
				</form>
			</td>
		</tr>

		<tr align="center" bgcolor="#8fbc8f">
			<td>
			User Method :
			</td>
			<td>
				<form action="/admin/addUser" method="get">
				<button type="submit">Add User</button>
				</form>
			</td>
			<td>
				<form action="/admin/deleteUser">
				<button type="submit">Delete User</button>
				</form>
			</td>
			<td>
				<form action="/admin/updateUserId">
				<button type="submit">Update User</button>
				</form>
			</td>
			<td>
				<form action="/admin/viewUsers" method="get">
					<button type="submit">View User</button>
				</form>
			</td>
		</tr>

		<tr align="center" bgcolor="#8fbc8f">
			<td>
				---
			</td>
			<td>
		<form action="/admin/viewDeletedUser" method="get">
			<button type="submit">View Deleted User</button>
		</form>
			</td>
			<td>
			<form action="/admin/pendingrequest" method="get">
				<button type="submit">View Pending Requests</button>
			</form>
			</td>
			<td>
		<form action="/admin/changePassword" method="get">
			<button type="submit">Change Password</button>
		</form>
			</td>
			<td>
				<form action="/admin/viewGuestUser" method="get">
					<button type="submit">View Guest Users</button>
				</form>
			</td>
		</tr>
		<tr>
		<td>
			<form action="/admin/addOffice" method="get">
				<button type="submit">ADD Office</button>
			</form>
		</td>
			<td>
				<form action="/admin/addProduct" method="get">
					<button type="submit">ADD Product</button>
				</form>
			</td>
			<td>
				<form action="/admin/addWarehouse" method="get">
					<button type="submit">ADD Warehouse</button>
				</form>
			</td>
			<td>
				<form action="/admin/addCountry" method="get">
					<button type="submit">ADD Country</button>
				</form>
			</td>
			<td>
			<form action="/admin/getCountry" method="get">
				<button type="submit">Get Countries</button>
			</form>
		</td>
		</tr>
		<tr>
			<td>
				<form action="/admin/addProductToWarehouse" method="get">
					<button type="submit">Add Product To Warehouse</button>
				</form>
			</td>
		</tr>
		</tbody>
	</table>

</body>
</html>