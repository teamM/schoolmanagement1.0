package com.sms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.*;
import com.sms.bo.AccountDetailsBO;
import com.sms.dao.impl.AddDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.AccountVO;

/**
 * Servlet implementation class AccountController
 */
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		String accountcode=request.getParameter("accountcode");
		String typedesc=request.getParameter("typedesc");
		String category=request.getParameter("category");
		
		System.out.println(typedesc+ " "+category);
		AccountVO vo= new AccountVO();
		vo.setAccountcode(accountcode);
		vo.setTypedescription(typedesc);
		vo.setCategory(category);
		AccountDetailsBO bo= new AccountDetailsBO();
		try {
			bo.addaccountdetails(vo);
			request.setAttribute("message","Test Added Sucessfully");
			RequestDispatcher dispatcher = request.getRequestDispatcher("accountdetails.jsp");		
			dispatcher.forward(request,response);
		} catch (SmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmsBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	}