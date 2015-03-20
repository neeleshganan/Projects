<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
<form name="fom_login" method="post" action="NewServlet">
<input type="hidden" value="loginfom" name="vieworcheck">
<center>
<table border="0">

<tr>
<td>UserId </td>
<td><input type="text" name="userid"></input></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></input></td>
</tr>
<tr>
<td></td>
<td>
<input type="button" name="login" value="login">

</td>
</tr>
</table>
</center>
</form>
</body>
</html>