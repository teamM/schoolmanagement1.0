package com.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.bo.RetreiveDetailsBO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;

/**
 * Servlet implementation class AddMarksController
 */
public class AddMarksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subject_code = request.getParameter("subject_details");
		
		RetreiveDetailsBO bo = new RetreiveDetailsBO();
		String std = null;
		try {
			std = bo.retreiveStandard(subject_code);
		} catch (SmsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmsBusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		List<String> student_list,test_list;
		String val = request.getParameter("val");
		HttpSession session1 = request.getSession();
		session1.setAttribute("standard", std);
		session1.setAttribute("subject_code",subject_code);
		System.out.println(std+" std "+subject_code+" subcode ");
		
		
		if(val.equalsIgnoreCase("1")){
			try {
				
				
				test_list = bo.retreiveTestDetails(std);
				session1.setAttribute("testcombo", "testcombo");
				session1.setAttribute("test_list", test_list);
				System.out.println(test_list.isEmpty()+" check it");
				RequestDispatcher dispatcher = request.getRequestDispatcher("addmarks.jsp");
				dispatcher.forward(request, response);
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(val.equalsIgnoreCase("2")){
			try {
				System.out.println(session1.getAttribute("subject_code")+" subcode");
				session1.setAttribute("stud", "stud");
				//String std = bo.retreiveStandard("DS01");
				student_list = bo.retreiveStudentNames(std);
				System.out.println(request.getAttribute("test_list")+" test id <--");
				session1.setAttribute("student_list", student_list);
				System.out.println(student_list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("addmarks.jsp");
				dispatcher.forward(request, response);
				
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(val.equalsIgnoreCase("3")){
			try {
				System.out.println(session1.getAttribute("subject_code")+" subcode");
				student_list = bo.retreiveStudentNames(std);
				session1.setAttribute("student_list", student_list);
				System.out.println(student_list);
				System.out.println(request.getAttribute(""));
				RequestDispatcher dispatcher = request.getRequestDispatcher("addmarks.jsp");
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

