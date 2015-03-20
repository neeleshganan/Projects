<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function validateAppointmentId()
{
	var valid= true;
	var appointmentid=document.getappointment.appointmentid.value;
	var exp = new RegExp("[~!@#$%^&*()_+|:/><.,=;'{}a-zA-Z]");
	var exp1= exp.exec(appointmentid);
	if(appointmentid=="")
	{
		alert("Please enter appointment number");
		valid=false;
		return valid;
	}
	else if(appointmentid.length!=5)
	{
		alert("appointmentid number should be 5 characters of length");
		valid=false;
		return valid;
	}
	else if(exp1)
	{
		alert("appointmentid should only contain numbers");
		valid= false;
		return valid;
	}
	else
		return valid;
}
</script>
<title>Alter Appointment</title>
</head>
<body bgcolor="olive" onload=document.getappointment.appointment.focus()>
<center>
<h1> Alter Appointment</h1>
<form name="getappointment" action="NewServlet" method="post" onsubmit="return validateAppointmentId()" >
<table align = center cellspacing=5 cellpadding=10>
<tr><td> Enter Appointment Id</td><td><input type="text" name="appointmentid"/></td></tr>
<tr></tr><tr></tr>
<tr><td>
<input type="submit" name="submit" value="GetDetails">
<input type="hidden" name="action" value="get"/>
</td><td><input type=button onClick="location.href='index.jsp'" value='Cancel'></td></tr>
</table>

</form>
</center>
</body>
</html>