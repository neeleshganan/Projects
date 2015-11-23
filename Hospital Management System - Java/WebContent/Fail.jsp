<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="false" errorPage="/errorHandler.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function sample(){
	return ;
}
</script>
<title>fail</title>
</head>
<body>
<center>
<form name="fail" action="OpdNumberCheck.jsp" onclick="return sample()" >
<h3>YOU HAVE ENTERED A WRONG OPD NUMBER!!! PLEASE TRY WITH THE CORRECT ONE..</h3>
<input type="submit" value="back"></input>
</form>
</center>
</body>
</html>