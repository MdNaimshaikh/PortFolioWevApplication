package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ExperienceServiceImpl;


@WebServlet("/Experience2")
public class Experience2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String discription = request.getParameter("discription");
		
		System.out.println("serv11");
		ExperienceServiceImpl experienceServiceImpl=new ExperienceServiceImpl();
		String result=experienceServiceImpl.saveExperienceService2(year, title, subtitle, discription);
		if(result.equals("saved"))
		{
			System.out.println("serv111");
			session.setAttribute("msg", "Experience added Successfully");
			response.sendRedirect("addexperience.jsp");
		}
		else{
			System.out.println("serv1111");
			session.setAttribute("msg", result);
			response.sendRedirect("addexperience.jsp");
		}
	}

}
