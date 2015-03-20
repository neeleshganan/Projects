<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Login Page</title>
<script>
	function validate() {
		var docid = document.form.docid.value;
		var password = document.form.password.value;
		if (docid == "") {
			alert("Enter Doctor ID!");
			return false;
		}
		if (password == "") {
			alert("Enter Password!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<center>
<form name="form" method="post" action="DoctorCheck.jsp"
	onsubmit="javascript:return validate();">
<table>
	<tr>
		<td>Doctor Id</td>
		<td><input type="text" name="docid" value=""></input></td>

		<td>Password</td>
		<td><input type="password" name="password" value=""></input></td>

		<td colspan="2" align="center"><input type="submit" name="submit"
			value="Login"></input></td>
	</tr>
</table>

</form>
</center>
</body>
</html>