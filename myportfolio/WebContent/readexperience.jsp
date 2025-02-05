<%@ page import="com.model.EducationPojo" %>
<%@ page import="com.model.ExperiencePojo" %>
<%@ page import="java.util.ArrayList" %>
<%
String adminlogin = (String) session.getAttribute("adminlogin");
if (adminlogin == null) {
    response.sendRedirect("adminlogin.jsp");
    return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Experience Details</title>
</head>
<body>
    <%@ include file="messageprint.jsp" %>

    <%
        ArrayList<ExperiencePojo> arrayList = (ArrayList<ExperiencePojo>) session.getAttribute("readexperiences");
        if (arrayList == null) {
            response.sendRedirect("admin.jsp");
            return;
        }
        int index = 0;
        for (ExperiencePojo eduexp : arrayList) {
    %>

    SN: <%= eduexp.getSn() %><br>
    YEAR: <%= eduexp.getYear() %><br>
    TITLE: <%= eduexp.getTitle() %><br>
    SUBTITLE: <%= eduexp.getSubtitle() %><br>
    DESCRIPTION: <%= eduexp.getDiscription() %><br>
    DATETIME: <%= eduexp.getDatetime() %><br>
    
    <form action="DeleteExperience" method="post">
        <input type="hidden" name="sn" value="<%= eduexp.getSn() %>">
        <button>Delete</button>
    </form>
    <br>
    <form action="updateexperience.jsp" method="post">
        <input type="hidden" name="index" value="<%= index %>">
        <button>Update</button>
    </form>
    
    <br><br>
    <%
            index++;
        }
    %>
    <a href="ReadExpere">REFRESH</a><br>
</body>
</html>
