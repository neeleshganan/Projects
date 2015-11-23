<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<script>
	function viewAllOutPatient() {
		document.formname1.method="GET";
		document.formname1.caseAction.value="out";
		document.formname1.caseAction1.value=null;  
		document.formname1.action="NewServlet?caseAction=out";
		document.formname1.submit();
	}
	function viewAllInPatient() {
		document.formname1.method="GET";
		document.formname1.caseAction.value=null;  
		document.formname1.caseAction1.value="in";
		document.formname1.action="NewServlet?caseAction1=in";
		document.formname1.submit();
	}
</script>
</head>
<body>
<center>
<h2>
<%
	String msg = request.getParameter("msg");
	if (msg != null) {
%><%=msg%> <%
 	}
 %>
</h2>
</center>

VIEW PATIENT INFORMATION:
<form name="formname1">
	<a href="javascript:viewAllOutPatient()">View All OutPatients</a>
	<input type="hidden" name="caseAction" value="" /><br />
	<a href="javascript:viewAllInPatient()">View All InPatients</a>
	<input type="hidden" name="caseAction1" value="" />
</form>
<br />
<a href="SearchOutPatient.jsp">Search Particular OutPatient</a>
<br />
<a href="SearchInPatient.jsp">Search Particular InPatient</a>
<br />
<br />
<br />
<br />

OBSERVATION FOR PATIENT:
<br />
<a href="SearchPatientForObservation.jsp">Search a Patient for
Observation</a>
<br />
<br />
<br />

VIEW APPOINTMENTS:
<br />
<a href="ViewAppointment.jsp">View Appointment</a>
<br />
<br /><br />
<a href="DoctorLogin.jsp">Logout</a><br /><br />
</body>
</html>
