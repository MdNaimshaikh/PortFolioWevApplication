<%@page import="com.model.EducationPojo"%>
<%@page import="com.model.ExperiencePojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
			ArrayList<ExperiencePojo> arrayList = (ArrayList<ExperiencePojo>) session.getAttribute("readexperiences");

			String index=request.getParameter("index");
			
			if(index==null)
			{
				response.sendRedirect("admin.jsp");
				return;
			}
		ExperiencePojo eduexp=arrayList.get(Integer.parseInt(index));
	%>

		
		
		<form action="UpdateExperience" method="post">
		<input type="hidden" name="sn" value="<%=eduexp.getSn()%>"><br>
		<input type="text" name="year" value="<%=eduexp.getYear()%>"><br>
		<input type="text" name="title" value="<%=eduexp.getTitle()%>"><br>
		<input type="text" name="subtitle" value="<%=eduexp.getSubtitle()%>"><br>
		<input type="text" name="discription" value="<%=eduexp.getDiscription()%>"><br>
		<button>Update</button>
</form>
</body>
</html>