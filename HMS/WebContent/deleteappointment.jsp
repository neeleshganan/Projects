<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Appointment</title>
<script type="text/javascript">
function validateAppointmentId()
{
	var valid= true;
	var appointmentid=document.deleteappointment.appointmentid.value;
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
</head>
<body bgcolor="olive">
<center>
<h1>Delete Patient Appointment</h1><br><br><br></br>
<form name="deleteappointment" action="NewServlet" method="post" onsubmit="return validateAppointmentId()">
<table align=center cellpadding=5 cellspacing=10>
<tr><td>Enter Appointment Id</td><td><input type="text" name="appointmentid" /></td></tr>
<tr></tr>
<tr><td><input type="submit" name="submit" value="Delete Appointment"/>
<input type="hidden" name="action" value="delete"/>
</td><td><input type=button onClick="parent.location='index.jsp'" value='Cancel'></td></tr>
</table>
</form>
</center>

</body>
</html>