package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactService1Impl;


@WebServlet("/ContactServlet2")
public class ContactServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		
	String result=	new ContactService1Impl().contactService2(name, email, message);
	
	HttpSession session = request.getSession();
	if(result.equals("saved"))
	{
		session.setAttribute("msg", "Message Sent Successfully");
		response.sendRedirect("index.jsp");
	}
	else if(result.equals("failed"))
	{
		session.setAttribute("msg", "Something Went Wrong");
		response.sendRedirect("index.jsp");
	}
	else
	{
		session.setAttribute("msg", "Something Went Wrong(Service)");
		response.sendRedirect("index.jsp");
	}
	}

}
