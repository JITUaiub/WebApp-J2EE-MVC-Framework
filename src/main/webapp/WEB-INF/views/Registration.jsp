<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
		<title>Registration</title>
	</header>

	<body>
		<div id="logo" align="center">
			<a href="/FreameworkTest/"><h1>LOGO<br/></h1></a>
			<hr size="3"/>
		</div>

		<div id="navMenu">
			<table width="100%">
				<tr align="center" valign="top">
					<td width="20%">&nbsp;</td>
					<td width="20%"><a href="login">Login</a></td>
					<td width="20%"><a href="registration">Register</a></td>
					<td width="20%">&nbsp;</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
			</table>
		</div>

		<div id="regForm">
			<form action="registration" method="post" name="registrationForm">
				<h1 align="center" valign="top">Registration</h1>
				<table align="center" valign="top" width="50%">
					<tr>
						<td>
							<fieldset>
								<table align="center" valign="top">
									<%
										String errorMsg = "";
										if(request.getAttribute("errorMsg") != null)
											errorMsg = request.getAttribute("errorMsg").toString();
									%>
									<tr>
										<td><div id="errorMsg" style="color: RED">
											<% out.println(errorMsg); %>
										</div></td>
									</tr>
									<tr>
										<td><strong>Username</strong></td>
										<td><strong>:</strong></td>
										<td><input type="text" name="userName" value="<% 
										String value = request.getParameter("userName");
										if(value == null)
											out.println("");
										else
											out.println(value);
											%>"/></td>
									</tr>
									
									<tr>
										<td><strong>Password</strong></td>
										<td><strong>:</strong></td>
										<td><input type="password" name="password" value="<% 
										String value2 = request.getParameter("password");
										if(value2 == null)
											out.println("");
										else
											out.println(value2);
											%>"/></td>
									</tr>
									<tr>
										<td><strong>Name</strong></td>
										<td><strong>:</strong></td>
										<td><input type="text" name="name" value="<% 
										String value3 = request.getParameter("name");
										if(value3 == null)
											out.println("");
										else
											out.println(value3);
											%>"/></td>
									</tr>
									<tr>
										<td><strong>Date of Birth</strong></td>
										<td><strong>:</strong></td>
										<td><input type="date" name="dob" value="<% 
										String value5 = request.getParameter("dob");
										if(value5 == null)
											out.println("");
										else
											out.println(value5);
											%>"/></td>
									</tr>
									<tr>
										<td><strong>Gender</strong></td>
										<td><strong>:</strong></td>
										<td>
											<input type="radio" name="gender" value="Male" checked="checked"> Male
											<input type="radio" name="gender" value="Female"> Female
											<input type="radio" name="gender" value="Other"> Other
										</td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td colspan="3" align="center"><input type="submit" name="reg" value="Register Now" /></td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>