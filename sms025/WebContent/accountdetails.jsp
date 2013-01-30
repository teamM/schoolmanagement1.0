<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
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
</head>
<body>
	<div id="page">
		<div id="middle">
		<%if(request.getAttribute("message")!=null){%>
			<%= request.getAttribute("message") %>
		<%} %>
<form action="AccountController" method="post">
<table>
	<tr>
		<td>Account Code</td>
		<td><input type="text" name="accountcode" id="accountcode"/></td>
	</tr>
	<tr>
		<td>Type Description</td>
		<td><input type="text" name="typedesc" id="typedesc"/></td>
	</tr>
	<tr>
		<td>Category</td>
		<td><select name="category" id="category">
		<option value="revenue"> Revenue </option>
		<option value="capital"> Capital </option>
		</select>
		</td>
	</tr>
	<tr>
		<td>
		<input type="submit" name="add" value="Add"/>
		</td>
		<td>
		<input type="reset" name="reset" value="Reset"/>
		</td>
	</tr>
</table>
</form>
</div>
</div>
</body>
</html>