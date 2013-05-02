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

public class TeacherProfileCustomTag extends SimpleTagSupport{

	public void doTag() {
		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();
		final JspWriter out = getJspContext().getOut();
		String teacher_id = (String) session.getAttribute("teacher_id");
		RetreiveDetailsDAO dao;
		Iterator io ;
		try {
			dao = new RetreiveDetailsDAO();
			List teacher_profile = dao.retreiveTeacherProfile(teacher_id);
			io = teacher_profile.iterator();
			while(io.hasNext()){
				out.println("<table>");
				out.println("<tr><td>" + io.next() + "</td></tr>");
				out.println("</table>");
			}
			
		} catch (SmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmsBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
