function validateNewAppointment()
{
	validateOPDNumber();
}
function validateDeleteAppointment()
{
	validateOPDNumber();
}
function validateAlterAppointment()
{
	validateAppointmentId();
}
function validateOPDNumber()
{
	var valid= true;
	var opd=document.appointment.opd.value;
	var exp = new RegExp("[~!@#$%^&*()_+|:/><.,=;'{}]");
	var exp1= exp.exec(opd);
	if(opd=="")
	{
		alert("Please enter opd number");
		valid=false;
		return valid;
	}
	else if(opd.length!=8)
	{
		alert("OPD number should be 8 characters of length");
		valid=false;
		return valid;
	}
	else if(exp1)
	{
		alert("opd number should not contain sepecial characters");
		valid= false;
		return valid;
	}
	else
		return valid;
}
function validateAppointmentId()
{
	var valid= true;
	var appointmentid=document.appointment.appointmentid.value;
	var exp = new RegExp("[~!@#$%^&*()_+|:/><.,=;'{}]");
	var exp1= exp.exec(appointmentid);
	if(appointmentid=="")
	{
		alert("Please enter appointment number");
		valid=false;
		return valid;
	}
	else if(appointmentid.length!=8)
	{
		alert("appointmentid number should be 8 characters of length");
		valid=false;
		return valid;
	}
	else if(exp1)
	{
		alert("appointmentid should not contain sepecial characters");
		valid= false;
		return valid;
	}
	else
		return valid;
}
