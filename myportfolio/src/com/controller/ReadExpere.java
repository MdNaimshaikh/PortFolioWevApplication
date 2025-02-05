package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ExperiencePojo;
import com.service.ExperienceServiceImpl;

@WebServlet("/ReadExpere")
public class ReadExpere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		ArrayList<ExperiencePojo> arrayList=new ExperienceServiceImpl().readExperienceService();
		System.out.println("Naim");
		//System.out.println("Hello"+arrayList);
		HttpSession session = request.getSession();
		session.setAttribute("readexperiences", arrayList);
		System.out.print(session);
		response.sendRedirect("readexperiences.jsp");
	}

}
