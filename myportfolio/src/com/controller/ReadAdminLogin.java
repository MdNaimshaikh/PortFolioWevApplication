package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ReadAdminLoginPojo;
import com.service.AdminLoginServiceImpl;


@WebServlet("/ReadAdminLogin")
public class ReadAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ReadAdminLoginPojo readAdminLoginService = new AdminLoginServiceImpl().readAdminLoginService();
		
		if(readAdminLoginService==null)
		{
			session.setAttribute("msg", "Something went wrong");
			response.sendRedirect("admin.jsp");
		}
		else
		{
			session.setAttribute("adminlogindata", readAdminLoginService);
			response.sendRedirect("changecredential.jsp");
		}
		
	}

}
