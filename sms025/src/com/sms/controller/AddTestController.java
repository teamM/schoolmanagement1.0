package com.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.bo.AddTestBO;
import com.sms.delegate.SmsDelegate;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AddTestVO;
import com.sms.vo.SubjectVO;

/**
 * Servlet implementation class AddTestController
 */
public class AddTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("controleer");
		String val = (String) request.getParameter("val");
		HttpSession session=request.getSession();
		AddTestBO bo=new AddTestBO();
		if(!(request.getParameter("std").equals(""))){
		session.setAttribute("std", Integer.parseInt(request.getParameter("std")));
		if(val.equalsIgnoreCase("1")){
			
			try{
	    		List<AddTestVO> test_list = bo.retreiveTestDetails(request.getParameter("std").toString());
				session.setAttribute("test_list", test_list);				
			}
			catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("addtest.jsp");
				dispatcher.forward(request, response);
		       	} catch (SmsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("message", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("addtest.jsp");
					dispatcher.forward(request, response);
				} 
		}
		else{
			AddTestVO vo=new AddTestVO();			
			vo.setTestid(request.getParameter("testid"));
			vo.setTestname(request.getParameter("testname"));
			vo.setPassmarks(Integer.parseInt(request.getParameter("passm")));
			vo.setMaxmarks(Integer.parseInt(request.getParameter("maxm")));
			vo.setStd(request.getParameter("std"));
			
			try {
				bo.addtest(vo);
				request.setAttribute("message","Test Added Sucessfully");
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
			}
		}
	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("addtest.jsp");		
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
