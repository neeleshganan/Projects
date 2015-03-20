<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Appointment</title>
</head>
<body><center>
<table cellpadding="10" border="1" style="background-color: #ffffcc;">
	<TR>
		<TH>OPD NO</TH>
		<TH>NAME</TH>
		<TH>GENDER</TH>
		<TH>VISITING TIME</TH>
	</TR>
	<%
		List<PatientAppointment1> uList = (List<PatientAppointment1>) request
			.getAttribute("pList");
			Iterator<PatientAppointment1> it = uList.iterator();
			while (it.hasNext()) {
		PatientAppointment1 pb = it.next();
	%>
	<tr>
		<td><%=pb.getOpdNo()%></td>
		<td><%=pb.getName()%></td>
		<td><%=pb.getGender()%></td>
		<td><%=pb.getVisitingTime()%></td>
	</tr>
	<%
		}
	%>
</table><br /><br />
<br /><a href="Success.jsp">click here to Go Home</a><br /><br />
<br />
<a href="DoctorLogin.jsp">Logout</a><br /><br /></center>
</body>
</html>
