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
<script type="text/javascript">
function fun(num) {
	document.getElementById("val").value=num;
	document.addtestform.submit();
}
</script>
</head>
<body>
	<div id="page">
		<div id="middle">
		<%if(request.getAttribute("message")!=null){%>
			<%= request.getAttribute("message") %>
		<%} %>
			<form action="AddTestController" name="addtestform">
				<%
				Integer std = (Integer) session.getAttribute("std");
				System.out.println(std + "std in jsp");
				%>
				SELECT STANDARD:<select name="std" id="std" onchange="fun(1)">
					<option value=""> </option>
						<%
							if (std != null) {
								for (int i = 1; i <= 5; i++) {
									if (std == i) {
						%>
						<option value="<%=i%>" selected><%=i%></option>
						<%
							} else {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
								}
							} else {
								for (int i = 1; i <= 5; i++) {
						%>
						<option value="<%=i%>"><%=i%></option>
						<%
							}
							}
						%>
					</select>
					<br>
					<br>
					<br>
					<input type="hidden" name="val" id="val" value="9">
					<% System.out.print("session = " + session.isNew());%>
					<% if (!(session.isNew()) && std!=null){
						System.out.print("session 1");
						List<SubjectVO> subject_list = (List<SubjectVO>) session.getAttribute("sub_list");
						Iterator<SubjectVO> io = subject_list.iterator();
						SubjectVO rvo = new SubjectVO();
						rvo = (SubjectVO) session.getAttribute("rvo");
						String code = "", name = "", max = "", pass = "";
						//int max=0,pass=0;
						if (rvo != null) {
							System.out.print("jsp page " + rvo.getSubjectcode());
							code = rvo.getSubjectcode();
							name = rvo.getSubjectname();
							max = String.valueOf(rvo.getMax_mark());
							pass = String.valueOf(rvo.getPass_mark());
						}
					//Displaying the Subject details
								if (io.hasNext()) {
									%>
									<table cellpadding="5px">
									<caption>Select The Subject And Give Test Details</caption>
									<tr>
									<td></td>
									<td>SUBJECT CODE</td>
									<td>SUBJECT NAME</td>
									<%
									while (io.hasNext()) {
										SubjectVO vo = (SubjectVO) io.next();
					%>
					<tr>
						<td><input type="radio" name="r_subject" value="<%=vo.getSubjectcode()%>"></td>
						<td><%=vo.getSubjectcode()%></td>
						<td><%=vo.getSubjectname()%></td>
					</tr>
					<%}}}%>
					</table>
					<br>
					<br>
					<br>
					<table>
					<caption>Test Details</caption>
					<tr>
					<td>Test ID: </td>
					<td><input type="text" name="testid" id="testid"><br></td>
					</tr>
					<tr>
					<td>Test Name : </td>
					<td><input type="text" name="testname" id="testname"><br></td>
					</tr>
					<tr>
					<td>Max Marks : </td>
					<td><input type="text" name="maxm" id="maxm"><br></td>
					<tr>
					<td>Pass Marks : </td>
					<td><input type="text" name="passm" id="passm"><br></td>
					</tr>
					</table>
					<p:Button name="add" type="button" value="add" onclick="fun(2)" />
					
			</form>
	</div>
	</div>
</body>
</html>