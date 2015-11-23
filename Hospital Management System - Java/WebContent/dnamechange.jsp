<%@page import="java.sql.*"%>
<%@page import="model.*" %>
<%
String docid=request.getParameter("count");  
 try{
	 DbConnection dcon=new DbConnection();
     Connection con=dcon.getConnection();
	 Statement stmt = con.createStatement();  
 	ResultSet rs = stmt.executeQuery("Select name from lp15_doctor where id="+docid+" ");
 	rs.next();
 	String buffer="<input type=\"text\" name=\"doctorname\" value="+rs.getString("name")+"/>";
 	System.out.println(rs.getString("name"));
	response.getWriter().println(buffer); 
	rs.close();
	con.close();
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>