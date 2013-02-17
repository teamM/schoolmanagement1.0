package com.sms.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestDetailsComboTag extends SimpleTagSupport{

	public void doTag() {

		PageContext pageContext = (PageContext)getJspContext();
		HttpSession session = pageContext.getSession();		
		if(session.getAttribute("testcombo")!=null){
			@SuppressWarnings("unchecked")
		List<String> test_list = (List<String>) session.getAttribute("test_list");
		System.out.println(test_list);
		Iterator<String> io = test_list.iterator();
		final JspWriter out = getJspContext().getOut();
		try {
			out.print("<select name='test_list' onchange='fun(2)'>");
			while(io.hasNext()){
				String testname = (String) io.next();
				out.print("<option value='"+ testname +"'>"+ testname +"</option>");
			}
			out.print("</select>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
