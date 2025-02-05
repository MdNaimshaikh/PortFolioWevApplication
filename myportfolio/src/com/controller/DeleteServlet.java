package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactService1Impl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sn=	request.getParameter("sn");
		
		ContactService1Impl contactService1Impl=new ContactService1Impl();
		
		String result=contactService1Impl.deleteService(sn);
		
		if(result.equals("delete")){
			session.setAttribute("msg", "Contact Deleted SuccessFully");
			response.sendRedirect("ReadContact");
		}
		else
		{
			session.setAttribute("msg", "Contact Not Deleted SuccessFully");
			response.sendRedirect("readcontact.jsp");
		}
		
		
		
	}


}
