package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AdminLoginServiceImpl;

@WebServlet("/ChangeCredential2")
public class ChangeCredential2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sn=request.getParameter("sn");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminLoginServiceImpl adminLoginServiceImpl = new AdminLoginServiceImpl();
	String result=	adminLoginServiceImpl.changeAdminLoginService2(sn, username, password);
	
		if(result.equals("updated"))
		{
			session.setAttribute("msg", "Credential Updated");
			response.sendRedirect("admin.jsp");
		}
		else
		{
			session.setAttribute("msg", result);
			response.sendRedirect("changecredential.jsp");
		}
	}

}
