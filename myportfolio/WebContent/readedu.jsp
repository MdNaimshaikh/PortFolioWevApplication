<%@page import="com.model.EducationPojo"%>
<%@page import="java.util.ArrayList"%>
<%

String adminlogin=(String)session.getAttribute("adminlogin");
if(adminlogin==null)
{
	response.sendRedirect("adminlogin.jsp");
	return;
}
%>

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
		ArrayList<EducationPojo> arrayList = (ArrayList<EducationPojo>) session.getAttribute("readeducation");

	if(arrayList==null)
	{
		response.sendRedirect("admin.jsp");
	}
		int index=0;
		for (EducationPojo edupojo : arrayList) {
	%>

	
	SN:<%=edupojo.getSn()%><br>
	YEAR:<%=edupojo.getYear()%><br> 
	 TITLE:<%=edupojo.getTitle()%><br>
	SUBTITLE:<%=edupojo.getSubtitle()%><br>
	DISCRIPTION:<%=edupojo.getDiscription()%><br>
	 DATETIME:<%=edupojo.getDatetime()%><br>
	<%--<a href="DeleteServlet?sn=<%=readeducation.getSn()%>">Delete</a>--%>
		
	<form action="DeleteEducation" method="post">
	<input type="hidden" name="sn" value="<%=edupojo.getSn() %>" >
	<button>Delete</button>
	</form>
	<br>
	<form action="updateedu.jsp" method="post">
	<input type="hidden" name="index" value="<%=index%>" >
	<button>Update</button>
	</form>
	
	<br><br>
	<%
	
	index++;
		}
	%>
	<a href="ReadEdu" >REFRESH</a><br>

</body>
</html>