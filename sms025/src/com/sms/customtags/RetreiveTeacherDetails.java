package com.sms.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sms.dao.impl.AddDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;

public class RetreiveTeacherDetails extends SimpleTagSupport{

	private transient String table_name;
	
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public void doTag() {

		AddDetailsDAO dao = null;
		try {
			dao = new AddDetailsDAO();
		} catch (SmsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmsBusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();
		
		List<String> teacher_list;
		teacher_list = dao.retreiveTeacherTable(table_name);
		session.setAttribute("teachertablelist", teacher_list );
		Iterator<String> io = teacher_list.iterator();
		String tec_name;
		final JspWriter out = getJspContext().getOut();
		try {
			out.print("<table>");
			while(io.hasNext()){
				tec_name = io.next();
				out.print("<tr><td>");
				out.print("<label>" + tec_name + "</label></td>");
				out.print("<td><input type='text' name='"+tec_name+"'/><br/></td></tr>");
			}
			out.print("</table>");
			
		} catch (IOException e) {
			
		}

	}
}
