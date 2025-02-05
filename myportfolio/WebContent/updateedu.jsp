<%@page import="com.model.EducationPojo"%>
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
			ArrayList<EducationPojo> arrayList = (ArrayList<EducationPojo>) session.getAttribute("readeducation");

			String index=request.getParameter("index");
			
			if(index==null)
			{
				response.sendRedirect("admin.jsp");
				return;
			}
		EducationPojo edupojo =	arrayList.get(Integer.parseInt(index));
	%>

		
		
		<form action="UpdateEducation" method="post">
		<input type="hidden" name="sn" value="<%=edupojo.getSn()%>"><br>
		<input type="text" name="year" value="<%=edupojo.getYear()%>"><br>
		<input type="text" name="title" value="<%=edupojo.getTitle()%>"><br>
		<input type="text" name="subtitle" value="<%=edupojo.getSubtitle()%>"><br>
		<input type="text" name="discription" value="<%=edupojo.getDiscription()%>"><br>
		<button>Update</button>
</form>
</body>
</html>