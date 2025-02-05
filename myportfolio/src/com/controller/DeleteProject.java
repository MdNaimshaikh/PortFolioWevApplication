package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UploadProjectServiceImpl;

@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s = request.getParameter("sn");
		String forfilename = request.getParameter("forfilename");
		
		UploadProjectServiceImpl uploadProjectServiceImpl = new UploadProjectServiceImpl();
		
		String result=uploadProjectServiceImpl.deleteProjectService(s, forfilename);
		
		
		request.getSession().setAttribute("msg", result);;
		response.sendRedirect("readproject.jsp");
	}

}
