package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AdminLoginServiceImpl;


@WebServlet("/ChangeCredential")
public class ChangeCredential extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String result= new AdminLoginServiceImpl().changeAdminLoginService1(username, password);
		
		if (result.equals("valid")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ChangeCredential2");
			requestDispatcher.forward(request, response);
			
		}
		else
		{

			session.setAttribute("msg", result);
			response.sendRedirect("changecredential.jsp");
			
		}
	}

}
