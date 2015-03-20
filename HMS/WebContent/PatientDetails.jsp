<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function validate()
{

    valid = true;

    if (document.patient.fname.value=="" )
    {
        alert ( "Please fill in the first name.");
        document.patient.fname.focus();
        valid = false;
        return valid;
    }
	
	if (/^[A-Za-z]+$/.test(document.patient.fname.value))
	{
	valid = true;
    }
	else
	{
	 alert ( " only alphabets should be given in first name" );
	 document.patient.fname.focus();
	 valid = false;
     return valid;
	}

		
	if(document.patient.mname.value!="" &&!(/^[A-Za-z]+$/.test(document.patient.mname.value)))
	{
	
	alert ( " only alphabets should be given in middle name" );
	 document.patient.mname.focus();
	 valid = false;
    return valid;
    }
	
	
    if (document.patient.lname.value=="" )
    {
        alert ( "Please fill in the last name");
        document.patient.lname.focus();
        valid = false;
	 return valid;
    }
	
	if (/^[A-Za-z]+$/.test(document.patient.lname.value))
	{
	valid = true;
    }
	else
	{
	 alert ( " only alphabets should be given in last name" );
	 document.patient.lname.focus();
	 valid = false;
     return valid;
	}
   
	
	 var filter = /^([012]?\d|3[01])-([Jj][Aa][Nn]|[Ff][Ee][bB]|[Mm][Aa][Rr]|[Aa][Pp][Rr]|[Mm][Aa][Yy]|[Jj][Uu][Nn]|[Jj][u]l|[aA][Uu][gG]|[Ss][eE][pP]|[oO][Cc][Tt]|[Nn][oO][Vv]|[Dd][Ee][Cc])-(19|20)\d\d$/ 
	    	
		   if(!filter.test(document.patient.dob.value)){
			
			alert("Please enter date in correct form or enter a valid date");
			 document.patient.dob.focus();
			 valid = false;
		     return valid;
		 }
	   
	   
		    
	if(document.getElementById('gm').checked)
	{
	valid = true;
	}
	
	else if(document.getElementById('gf').checked)
	{
	valid = true;
	}
	
	else
	{
	alert("gender not selected");
	valid = false;
	return valid;
	}
	
	var d = document.getElementById("pbg");
	var d1 = d.options[d.selectedIndex].value;
	if(d1==0)
	{
	alert("Please select your blood group");
	valid = false;
	return valid;
	}
	 if (document.patient.fsname.value=="" )
	    {
	        alert ( "Please fill in your father/spouse name");
	        valid = false;
		 return valid;
	    }
		
		if (/^[0-9A-Za-z]+$/.test(document.patient.fsname.value))
		{
		valid = true;
	    }
		else
		{
		 alert ( " only alphanumeric characters should be given in father/spouse name" );
		 valid = false;
	     return valid;
		}
	
	
    if (document.patient.phno.value=="")
    {
        alert ( "Please fill in your contact number");
        valid = false;
	 return valid;
    }
	
	if(document.patient.phno.value.length < 10)
	{
      alert("you must enter 10 digits in contact number");
	  return false;
	}
	if(document.patient.phno.value.length >10)
	{
      alert("Contact number should not exceed 10 characters ");
	  return false;
	}

	if (/^[0-9]+$/.test(document.patient.phno.value))
	{
	valid = true;
    	}
	else
	{
	 alert ( " only digits should be entered in contact no" );
	 valid = false;
     return valid;
	}
	
	if ((document.patient.email.value!="")&&!(/^([a-zA-Z0-9_\.\-])+\@([a-zA-Z0-9\-])+\.([a-zA-Z0-9])+$/.test(document.patient.email.value)))
	{
	 alert('Please provide a valid email address');
	 valid = false;
	 return false;
	}
	if(document.getElementById('Y').checked)
	{
	valid = true;
	}
	
	else if(document.getElementById('N').checked)
	{
	valid = true;
	}
	
	else
	{
	alert(" Please specify whether u have visited earlier or not");
	valid = false;
	return valid;
	}
	var t = document.getElementById("tod");
	var t1 = t.options[t.selectedIndex].value;
	if(t1==0)
	{
	alert("Please select the type of doctor required");
	valid = false;
	return valid;
	}

	return valid;
}
function alert(){
	alert("Are you sure to submit?");
	
}
 </script>
 </head>
<title>OP Registration</title>
<body OnLoad="document.patient.fname.focus();">
<h1 align="center">OUT PATIENT REGISTRATION FORM</h1>
<form name="patient" action="NewServlet" onsubmit="return validate()"  method="post">
<input type="hidden" value="reg" name="vieworcheck">
<table border="0" align="center">
<tr>
<td>First Name(*)</td>
<td><input type="text" name="fname" value=""></input></td>
</tr>
<tr>
<td>Middle Name</td>
<td><input type="text" name="mname" value=""></input></td>
</tr>
<tr>
<td>Last Name(*)</td>
<td><input type="text" name="lname" value=""></input></td>
</tr>
<tr>
<td>Date Of Birth(format :dd-mon-yyyy)(*)</td>
<td>
<input type="text" name="dob" value="" id="dob"></input>

</td>
</tr>
<tr>
<td>Gender(*)</td>
<td>Male<input type="radio" name="gender" value="Male" id="gm"></input>
Female<input type="radio" name="gender" value="Female" id="gf"></input>
</td>

</tr>
<tr>
<td> Blood Group(*)</td>
<td><select name="bloodgroup" id="pbg">
<option value="">--Select Blood Group--</option>
<option value="O+">O+</option>
<option value="O-">O-</option>
<option value="A+">A+</option>
<option value="A-">A-</option>
<option value="B+">B+</option>
<option value="B-">B-</option>
<option value="AB+">AB+</option>
<option value="AB-">AB-</option>

</select> </td>
</tr>
<tr>
<td>Father/Spouse Name(*)</td>
<td><input type="text" name="fsname" value=""></input></td>
</tr>
<tr>
<td>Address</td>
<td><textarea name="address" rows="6" cols="40">
</textarea>  </td>
</tr>
<tr>
<td>Contact Number(*)</td>
<td><input type="text" name="phno" value=""></input></td>
</tr>
<tr>
<td>Email Id</td>
<td><input type="text" name="email" value=""></input></td>
</tr>
<tr>
<td>Is Visited Earlier or Not(*)</td>
<td>Yes<input type="radio" name="isvisited" value="Y" id="Y"></input>
No<input type="radio" name="isvisited" value="N" id="N"></input>
</td>

</tr>
<tr>
<td>Disease(*)</td>
<td><textarea name="disease" rows="6" cols="40">
</textarea>  </td>
</tr>
<tr>
<td>Type of Doctor required(*)</td>
<td><select name="specialization" id="tod">
<option value="">--Select Category--</option>
<option value="Cardiologist">Cardiologist</option>
<option value="Orthopedic">Orthopedic</option>
</select> </td>
</tr>
<tr><td></td><td><input type="submit" name="submit" value="Submit">
<input type="reset" name="reset" value="Reset">
</td></tr>
<tr><td></td><td>Fields shown with * are mandatory</td></tr>
</table>
</form>

</body>
</html>