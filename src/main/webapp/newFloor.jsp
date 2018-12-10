<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
</head>
<body>
	<h1>Crea un nuovo floor per il building <%=request.getAttribute("buildingId") %></h1>
	<form action="insert?buildingId=<%=request.getParameter("buildingId")%>" method="post">
		<h3>Inserire nome floor: <input type="text" name="floorName" placeholder="inserire nome floor"></h3>
		<h3>Inserire descrizione: <input type="text" name="floorDescription" placeholder="inserire descrizione"></h3>
		<button type ="submit">Crea</button><br>
	</form>
</body>
</html>