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

<form action="UploadProject1"  method="post" enctype="multipart/form-data">
	<input type="file" name="myfile"><br>
	<input type="datetime-local" name="datetime"><br>
	<button>Upload</button>
</form>

</body>
</html>