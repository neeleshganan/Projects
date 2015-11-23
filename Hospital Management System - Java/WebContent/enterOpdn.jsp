<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function validation()
{
	valid=true;
	opd=document.checkpatient.opdnumber.value;
	num=/^[0-9]+$/;
	
	if(opd=="")
	{
		alert("enter OPD number to view details.");
		
		valid=false;
		return valid;
	}
	
	 if(!(num.test(opd)))
	{
	alert("OPD number should contain numbers only.");
	document.checkpatient.opdnumber.focus();
	valid=false;
	return valid;
	}
	if(opd.length!=5){
		alert("OPD number should contain only 5 digits");
		document.checkpatient.opdnumber.focus();
		valid=false;
		return valid;
	}
	
	   return valid;
}
</script>

<title>OP checking</title>
</head>
<body>
<form name="checkpatient" onsubmit="return validation()" action="NewServlet" method="post">
<input type="hidden" value="opdn" name="vieworcheck">
<center>
<table border="0">
<tr>
<td>Enter OPD Number</td>
<td><input type="text" name="opdnumber"></input></td>
<td><input type="submit" name="submit" value="SUBMIT"></input></td>
</tr>
</table>
</center>
</form>
</body>
</html>