<%
	String msg=(String)	session.getAttribute("msg");
	if(msg!=null)
	{
	%>
	<h1 style="text-align: center; "> <%out.print(msg); %></h1>
	<%
	}
	session.removeAttribute("msg");
	%>