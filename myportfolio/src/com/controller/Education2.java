package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationServiceImpl;


@WebServlet("/Education2")
public class Education2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String discription = request.getParameter("discription");
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
	String result=	educationServiceImpl.saveEducationService2(year, title, subtitle, discription);
		
		if(result.equals("saved"))
		{
			session.setAttribute("msg", "Education added Successfully");
			response.sendRedirect("addedu.jsp");
		}
		else{
			session.setAttribute("msg", result);
			response.sendRedirect("addedu.jsp");
		}
	}

}
