package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ReadContactPojo;
import com.service.ContactService1Impl;

@WebServlet("/ReadContact")
public class ReadContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ReadContactPojo> arrayList = new ContactService1Impl().readContactService();
		HttpSession session = request.getSession();
		session.setAttribute("readcontact", arrayList);
		response.sendRedirect("readcontact.jsp");
	}
}
