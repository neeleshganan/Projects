<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%>
<%@ page isErrorPage="false" errorPage="/errorHandler.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function sample(){
	return ;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successful Registration</title>
</head>
<body>
<center>
<h1>Registration was done successfully</h1>
<form name="registration" action="FOM_page.jsp"
	onclick="return sample()">Opd no is <%
	PatientBeanDD opdno = (PatientBeanDD) request.getAttribute("opdno");
%>
<%
	out.println(opdno.getOpdNumber());
%> <input type="submit"
	value="My Home"></input></form>


</center>

</body>
</html>