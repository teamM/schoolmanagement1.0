package com.sms.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sms.dao.impl.RetreiveDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.SubjectVO;

public class RetreiveAssignedSubjects extends SimpleTagSupport{

	public void doTag() {

		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();		
		RetreiveDetailsDAO dao = null;
		List<SubjectVO> subject_list = null;
		try {
			dao = new RetreiveDetailsDAO();
			subject_list = dao.retreiveAssignedSubjects((String) session.getAttribute("username"));
		} catch (SmsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmsBusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		SubjectVO vo;
				
		Iterator<SubjectVO> io = subject_list.iterator();
		final JspWriter out = getJspContext().getOut();
		try {
			out.print("<table border='1'>");			
			out.print("<tr>");
			out.print("<th></th>");
			out.print("<th> Standard </th>");
			out.print("<th> Subject code </th>");
			out.print("<th> Subject name </th>");
			out.print("<th> Maximum Marks</th>");
			out.print("<th>Pass Marks</th>");
			out.print("</tr>");
			while(io.hasNext()){
				vo = io.next();				
				out.print("<tr>");
				if(session.getAttribute("standard")!=null){
					out.print("<td><input type='radio' id='subject_details' name='subject_details' value='"+vo.getSubjectcode()+"' onclick='fun(1)' checked/></td>");
				}else{
					out.print("<td><input type='radio' id='subject_details' name='subject_details' value='"+vo.getSubjectcode()+"' onclick='fun(1)'/></td>");
				}
				out.print("<td>" + vo.getStd() + "</td>");
				out.print("<td>" + vo.getSubjectcode() + "</td>");
				out.print("<td>" + vo.getSubjectname() + "</td>");
				out.print("<td>" + vo.getMax_mark() + "</td>");
				out.print("<td>" + vo.getPass_mark() + "</td>");
				out.print("</tr>");
			}
			out.print("</table>");
			
		} catch (IOException e) {
			
		}

	}
}

