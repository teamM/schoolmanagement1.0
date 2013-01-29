package com.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("loginpassword");
		HttpSession session = request.getSession();
		session.setAttribute("login", "admin");
		PrintWriter out=response.getWriter();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			System.out.println("controller");
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginadmin.jsp");
			dispatcher.forward(request, response);
		}
		else {
			out.print("in else part");
		}
		System.out.println("out controller");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
