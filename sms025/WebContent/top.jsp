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
function loginwindow(login1){
  if(login1!=" "){
	   window.open("admin.jsp","left");
	alert("A session is already open log out first");
   }else{
	   w = window.open('loginadmin.jsp','','width=200,height=200');
		w.focus();
   }

}
</script>

</head>
<body>
	<div id="page">
		<div id="header">
			<div id="logo" class="orangeaddress">
				<a href="#"> <img alt="School Logo" src="images/school_logo.jpg"
					style="border: 0pt none;">
				</a>
			</div>
			<div id="navigation">
			<%String login1;
			  login1=(String)session.getAttribute("login");
			  if(login1!=null){%>

			  <%}else{
				  login1=" ";
			  }
			  System.out.println(login1+(String)session.getAttribute("login")+"in top");%>
				<ul>
					<li><a onclick="loginwindow('<%=login1%>')" class="nav_home navigationpref" target="left"><br />ADMIN
					</a></li>
					<li><a href="teacher.jsp" class="nav_about navigationpref" target="left"><br />TEACHER
					</a></li>
					<li><a href="student.jsp" class="nav_workshops navigationpref" target="left"><br />STUDENT
					</a></li>
					<li><a href="parent.jsp" class="nav_sports navigationpref" target="left"><br />PARENT
					</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>