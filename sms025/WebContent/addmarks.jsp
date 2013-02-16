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
	
	document.addmarksform.submit();
	alert(num);
}

function sessfun(){
	session.invalidate();
}
</script>
</head>
<body>
	<div id="page">
	<h1 onclick="sessfun()">invalidate the session</h1>
		<div id="middle">
		<form name="addmarksform" action="AddMarksController">
			<input type="hidden" name="val" id="val" value="1">
			<p:RetriveDetails/>
	
			<%if(!(session.isNew())){%>
				<% List<String> student_list = (List<String>) session.getAttribute("student_list");
				if(student_list!=null){
				   Iterator<String> io_student = student_list.iterator();
						%>
						<table>
						<%while(io_student.hasNext()){%>
							<tr><td><%=io_student.next() %></td></tr>				
						<% } %>
						</table>
				<% } } %>
		</form>	
	</div>
	</div>
</body>
</html>