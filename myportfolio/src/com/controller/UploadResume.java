package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.websocket.Session;

import com.service.UploadResumeServiceImpl;


@MultipartConfig
@WebServlet("/UploadResume")
public class UploadResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part part = request.getPart("myresume");
		
		UploadResumeServiceImpl uploadResumeServiceImpl = new UploadResumeServiceImpl();
		String result=uploadResumeServiceImpl.uploadResumeService(part);
		
		request.getSession().setAttribute("msg", result);
		response.sendRedirect("uploadresume.jsp");
	}

}
