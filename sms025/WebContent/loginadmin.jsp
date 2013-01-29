<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="p" uri="/WEB-INF/sms.tld"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Styles/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function f1(){
	//window.open("content.jsp");
	opener.location.reload(true);
	window.open("top.jsp","top");
	window.open("admin.jsp","left");
	   self.close();
}
</script>
<body>
<%
//session.setAttribute("login", "admin");

String login1 = (String) session.getAttribute("login");
if(login1!=null){
	if(login1.equalsIgnoreCase("admin")){%>
<script>
	f1();
</script>
<%}}%>
<form action="LoginAdminController" method="get">
<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" id="username"/></td>
		
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="loginpassword" id="loginpassword"/></td>
		
		</tr>
		<tr>
				
			<td><input  type="submit" name="login" value="login" /></td>
			<td><input type="reset" name="clear" value="clear"/></td>
		</tr>
</table>
</form>
</body>
</html>