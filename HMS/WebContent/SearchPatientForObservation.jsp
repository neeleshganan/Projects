<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Observation</title>
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
<body><center>
<form action="NewServlet" method="post" onsubmit="javascript:return validate();">
<table border="0" align="center">
	<tr>
		<td>OPD No:</td>
		<td><input type="text" name="searchOpdNo" value=""></input></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" name="submit" value="search"></input></center>
		</td>
	</tr>
</table>
</form>
<br /><a href="Success.jsp">click here to Go Home</a><br /><br />
<br />
<a href="DoctorLogin.jsp">Logout</a><br /><br /></center>
</body>
</html>