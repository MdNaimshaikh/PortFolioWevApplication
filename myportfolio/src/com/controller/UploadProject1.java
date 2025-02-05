package com.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.service.UploadProjectServiceImpl;


@WebServlet("/UploadProject1")
@MultipartConfig
public class UploadProject1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Part part = request.getPart("myfile");
		
//		String datetime = request.getParameter("datetime");
//		String submittedFileName = part.getSubmittedFileName();
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		String result = uploadProjectServiceImpl.uploadProjectService1(part);
		
		System.out.println("******s1");
		if(result.equals("valid"))
		{
			
			//dispatch
			
			System.out.println("*****s1 s1");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UploadProject2");
			requestDispatcher.forward(request, response);
		}
		else{
			
			System.out.println("******s1 s1 s1");
			session.setAttribute("msg", result);
			response.sendRedirect("uploadproject.jsp");
		}
		
		
//		filename   :String submittedFileName = part.getSubmittedFileName();
	
//		Actual file//InputStream is= part.getInputStream();
		
//		System.out.println(datetime);
//		System.out.println(submittedFileName);
	}

}
