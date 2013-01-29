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
	document.getElementById("action").value=num;
	document.studentform.submit();
}
function fun1() {
	window.close();
}
</script>
</head>
<body>
			<form action="AddTController" name="studentform">
				<div id="right">
					<input type="hidden" name="action" id="action" value="9">
					<input type="hidden" name="table_name" id="table_name" value="<%=session.getAttribute("table_pass") %>">
					<table>
					<tr>
					<td>Column Name :</td>
					<td><input type="text" name="cname" id="cname"/></td>
					</tr>				
					<tr>
					<td>Data type :</td>
					<td>
					<select name="datatype">
						<option value="number">number</option>
						<option value="char">character</option>
						<option value="date">date</option>
					</select>
					</td>
					</tr>
					<tr>
					<td><p:Button name="AddDetail" type="button" value="AddDetail" onclick="fun(2)" /></td>
					</tr>
					
					</table>
				</div>
			</form>
	</body>
</html>