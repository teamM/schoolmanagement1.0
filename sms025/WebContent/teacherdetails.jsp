<%@page import="com.sms.vo.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@taglib prefix="p" uri="/WEB-INF/sms.tld"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Styles/style1.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function fun(num) {
	alert(num);
	document.getElementById("table_name").value="teacherdetails";
	document.getElementById("action").value=num;
	document.teacherform.submit();
}
function fun1() {
	w=window.open('addextrastudentinfo.jsp','', 'width=200,height=200');	
	w.focus();
}
</script>
</head>
<body>
	<div id="page">
		<div id="middle">
			<form action="AddTController" name="teacherform">
				<div id="left">
					<br/><br/><br/>
					<input type="hidden" name="table_number" id="table_number" value="2">
					<%session.setAttribute("table_pass", "teacherdetails"); %>
					<input type="hidden" name="table_name" id="table_name" value="2">
					<input type="hidden" name="action" id="action" value="9">
					<table>
					
					<tr>
					 <td><p:RetriveTable table_name="teacherdetails"></p:RetriveTable></td>
					</tr>
					<tr>
					<td><p:Button name="AddTeacher" type="button" value="AddTeacher" onclick="fun(1)" /></td>
					</tr>
					<tr>
						<td>To add more info click 
						<!--<p:Button type="button" name="AddCol" value="AddCol" onclick="fun1()"/>-->
						<button type="button" name="AddCol" value="AddCol" onclick="fun1()"></button>
						</td>
					</tr>
					</table>
					
				</div>
				
			</form>
	</div>
	</div>
</body>
</html>