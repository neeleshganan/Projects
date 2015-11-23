<%@page import="java.sql.*"%>
<%@page import="model.*" %>
<%
String spec=request.getParameter("count");  
 String buffer="<select name='doctorid'><option value=''>Select</option>";  
 try{
	 DbConnection dcon=new DbConnection();
     Connection con=dcon.getConnection();
	 Statement stmt = con.createStatement();  
 	ResultSet rs = stmt.executeQuery("Select doctor_id from lp15_doctor where specialization='"+spec+"' ");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getString("doctor_id")+"'>"+rs.getString("doctor_id")+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>