<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
 <%@page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule new Appointment</title>
<script type="text/javascript">
function validations()
{
	var valid= true;
	var opd=document.newappointment.opd.value;
	var exp = new RegExp("[~!@#$%^&*()_+|:/><.,=;'{}a-zA-Z]");
	var exp1= exp.exec(opd);
	if(opd=="")
	{
		alert("Please enter opd number");
		valid=false;
		return valid;
	}
	if(opd.length!=5)
	{
		alert("OPD number should be 5 characters of length");
		valid=false;
		return valid;
	}
	if(exp1)
	{
		alert("opd number should only contain numbers");
		valid= false;
		return valid;
	}
	else
		return valid;
}
</script>
<script language="JavaScript" src="datepicker.js">
</script>
 <script language="javascript" type="text/javascript">  
      var xmlHttp; 
      var xmlHttp;
      function showName(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request");
      return;
      } 
      var url="namechange.jsp";
      url+="?count="+str;
      xmlHttp.onreadystatechange = nameChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function nameChange(){   
      	if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      		document.getElementById("docid").innerHTML=xmlHttp.responseText;   
      	}
      }
     </script>
</head>
<body bgcolor=olive>

<%
PatientAppointment pa=(PatientAppointment) request.getAttribute("pa");
%>

<center>
<br></br><br></br>
<h1>Doctor Selection Error</h1>
<br><br>
<h2>Doctor you selected will not come on that day , please select different doctor or different day</h2>
<br><br><br><br>


<form name="newappointment" action="NewServlet" method="post" onsubmit="return validations()">
<h1> Create New Appointment</h1>
<table align="center" cellpadding="5" cellspacing="20">
<tr>
<td >Patient OPD Number</td>
<td><input type="text" name="opd" value=<%= pa.getOpd() %>></td>
</tr>
<tr>
<td>Doctor Specialization</td>
<td><select name="specialization" id="specialization" onchange="showName(this.value)">
			<option value=<%= pa.getSpecialization() %> ><%= pa.getSpecialization() %></option>
			<%  
             try  
             {
            	 ResultSet rs=null;  
                 Statement st1=null;
                 DbConnection dcon=new DbConnection();
                 Connection con=dcon.getConnection();
                 String query = "select distinct specialization from lp15_doctor";  
                 st1 = con.createStatement();
                 rs = st1.executeQuery(query);  
				 while(rs.next())                  
				 {      
%>  
				 <option value="<%=rs.getString("specialization")%>">  
				 <%=rs.getString("specialization")%></option>  
				<%  
                            }  
            }  
            catch (Exception e) {  
							 e.printStackTrace();  
}  
%> 			</select>
</td></tr>
<tr>
<td >Doctor Id </td>
<td><div id="docid"><select name="doctorid" id="doctorid">
		<option value=<%= pa.getDoctorId() %> ><%= pa.getDoctorId() %></option>
	</select></div></td>
</tr>
<tr>
<td>Date Of Appointment</td>
<td><input type="text" name="dateofappointment" readonly/><a href="javascript:show_calendar('document.newappointment.dateofappointment', document.newappointment.dateofappointment.value);">
<img src="cal.gif" width="16" height="16" border="0"></a></td></tr>
<tr>
<td>Appointment Time</td>
<td><div id="tslot"><select name="appointmenttime" id="appointmenttime">
		<option value="">select</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="01">1</option>
		<option value="02">2</option>
		<option value="03">3</option>
		<option value="04">4</option>	
	</select></div>
</td></tr>
<tr></tr>
<tr></tr>
<tr><td><input type="submit" name="submit" value="Generate Appointment ID"/>
<input type="hidden" name="action" value="new"/>
</td>
<td><input type=button onClick="parent.location='index.jsp'" value='Cancel'>
</td></tr>

</table>
</form>


</center>

</body>
</html>