package com.sms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.bo.TeacherDetailsBO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AddColumnVO;
import com.sms.vo.TeacherDetailsVO;

/**
 * Servlet implementation class AddTController
 */
public class AddTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherDetailsBO bo = new TeacherDetailsBO();
		TeacherDetailsVO vo = new TeacherDetailsVO();
		HttpSession session=request.getSession();
		String table_name = (String) request.getParameter("table_name");
		String val=(String) request.getParameter("action");
		System.out.println(val+"in controller");
		if(val.equalsIgnoreCase("1")){
			System.out.println(val + "inside if");
			List<String> teacherDetails =(List<String>)session.getAttribute("teachertablelist");
			Iterator<String> io = teacherDetails.iterator();
			List<String> addTeacher = new ArrayList<String>();
			System.out.println(teacherDetails);
			System.out.println((String)request.getParameter("tid"));
			String tid=request.getParameter("tid");
			vo.setTid(tid);
			while(io.hasNext()){
				String detail=io.next();
				System.out.println(detail);
				String value=request.getParameter(detail);
				System.out.println(value);
				addTeacher.add(value);
			}
			System.out.println(addTeacher);
			try {
				bo.addteacher(addTeacher,table_name,vo);
				RequestDispatcher dispatcher = request.getRequestDispatcher(table_name+".jsp");
				dispatcher.forward(request, response);
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(val.equalsIgnoreCase("2")){
		AddColumnVO vo1 = new AddColumnVO();
		vo1.setNewcolumn(request.getParameter("cname"));
		vo1.setNewdatatype(request.getParameter("datatype"));
		vo1.setTable_name(table_name);
		System.out.println(vo1.getTable_name());
		System.out.println(vo1.getNewcolumn());
		System.out.println(vo1.getNewdatatype());
		try {
			bo.addcolumn(vo1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addextrastudentinfo.jsp");
			dispatcher.forward(request, response);			
		} catch (SmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmsBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
