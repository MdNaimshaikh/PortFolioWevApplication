<%@page import="com.model.ReadAdminLoginPojo"%>
<%
	String adminlogin = (String) session.getAttribute("adminlogin");
	if (adminlogin == null) {
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
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        width: 320px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 20px;
    }


    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    button {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
<body>
		<%@include file="messageprint.jsp" %>
		
		<%
		ReadAdminLoginPojo readAdminLoginPojo=(ReadAdminLoginPojo)session.getAttribute("adminlogindata");
		
		%>
	<form action="ChangeCredential" method="post">
	<input type="hidden" name="sn" value="<%=readAdminLoginPojo.getSn() %>"><br>
	<label>User Name :</label>
		<input type="text" name="username" value="<%=readAdminLoginPojo.getUsername() %>"><br>
		<label>Password :</label>
		<input type="text" name="password" value="<%=readAdminLoginPojo.getPassword() %>"><br><br>
		<button>Change credential</button>
		
	</form>

</body>
</html>

