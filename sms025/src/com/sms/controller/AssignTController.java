package com.sms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sms.bo.AssignTeacherBO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.SubjectVO;
import com.sms.vo.TeacherDetailsVO;

/**
 * Servlet implementation class AssignTController
 */
public class AssignTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String val = (String) request.getParameter("val");
		HttpSession session=request.getSession();			
		session.setAttribute("std", Integer.parseInt(request.getParameter("std")));
		int std= Integer.parseInt(request.getParameter("std"));
		AssignTeacherBO bo=new AssignTeacherBO();
		if(val.equalsIgnoreCase("1")){
			try {
				List<SubjectVO> subject_list = bo.getsubjectInfo(std);
				session.setAttribute("subject_list", subject_list);				
				List<TeacherDetailsVO> teacher_list = bo.getTeacherInfo();				
				session.setAttribute("teacher_list", teacher_list);				
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			finally{
				RequestDispatcher dispatcher = request.getRequestDispatcher("assignTeacher.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(val.equalsIgnoreCase("2")){
			TeacherDetailsVO tvo = new TeacherDetailsVO();
			tvo.setTid(request.getParameter("teacher_id"));
			tvo.setSubject_code(request.getParameterValues("subject_codes"));
			AssignTeacherBO tbo = new AssignTeacherBO();
			try {
				tbo.assignteacher(tvo);
				request.setAttribute("success", "The teacher was successfully assigned the subjects ");
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			finally{
				RequestDispatcher dispatcher = request.getRequestDispatcher("assignTeacher.jsp");
				dispatcher.forward(request, response);
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
