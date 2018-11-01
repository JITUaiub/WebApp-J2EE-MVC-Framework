<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User - Home</title>
	</head>
	<body>
		<h1 align="center">Profile</h1>
		<div align="center">
			<table border="1" cellpadding="0" cellspacing="0" width="60%" align="center">
				<tr>
					<td><strong>User Name:</strong></td>
					<td>:</td>
					<td><% out.print(session.getAttribute("userName")); %></td>
				</tr>
				<tr>
					<td><strong>Name:</strong></td>
					<td>:</td>
					<td> <% out.print(session.getAttribute("name")); %></td>
				</tr>
				<tr>
					<td><strong>Date of Birth:</strong></td>
					<td>:</td>
					<td> <% out.print(session.getAttribute("dob")); %></td>
				</tr>
				<tr>
					<td><strong>Gender:</strong></td>
					<td>:</td>
					<td><% out.print(session.getAttribute("gender")); %></td>
				</tr>
			</table>
			<br/><br/>
			<form action="logout"><input type="submit" name="logout" value="Log Out"></form>
		</div>
	</body>
</html>