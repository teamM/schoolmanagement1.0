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
	document.assigntform.submit();
}
</script>
</head>
<body>
	<div id="page">
		<div id="middle">
			<form action="AssignTController" name="assigntform">
			<input type="hidden" name="val" id="val" value="9">
			<%if(request.getAttribute("success")!=null){%>
				<%=request.getAttribute("success") %>
			<% } else if(request.getAttribute("error")!=null){%>
				<%=request.getAttribute("error") %>
			<%} %>
				<div id="left">
					Select Standard:
					<select name="std" id="std" onchange="fun(1)">
					<option value="0">Choose the standard</option>
						<%
							Integer std = (Integer) session.getAttribute("std");
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
					
						
					<%
					if(request.getAttribute("error")==null){
					List<SubjectVO> subject_list = (List<SubjectVO>)session.getAttribute("subject_list");
						if(subject_list!=null){
							Iterator io = subject_list.iterator();
							SubjectVO vo ;
					%>
					<br/><br/><br/>
					<table cellpadding="10">
					<tr>
					<th></th>
					<th>SUBJECT CODE</th>
					<th>SUBJECT NAME</th>
					</tr>
					<%		
							while(io.hasNext()){
								vo = (SubjectVO) io.next();
					%>							
							<tr>							
							<td><input type="checkbox" name="subject_codes" value="<%=vo.getSubjectcode() %>"> </td>
							<td><%=vo.getSubjectcode() %></td>
							<td><%=vo.getSubjectname() %></td>
							</tr>
							
					<%	}  %>
					</table>
					<%	}  %>
				</div>
				<div id="right">
					<%  List<TeacherDetailsVO> teacher_list = (List<TeacherDetailsVO>)session.getAttribute("teacher_list");
						if(teacher_list!=null){
							Iterator io_teacher = teacher_list.iterator();
							TeacherDetailsVO vo ;
					%>
					<br/><br/><br/>
					<table cellpadding="10">
					<tr>
					<th></th>
					<th>TEACHER CODE</th>
					<th>TEACHER NAME</th>
					</tr>
					<%		
							while(io_teacher.hasNext()){
								vo = (TeacherDetailsVO) io_teacher.next();
					%>							
							<tr>							
							<td><input type="radio" name="teacher_id" value="<%=vo.getTid() %>"> </td>
							<td><%=vo.getTid() %></td>
							<td><%=vo.getTeacher_name() %></td>
							</tr>
							
					<%	}  %>
					</table>
					<input type="submit" value="Assign" onclick="fun(2)">
					<%	}  }%>
					
				</div>
			</form>
	</div>
	</div>
</body>
</html>