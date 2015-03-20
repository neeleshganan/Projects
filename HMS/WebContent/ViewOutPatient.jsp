<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patient</title>
<script>
	function ValidateRoom() {
		var room = document.form.need.value;
		if (!(room == "")) {
			alert("Updation is done successfully and The patient will be considered to be an InPatient now.");
			return false;
		}
	}
</script>
</head>
<body>
<form name="form" method="post" action="NewServlet" onsubmit="return ValidateRoom()">
<table cellpadding="10" border="1" style="background-color: #ffffcc;">
	<TR>
		<TH>OPD NO</TH>
		<TH>NAME</TH>
		<TH>ADDRESS</TH>
		<TH>GENDER</TH>
		<TH>DEPARTMENT</TH>

		<TH>NEED ICU</TH>
		<TH>NEED ROOM</TH>
	</TR>
	<%
		List<PatientBean> uList = (List<PatientBean>) request
				.getAttribute("pList");
		Iterator<PatientBean> it = uList.iterator();
		while (it.hasNext()) {
			PatientBean pb = it.next();
	%>
	<tr>
		<td><%=pb.getOPDNo()%></td>
		<td><%=pb.getName()%></td>
		<td><%=pb.getAddress()%></td>
		<td><%=pb.getGender()%></td>
		<td><%=pb.getDeptNo()%></td>
		<td align="center"><input type="radio" name="need"
			value="NeedICU" /></td>
		<td align="center"><input type="radio" name="need"
			value="NeedRoom" /></td>
		<td><input type="hidden" name="OPDNo" value="<%=pb.getOPDNo()%>"></input></td>
	</tr>
	<%
		}
	%>
	<tr>
		<td><input type="hidden" name="act" value="value1"></input></td>
	</tr>
</table>
<br />
<br />
<center><input type="submit" name="submit" value="updatePatient"></input>
<br /><br />
<br /><a href="Success.jsp">click here to Go Home</a><br /><br />
<br />
<a href="DoctorLogin.jsp">Logout</a><br /><br />
</center>
</form>
</body>
</html>
