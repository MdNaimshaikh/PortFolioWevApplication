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
	
   <h1><a href="ReadContact">READ CONTACT</a></h1><br>
   
    <h1><a href="uploadproject.jsp">Upload Project</a></h1><br>
    
     <h1><a href="readproject.jsp">Read Project</a></h1><br>
     
      <h1><a href="addedu.jsp">Add Education</a></h1><br>
      
      
      <h1><a href="ReadEdu">Read Education</a></h1><br>
      
      
        <h1><a href="addexperience.jsp">Add Experience</a></h1><br>
        
          <h1><a href="readexperience.jsp">Read Experience</a></h1><br>
      
       <h1><a href="uploadresume.jsp">Upload Resume</a></h1><br>
   
   <form action="Logout" method="post">
   <button>Logout</button>
   </form>
   
   <form action="ReadAdminLogin" method="post">
   <button>Change Credential</button>
   </form>
   
</body>
</html>