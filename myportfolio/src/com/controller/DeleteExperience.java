package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.EducationServiceImpl;
import com.service.ExperienceServiceImpl;

@WebServlet("/DeleteExperience")
public class DeleteExperience extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session =request.getSession();
		String sn=request.getParameter("sn");
		
		ExperienceServiceImpl experienceServiceImpl=new ExperienceServiceImpl();
		String result=experienceServiceImpl.deleteExperienceService(sn);
				
		if(result.equals("delete")){
			session.setAttribute("msg", "Experience Deleted SuccessFully");
			response.sendRedirect("ReadExpere");
		}
		else
		{
			session.setAttribute("msg", "Experience Not Deleted SuccessFully");
			response.sendRedirect("readexperience.jsp");
		}
		
		
		
	}
	
	}


