package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.UploadProjectServiceImpl;

@WebServlet("/UploadProject2")
@MultipartConfig
public class UploadProject2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("******s2");
		String datetime = request.getParameter("datetime");
		Part part = request.getPart("myfile");
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		String result=uploadProjectServiceImpl.uploadProjectService2(part, datetime);
		System.out.println("******s2 s2");
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		
		response.sendRedirect("uploadproject.jsp");
		
		
	
		
	}

}
