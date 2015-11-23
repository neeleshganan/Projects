<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@page import="java.sql.*"%>
 <%@page import="model.*" %>
 <%PatientAppointment pa=(PatientAppointment) request.getAttribute("patientdetails"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alter Appointment</title>
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
<body bgcolor="olive">
<form name="newappointment" action="NewServlet" method="post" onsubmit="return validations()">
<center><h1>Update Appointment</h1></center>
<table align="center" cellpadding="5" cellspacing="20">

<tr><td>Appointment Id</td><td><input type="text" name="appointmentid" value=<%=pa.getAppointmentId()%> readonly></td></tr>
<tr>
<td >Patient OPD Number</td>
<td><input type="text" name="opd" value=<%=pa.getOpd()%> readonly></td>
</tr>
<tr>
<td>Doctor Specialization</td>
<td><select name="specialization" id="specialization" onchange="showName(this.value)">
			<option selected=<%=pa.getSpecialization() %>><%=pa.getSpecialization()%></option>
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
%>
</select>
</td></tr>
<tr>
<td >Doctor Id </td>
<td><div id="docid"><select name="doctorid" id="doctorid">
		<option selected=<%=pa.getDoctorId() %>><%=pa.getDoctorId()%></option>
	</select></div></td>
</tr>
<tr>
<td>Date Of Appointment</td>
<td><input type="text" name="dateofappointment" value=<%=pa.getConsultationDate() %>><a href="javascript:show_calendar('document.newappointment.dateofappointment', document.newappointment.dateofappointment.value);">
<img src="cal.gif" width="16" height="16" border="0"></a></td></tr>
<tr>
<td>Appointment Time</td>
<td><div id="tslot"><select name="appointmenttime" id="appointmenttime">
		<option selected=<%=pa.getSlot() %>><%=pa.getSlot()%></option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select></div>
</td></tr>
<tr><td><input type="submit" name="submit" value="Update Appointment">
<input type="hidden" name="action" value="alter"/>
</td>
<td><input type=button onClick="parent.location='index.jsp'" value='Cancel'></td></tr>
</table>
</form>
</body>
</html>