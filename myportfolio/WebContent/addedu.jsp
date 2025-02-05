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
	 
<form action="Education" method="post">
<input type="text" name="year" placeholder="year"><br>
<input type="text" name="title" placeholder="title"><br>
<input type="text" name="subtitle" placeholder="subtitle"><br>
<input type="text" name="discription" placeholder="discription"><br>
<button>Add</button>
</form>
</body>
</html>