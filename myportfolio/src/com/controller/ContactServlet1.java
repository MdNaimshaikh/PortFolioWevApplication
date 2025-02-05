package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactService1Impl;

@WebServlet("/ContactServlet1")
public class ContactServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		
		ContactService1Impl contactService1Impl=new ContactService1Impl();
		String result=contactService1Impl.contactService1(name, email, message);
		
		if(result.equals("valid")){
			RequestDispatcher requestdispatcher=request.getRequestDispatcher("ContactServlet2");
			requestdispatcher.forward(request, response);
		}
		else
		{
			session.setAttribute("msg", result);
			response.sendRedirect("index.jsp");
		}
		
	}

}
