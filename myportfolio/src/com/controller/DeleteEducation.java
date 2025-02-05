package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ContactService1Impl;
import com.service.EducationServiceImpl;


@WebServlet("/DeleteEducation")
public class DeleteEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		String sn=	request.getParameter("sn");
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		
		String result=educationServiceImpl.deleteEducationService(sn);
				
		if(result.equals("delete")){
			session.setAttribute("msg", "Education Deleted SuccessFully");
			response.sendRedirect("ReadEdu");
		}
		else
		{
			session.setAttribute("msg", "Education Not Deleted SuccessFully");
			response.sendRedirect("readedu.jsp");
		}
		
		
		
	}
	
	}


