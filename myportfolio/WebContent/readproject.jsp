
<%

String adminlogin=(String)session.getAttribute("adminlogin");
if(adminlogin==null)
{
	response.sendRedirect("adminlogin.jsp");
	return;
}
%>

<%@page import="com.model.UploadProjectPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.UploadprojectDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



		<%@include file="messageprint.jsp" %>
					<%
					UploadprojectDaoImpl uploadprojectDaoImpl=new UploadprojectDaoImpl();
								ArrayList<UploadProjectPojo> al= uploadprojectDaoImpl.readProject();
								for(UploadProjectPojo pojo : al)
								{
					%>

								<img style="width:100px" src="myproject/<%=pojo.getForfilename() %>" alt="project image">
						<br>
						
						<form action="DeleteProject" method="post">
						<input type="hidden" name="sn" value="<%=pojo.getSn()%>">
						<input type="hidden" name="forfilename" value="<%=pojo.getForfilename()%>">
						<button>Delete</button>
						</form>
						<br><br><br>

						<%} %>
</body>
</html>