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
	alert(num);
	document.getElementById("val").value=num;
	document.myform.submit();
}

function sessfun(){
	document.write("logged out ");
	session.invalidate();
}
</script>
</head>
<body>
	<div id="page">
	<h1 onclick="sessfun()">invalidate the session</h1>
		<div id="middle">
		<form name="myform" action="AddMarksController">
			<input type="hidden" name="val" id="val" value="1">
			<p:RetriveDetails/>			
			<p:TestDetails/>
			<%System.out.println("session = " + session.isNew());
			 if(session.getAttribute("stud")!=null){%>
				<%				
				List<String> student_list = (List<String>) session.getAttribute("student_list");
				if(student_list!=null){
				   Iterator<String> io_student = student_list.iterator();
						%>
						<table>
						<tr><td>Student id</td><td>marks secured</td></tr>
						<%while(io_student.hasNext()){
							String student_name = io_student.next();
									%>
									
							<tr><td><%=student_name %></td>
							<td><input type="text" name="<%=student_name %>" id="<%=student_name %>"></td></tr>				
						<% } %>
						</table>
						<input type="button" name="add_marks" value="Submit" onclick="fun(3)">
				<% } } %>	
			
		</form>	
	</div>
	</div>
</body>
</html>
