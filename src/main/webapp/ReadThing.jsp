<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.AmebaDevices.model.Thing"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Read Things</title>
<%
	List<Thing> things = (List<Thing>) request.getAttribute("things");
%>
</head>
<body>
	
		<table class="thingTable table">

			<tr>
				<th>Id</th>
				<th>numUscite</th>
				<th>Nome</th>

			</tr>

			<%
				for (Thing thing : things) {
			%>
			<tr>
				<td align="center"><%=thing.getId()%>
				<td align="center"><%=thing.getNumUscite()%>
				<td align="center"><%=thing.getNome()%>
			</tr>
			<%
				}
			%>
		</table>

	

</body>
</html>