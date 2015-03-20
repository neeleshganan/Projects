<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View OutPatient</title>
<script>
	function validate() {
		var OPDNo = document.form1.OPDNo.value;
		if (OPDNo == "") {
			alert("Enter OPD No!");
			return false;
		}
	}
</script>
</head>
<body>
<center>
<form name="form1" method="POST" action="NewServlet"
	onsubmit="javascript:return validate();">
<table border="1" align="right">
	<tr>
		<td>OPD No:</td>
		<td><input type="text" name="OPDNo" value=""></input></td>

		<td colspan="2" align="center"><input type="submit" name="submit"
			value="SearchOneOutPatient"></input></td>
	</tr>
</table>
</form><br /><br /><br />
<br /><a href="Success.jsp">click here to Go Home</a><br /><br />
<br />
<a href="DoctorLogin.jsp">Logout</a><br /><br />
</center>

</body>
</html>