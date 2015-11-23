<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
</head>
<body>
<form action="FOM_page.jsp" method="post">
 
<%@page import="java.util.*; import model.PatientBeanDD; " %>

	<% 
	
	PatientBeanDD patient=(PatientBeanDD)request.getAttribute("patients");

	%>
<center>
<table border="1">
<tr>
	<td>OPD number:</td>
	<td><%=patient.getOpdNumber()%></td>
</tr>
<tr>
	<td>First Name:</td>
	<td><%=patient.getFirstName()%></td>
</tr>
<tr>
	<td>Last Name:</td>
	<td><%=patient.getLastName()%></td>
</tr>
<tr>
	<td>date of Birth:</td>
	<td><%=patient.getDateOfBirth()%></td>
</tr>	
<tr>
	<td>Gender:</td>
	<td><%=patient.getGender()%></td>
</tr>	
<tr>
	<td>Blood Group:</td>
	<td><%=patient.getBloodGroup()%></td>
</tr>	
<tr>
	<td>Father/Spouse Name:</td>
	<td><%=patient.getFatherOrSpouseName()%></td>
</tr>	
<tr>
	<td>Address:</td>
	<td><%=patient.getAddress()%></td>
</tr>	
<tr>
	<td>Contact Number:</td>
	<td><%=patient.getContactNo()%></td>
</tr>	
<tr>
	<td>e-mail Id:</td>
	<td><%=patient.getEmailId()%></td>
</tr>		
<tr>
	<td>Disease:</td>
	<td><%=patient.getDisease()%></td>
</tr>	
<tr>
	<td>Specialization:</td>
	<td><%=patient.getSpecialization()%></td>
</tr>		
<tr>
	<td>Visited Earlier:</td>
	<td><%=patient.getIsVisitedEarlier()%></td>
</tr>	
	
</table>
<input type="submit" value="my home"></input>
</center>
</form>	
</body>
</html>