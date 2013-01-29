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
function fun() {
	if(document.getElementById("std").value=="")
		alert("select the standard");
	else
		document.myform.submit();
}
function fun1(num) {
	var nullflag=0,radios=0;
	var check=0;
	//for retriving and deleting
	if(num==1 || num==2){
		if(document.getElementById("subject").checked==true ){
			radios = document.forms.myform.elements.r_subject;
			if(radios.length==undefined){
				  if(document.forms.myform.elements.r_subject.checked==true){
					  check=1;					  
				  }
				}
		}else if(document.getElementById("extra").checked==true){
			radios = document.forms.myform.elements.r_extra;
			if(radios.length==undefined){
				  if(document.forms.myform.elements.r_extra.checked==true){
					  check=1;
				  }
				}
			}
			for(var i=0; i<radios.length; i++){
				if(radios[i].checked) {
					 check=1;
					 break;					
				}
			}
			if(check==1){
				document.getElementById("val").value=num;
				document.myform.submit();
			}else{
				alert('You must select a subject to edit!');
			}
			
		}
     //for adding and updating
     else if(num==3 ||num==4){
		if(document.getElementById("subject").checked==true ){
			if(document.getElementById("subcode").value.length==0){
				document.getElementById("subcodeerror").innerHTML = "subject code cannot be Empty";
				nullflag++;
			}else{

				document.getElementById("subcodeerror").innerHTML = "";
			}
			 if(document.getElementById("subname").value.length==0){
				document.getElementById("subnameerror").innerHTML = "subject name cannot be Empty";
				nullflag++;
		}else{
			document.getElementById("subnameerror").innerHTML = "";
		}
			 if(document.getElementById("maxmarks").value.length==0){
				 document.getElementById("maxmarkserror").innerHTML = "Maximun marks cannot be Empty";
				 nullflag++;
		}else{
			document.getElementById("maxmarkserror").innerHTML = "";
		}
			 if(document.getElementById("passmarks").value.length==0){
				 document.getElementById("passmarkserror").innerHTML = "Pass marks cannot be Empty";
				 nullflag++;
		}else{
			document.getElementById("passmarkserror").innerHTML = "";	
		}
		}else{
			if(document.getElementById("extracode").value.length==0){
				document.getElementById("extracodeerror").innerHTML = "extra code cannot be Empty";
				nullflag++;	
			}else{
				document.getElementById("extracodeerror").innerHTML = "";
			}
			 if(document.getElementById("extraname").value.length==0){
				document.getElementById("extranameerror").innerHTML = "extra name cannot be Empty";
				nullflag++;
		}else{
			document.getElementById("extranameerror").innerHTML = "";
		}
			 
		}
		if(nullflag==0){
			document.getElementById("val").value=num;
				document.myform.submit();
			}else{
				
				exit();
			}
	}
     //to cancel the update selected
     else if(num==5){
    	 session.removeAttribute("rvo");
			session.removeAttribute("edit");
		
	}
     else{
    	 document.getElementById("val").value=num;
			document.myform.submit();
     }	
}
</script>
</head>
<body>
	<div id="page">
		<div>
		<%if(request.getAttribute("message")!=null){%>
			<%= request.getAttribute("message") %>
		<%} %>
		</div>
		<form name="myform" action="SmsController">

			<!-- Div for the standard selecting section -->
			<%
				String type1 = (String) session.getAttribute("type");
				Integer std = (Integer) session.getAttribute("std");
				System.out.println(std + "std in jsp");
				System.out.println(type1 + "type in jsp");
			%>
			<div id="middle">
				<div id="captionleft">
					STANDARD:<select name="std" id="std" onchange="fun1(9)">
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
					<!-- Div for the type selection -->
					<div>
						<%
							if (!(session.isNew()) && type1!=null) {
								
									if (type1.equalsIgnoreCase("extra")) {
								%>
								<!--  <p:Button name="type" type="radio" value="subject" onclick="fun()"/>SUBJECT INFO
		    <p:Button name="type" type="radio" value="extra" onclick="fun()"/>EXTRA CURRICULAR INFO -->
		
								<input type="radio" name="type" id="subject" value="subject"
									onclick="fun()">SUBJECT INFO<br> <input type="radio"
									name="type" id="extra" value="extra" onclick="fun()" checked>EXTRA
								CURRICULAR ACTIVITIES INFO
								<%
		 							} else if (type1.equalsIgnoreCase("subject")) {
		 						%>
								<!--<p:Button name="type" type="radio" value="subject" onclick="fun()"/>SUBJECT INFO!-->
								<input type="radio" name="type" id="subject" value="subject"
									onclick="fun()" checked>SUBJECT INFO<br>
								<!--<p:Button name="type" type="radio" value="extra" onclick="fun()"/>EXTRA CURRICULAR INFO -->
								<input type="radio" name="type" id="extra" value="extra"
									onclick="fun()">EXTRA CURRICULAR ACTIVITIES INFO
								<%
									}								
								
							} else {
							%>
							<!-- <p:Button name="type" type="radio" value="subject" onclick="fun()"/>SUBJECT INFO
		<p:Button name="type" type="radio" value="extra" onclick="fun()"/>EXTRA CURRICULAR INFO !-->
							<input type="radio" name="type" id="subject" value="subject"
								onclick="fun()">SUBJECT INFO<br> <input type="radio"
								name="type" id="extra" value="extra" onclick="fun()">EXTRA
							CURRICULAR ACTIVITIES INFO
							<%
	 						System.out.println("subject---> in else " + type1);
	 						}
	 						%>
					</div>
					<%
						System.out.println(session.isNew() + " is session new");
						if (session.isNew() == false) {
							//String type = (String) session.getAttribute("type");
							if(type1!=null){
							if (type1.equalsIgnoreCase("subject")) {
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
					%>
					<table>
						<tr>
							<td><input type="hidden" name="val" id="val" value="9"></td>
						</tr>
						<tr>
							<td><p:Label label="sub_code" /></td>
							<%
								if (code.equalsIgnoreCase("")) {
							%>
							<td><input type="text" name="subcode" id="subcode"
								value="<%=code%>"></td>
							<%
								} else {
							%>
							<td><input type="text" name="subcode" id="subcode"
								value="<%=code%>" readonly></td>
							<%
								}
							%>
							<td colspan="2"><span id="subcodeerror"></span></td>

						</tr>
						<tr>
							<td><p:Label label="sub_name" /></td>
							<td><input type="text" name="subname" id="subname"
								value="<%=name%>"></td>
							<td colspan="2"><span id="subnameerror"></span></td>
						</tr>
						<tr>
							<td><p:Label label="max_marks" /></td>
							<td><input type="text" name="maxmarks" id="maxmarks"
								value="<%=max%>"></td>
							<td colspan="2"><span id="maxmarkserror"></span></td>
						</tr>
						<tr>
							<td><p:Label label="pass_marks" /></td>
							<td><input type="text" name="passmarks" id="passmarks"
								value="<%=pass%>"></td>
							<td colspan="2"><span id="passmarkserror"></span></td>
						</tr>
					</table>
					<%
						if (session.getAttribute("edit") != null) {
					%>
					<!-- <input type="button" value="UPDATE" onclick="fun1('5')"> -->
					<p:Button name="update" type="button" value="update"
						onclick="fun1(4)" />
						<p:Button name="cancel" type="button" value="cancel"
						onclick="fun1(9)" />
					<!-- The attributes edit and bean rvo is removed so the button goes to add -->
					<%
						session.removeAttribute("edit");
									session.removeAttribute("rvo");
									System.out.print(session.getAttribute("edit")
											+ "GOD ONLY KNOWS now also ");
					%>
					<%
						} else {
					%>
					<p:Button name="add" type="button" value="add" onclick="fun1(3)" />
					<!-- <input type="button" value="ADD" onclick="fun1('3')"> -->
					<%
						}%>
						</div>
			<div id="board">			
					<%
					//Displaying the Subject details
								if (io.hasNext()) {
									%>
									<table cellpadding="5px">
									<caption>LIST OF SUBJECTS REGISTERED</caption>
									<tr>
									<td></td>
									<td>SUBJECT CODE</td>
									<td>SUBJECT NAME</td>
									<td>MAXIMUM MARKS</td>
									<td>PASS MARKS</td>
									<%
									while (io.hasNext()) {
										SubjectVO vo = (SubjectVO) io.next();
					%>
					<tr>
						<td><input type="radio" name="r_subject"
							value="<%=vo.getSubjectcode()%>"></td>
						<td><%=vo.getSubjectcode()%></td>
						<td><%=vo.getSubjectname()%></td>
						<td><%=vo.getMax_mark()%></td>
						<td><%=vo.getPass_mark()%></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td><p:Button name="edit" type="button" value="edit"
								onclick="fun1(1)" /></td>
						<td><p:Button name="delete" type="button" value="delete"
								onclick="fun1(2)" /></td>
					</tr>
				</table>
				</div>
			<%
				}
					}
					// Extra curricular activities

					else {
						List<ExtraVO> extra_list = (List<ExtraVO>) session.getAttribute("extra_list");
						Iterator<ExtraVO> io1 = extra_list.iterator();
						ExtraVO rvo = new ExtraVO();
						rvo = (ExtraVO) session.getAttribute("rvo");
						String code = "", name = "";
						if (rvo != null) {
							code = rvo.getExtra_code();
							name = rvo.getExtra_name();
						}
			%>
			<table>
				<tr>
					<td><input type="hidden" name="val" id="val" value="9"></td>
				</tr>
				<tr>
					<td>Extra Curricular Code</td>
					<%
						if (code.equalsIgnoreCase("")) {
					%>
					<td><input type="text" name="extracode" id="extracode"
						value="<%=code%>" /></td>
					<%
						} else {
					%>
					<td><input type="text" name="extracode" id="extracode"
						value="<%=code%>" readonly /></td>
					<%
						}
					%>
<td colspan="2"><span id="extracodeerror"></span></td>
				</tr>
				<tr>
					<td>Extra Curricular Name</td>
					<td><input type="text" name="extraname" id="extraname"
						value="<%=name%>" /></td>
					<td colspan="2"><span id="extranameerror"></span></td>
				</tr>
			</table>
			<%
				if (session.getAttribute("edit") != null) {
			%>
			<!-- <input type="button" value="UPDATE" onclick="fun1(4)"> -->
			<p:Button name="update" type="button" value="update"
				onclick="fun1(4)" />
				<p:Button name="cancel" type="button" value="cancel" onclick="fun1(9)" />
			<!-- The attributes edit and bean rvo is removed so the button goes to add -->
			<%
				session.removeAttribute("edit");
							session.removeAttribute("rvo");
			%>
			<%
				} else {
			%>
			<p:Button name="add" type="button" value="add" onclick="fun1(3)" />
			<%
				}%>
			</div>
			<div id="board">
					<%	//Display extra curricular activities 
						if (io1.hasNext()) {
							%>
							
			<table cellpadding="5px">
			<caption>LIST OF ACTIVITIES REGISTERED</caption>
			<tr>
			<td></td>
			<td>ACTIVITY CODE</td>
			<td>ACTIVITY NAME</td>
			<%
							while (io1.hasNext()) {
								ExtraVO vo = (ExtraVO) io1.next();
			%>
			<tr>
				<td><input type="radio" name="r_extra"
					value="<%=vo.getExtra_code()%>"></td>
					<td><%=vo.getExtra_code()%></td>
				<td><%=vo.getExtra_name()%></td>
			</tr>


			<%
				}
			%>
			<tr>
				<td><p:Button name="edit" type="button" value="edit"
						onclick="fun1(1)" /></td>
				<!-- <td><input type="button" value="EDIT" onclick="fun1('1')"></td> -->
				<!--  <td><input type="button" value="DELETE" onclick="fun1('2')"></td> -->
				<td><p:Button name="delete" type="button" value="delete"
						onclick="fun1(2)" /></td>
			</tr>
		<%
		}
				%>
				</table>
				</div>
	<% 
			}
		}					
	}
	%>
	
	</div>
	</div>
		</form>
</body>
</html>