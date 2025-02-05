package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ExperienceServiceImpl;

@WebServlet("/Experience1")
public class Experience1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String discription = request.getParameter("discription");
		
		ExperienceServiceImpl experienceServiceImpl=new ExperienceServiceImpl();
		String result=experienceServiceImpl.saveExperienceService1(year, title, subtitle, discription);

		System.out.println("serv0");
		if(result.equals("valid"))
		{
			System.out.println("serv00");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Experience2");
			requestDispatcher.forward(request, response);
		}else{
			System.out.println("serv000");

			session.setAttribute("msg", result);
			response.sendRedirect("addexperience.jsp");
		}
	}

}
