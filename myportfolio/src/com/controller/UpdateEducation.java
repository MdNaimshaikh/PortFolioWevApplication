package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationServiceImpl;

@WebServlet("/UpdateEducation")
public class UpdateEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String sn = request.getParameter("sn");
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String discription = request.getParameter("discription");
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		
		String result=educationServiceImpl.updateEducationService(sn, year, title, subtitle, discription);
		
		if(result.equals("updated"))
		{
			session.setAttribute("msg", "Education updated successfully");
			response.sendRedirect("ReadEdu");
		}
		else{
			session.setAttribute("msg", result);
			response.sendRedirect("admin.jsp");
		}
	}

}
