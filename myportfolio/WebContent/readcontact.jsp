<%

String adminlogin=(String)session.getAttribute("adminlogin");
if(adminlogin==null)
{
	response.sendRedirect("adminlogin.jsp");
	return;
}
%>

<%@page import="com.model.ReadContactPojo"%>
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

<%@include file="messageprint.jsp" %>

	<%
		ArrayList<ReadContactPojo> arrayList = (ArrayList<ReadContactPojo>) session.getAttribute("readcontact");

		for (ReadContactPojo readcontact : arrayList) {
	%>

	
	SN:<%=readcontact.getSn()%><br>
	NAME:<%=readcontact.getName()%><br> 
	 EMAIL:<%=readcontact.getEmail()%><br>
	MESSAGE:<%=readcontact.getMessage()%><br>
	 DATETIME:<%=readcontact.getDatetime()%><br>
	<a href="DeleteServlet?sn=<%=readcontact.getSn()%>">Delete</a>
		<%--
	<form action="DeleteServlet" method="post">
	<input type="hidden" name="sn" value="<%=readcontact.getSn() %>" >
	<button>Delete</button>
	</form>
	--%>
	<br><br>
	<%
	
		}
	%>
	<a href="ReadContact" >REFRESH</a><br>
</body>
</html>