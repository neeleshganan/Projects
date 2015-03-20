<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Doctor</title>
</head>
<body>
<%
	String jdbcURL = "jdbc:oracle:thin:@192.168.129.12:1521:orcl";

	String username = "a07e";
	String password1 = "a07e";

	String docid = request.getParameter("docid");
	String password = request.getParameter("password");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection(jdbcURL, username,
			password1);
	Statement st = conn.createStatement();
	ResultSet rs = st
			.executeQuery("select * from TBL_P2_T5_DOCTOR where DOCTOR_Id='" + docid
					+ "' and PASSWORD='" + password + "'");
	int count = 0;
	while (rs.next()) {
		count++;
	}
	if (count > 0) {
		response
		.sendRedirect("Success.jsp?msg=Welcome Doctor");
	} else {
		response
				.sendRedirect("Error.jsp?msg=Invalid DocId or Password");
	}
%>
</body>
</html>


