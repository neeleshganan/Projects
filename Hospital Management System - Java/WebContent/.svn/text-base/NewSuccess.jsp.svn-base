<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<div id="container" style="width: 1200px">

<div id="header" style="background-color: cyan;">
<h1 style="margin-bottom: 0;" align="center">Hospital Management
System</h1>
</div>

<div id="menu"
	style="background-color: #FFD700; height: 750px; width: 300px; float: left;">
<a href="z:HMS\26.6.12\HMS_home.html"> GO TO HOME</a><br />
</div>

<div id="content"
	style="background-color: #EEEEEE; height: 750px; width: 400px; float: left;">
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

VIEW PATIENT INFORMATION:<br />
<a href="ViewAllOutPatient.jsp">View All OutPatients</a><br />
<a href="ViewAllInPatient.jsp">View All InPatients</a><br />
<a href="SearchOutPatient.jsp">Search Particular OutPatient</a><br />
<a href="SearchInPatient.jsp">Search Particular InPatient</a><br />
<br />
<br />
<br />

OBSERVATION FOR PATIENT:<br />
<a href="SearchPatientForObservation.jsp">Search a Patient for
Observation</a><br />
<br />
<br />

VIEW APPOINTMENTS:<br />
<a href="ViewAppointment.jsp">View Appointment</a><br />
</div>

<div id="footer"
	style="background-color: #FFA500; clear: both; text-align: center;">
Copyright © hms_T5.com</div>

</div>

</body>
</html>