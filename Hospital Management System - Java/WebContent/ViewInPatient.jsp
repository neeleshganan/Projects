<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View one  In-Patient</title>
</head>
<body><center>
<table cellpadding="10" border="1" style="background-color: #ffffcc;">
	<TR>
		<TH>OPD NO</TH>
		<TH>NAME</TH>
		<TH>ADDRESS</TH>
		<TH>GENDER</TH>
		<TH>DEPARTMENT</TH>
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
	</tr>
	<%
		}
	%>
</table>
<br /><a href="Success.jsp">click here to Go Home</a><br /><br />
<br />
<a href="DoctorLogin.jsp">Logout</a><br /><br /></center>
</body>
</html>
