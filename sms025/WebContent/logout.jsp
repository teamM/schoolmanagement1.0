<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function f1(){
	alert("Successfully logged out");
	window.open("top.jsp","top");
	window.open("left.jsp","left");
	window.open("green.jsp","right");
	//window.reload("top.jsp");
}
</script>
<body bgcolor="#383838";>

<h1> thank you for using this website :) </h1>
<%System.out.println(session.getAttribute("login")+"before rem");
session.removeAttribute("login");
System.out.println(session.getAttribute("login")+"after rem");
session.invalidate();%>
<script>
f1();
</script>


  
<h3><a href="subjects.jsp">HOME PAGE</a></h3>

</body>
</html>