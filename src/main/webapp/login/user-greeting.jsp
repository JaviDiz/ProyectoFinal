<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import="com.store.dto.User" %>    
<%
	User usuari = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="background-color: #74a9fc; text-align:center; margin-left:40%; margin-right:40%;">
		<h1 style="text-align:center;">Bienvenido <%=usuari.getNom() %></h1>
		<div style="text-align:center;">
			<b><a href="/store/frmGameClient.jsp">Continuar</a></b>		
		</div>
	</div>
</body>
</html>