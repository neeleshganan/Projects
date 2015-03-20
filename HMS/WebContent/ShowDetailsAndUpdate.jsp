<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="NewServlet" method="post">
 <input type="hidden" value="update" name="vieworcheck">
<%@page import="java.util.*; import model.PatientBeanDD; " %>

	<% 
	
	PatientBeanDD patient=(PatientBeanDD)request.getAttribute("patients");

	%>
<center>
<table border="0">
<tr>
	<td>OPD number:</td>
	<td>
	<input type="text" name="opdn" value="<%=patient.getOpdNumber()%>" readonly="readonly"></input>
	</td>
</tr>
<tr>
	<td>First Name:</td>
	<td>
	<input type="text" name="fname" value="<%=patient.getFirstName()%>" readonly="readonly"></input>
	</td>
</tr>
<tr>
	<td>Last Name:</td>
	<td>
	<input type="text" name="lname" value="<%=patient.getLastName()%>" readonly="readonly"></input>
	</td>
</tr>
<tr>
	<td>date of Birth:</td>
	<td>
	<input type="text" name="dob" value="<%=patient.getDateOfBirth()%>" readonly="readonly"></input>
	</td>
</tr>	
<tr>
	<td>Gender:</td>
	<td>
	<input type="text" name="gender" value="<%=patient.getGender()%>" readonly="readonly"></input>
	</td>
</tr>	
<tr>
	<td>Blood Group:</td>
	<td>
	<input type="text" name="bg" value="<%=patient.getBloodGroup()%>" readonly="readonly"></input>
	</td>
</tr>	
<tr>
	<td>Father/Spouse Name:</td>
	<td>
	<input type="text" name="fsname" value="<%=patient.getFatherOrSpouseName()%>" readonly="readonly"></input>
	</td>
</tr>	
<tr>
	<td>Address:</td>
	<td>
	<textarea name="address" rows="6" cols="40" ><%=patient.getAddress()%>
	</textarea>
	</td>
</tr>	
<tr>
	<td>Contact Number:</td>
	<td>
	<input type="text" name="phno" value="<%=patient.getContactNo()%>" ></input>
	</td>
</tr>	
<tr>
	<td>e-mail Id:</td>
	<td>
	<input type="text" name="email" value="<%=patient.getEmailId()%>" readonly="readonly"></input>
	</td>
	
</tr>		
<tr>
	<td>Disease:</td>
	<td>
	<input type="text" name="disease" value="<%=patient.getDisease()%>" ></input>
	</td>
</tr>	
<tr>
	<td>Type Of Doctor:</td>
	<td>
	<input type="text" name="tod" value="<%=patient.getSpecialization()%>" readonly="readonly"></input>
	</td>
</tr>		
<tr>
	<td>Visited Earlier:</td>
	<td>
	<input type="text" name="visited" value="<%=patient.getIsVisitedEarlier()%>" readonly="readonly"></input></td>
</tr>	
	
</table>

<input type="hidden" value="<%=patient.getOpdNumber()%>" name="opdnum">
<input type="submit" value="Update"></input>
<input type="reset" value="Reset"></input>
</center>
</form>	
</body>
</html>