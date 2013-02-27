package com.sms.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.bo.AuthenticatinBO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AuthenticationVO;

/**
 * Servlet implementation class LoginAdminController
 */
public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		boolean authentication;
		String username=request.getParameter("username");
		String password=request.getParameter("loginpassword");
		HttpSession session = request.getSession();
		session.setAttribute("username",username);
		
		AuthenticationVO vo=new AuthenticationVO();
		AuthenticatinBO bo=new AuthenticatinBO();
		
		System.out.println(request.getParameter("usertype")+"user type");
		vo.setUsername(username);
		vo.setPassword(password);
		vo.setUsertype(request.getParameter("usertype"));
		System.out.println("coming to controller"+vo.getUsername());
		//The condition to be changed later
		if(vo.getUsertype().equalsIgnoreCase("teacher")){
			try {
				authentication=bo.authenticateUser(vo);
				if(authentication==true){
					session.setAttribute("login",vo.getUsertype());
					session.setAttribute("username", vo.getUsername());
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("loginteacher.jsp");
					dispatcher1.forward(request, response);
				}
				else{
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("invalidlogin.jsp");
					dispatcher1.forward(request, response);
				}
			} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(vo.getUsertype().equalsIgnoreCase("admin")){
		
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			System.out.println("controller in admin"+vo.getUsername());
			session.setAttribute("login", vo.getUsername());
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginadmin.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("invalidlogin.jsp");
			dispatcher1.forward(request, response);
		}
		System.out.println("out controller");

		// TODO Auto-generated method stub
	}
	}
}
