package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.EducationPojo;
import com.model.ReadContactPojo;
import com.service.ContactService1Impl;
import com.service.EducationServiceImpl;


@WebServlet("/ReadEdu")
public class ReadEdu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HelloC");
		ArrayList<EducationPojo> arrayList = new EducationServiceImpl().readEducationService();
		System.out.println("Hello"+arrayList);
		HttpSession session = request.getSession();
		session.setAttribute("readeducation", arrayList);
		response.sendRedirect("readedu.jsp");
	}

}
