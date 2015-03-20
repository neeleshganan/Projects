<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function sample(){
	return ;
}
</script>
</head>

<body>



<%@page import="java.util.*; import model.*; import controller.*" %>

<form name="viewall" onclick="return sample()" action="FOM_page.jsp">
<center>
<h3>Patient Details</h3>
<table cellpadding="10" border="1" style="background-color: olive;">
	<tr>
		<th>OPD NO</th>
		<th>First Name</th>
		<th>Middle Name</th>
		<th>Last Name</th>
		<th>Date Of Birth</th>
		<th>Gender</th>
		<th>Blood Group</th>
		<th>Father Or Spouse Name</th>
		<th>Address</th>
		<th>Contact Number</th>
		<th>e-mail Id</th>
		<th>Is Visited Earlier</th>
		<th>Disease</th>
		<th>Specialization</th>
		
	</tr>
<%
 ArrayList<PatientBeanDD> lst = (ArrayList<PatientBeanDD>)request.getAttribute("pList");
Iterator<PatientBeanDD> it = lst.iterator();
while(it.hasNext()){
	
		PatientBeanDD patient = it.next();
		%>
<tr>
	
	<td><%=patient.getOpdNumber()%></td>

	<td><%=patient.getFirstName()%></td>
	<td><%=patient.getMiddleName()%></td>

	<td><%=patient.getLastName()%></td>

	<td><%=patient.getDateOfBirth()%></td>

	<td><%=patient.getGender()%></td>

	<td><%=patient.getBloodGroup()%></td>

	<td><%=patient.getFatherOrSpouseName()%></td>

	<td><%=patient.getAddress()%></td>

	<td><%=patient.getContactNo()%></td>

	<td><%=patient.getEmailId()%></td>

	<td><%=patient.getDisease()%></td>

	

	<td><%=patient.getIsVisitedEarlier()%></td>
	<td><%=patient.getSpecialization()%></td>
</tr>	
 <%} %>
 </table>
 <input type="submit" value="home"></input>
 </center>
 </form>
 
</body>
</html>