<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.model.Thing"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Modifica Thing</title>
<a href="thingManager.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Questa � la jsp che ti permette di modificare una thing</h1>
	<%
		List<Thing> things = (List<Thing>) request.getAttribute("things");
	%>

	<div class="readCustomer">
		<img
			src="https://www.nerdhead.net/wp-content/uploads/2017/03/blue-282x300.png"
			class="imgSuperUser">
		<h1>Modifica Thing</h1>
	</div>
	<div class="thingDiv" style="margin-top:-3%">
		<jsp:include page="/Thing/read">
			<jsp:param name="operation" value="ReadThing" />
		</jsp:include>

		<div class="updateThing">
			<form
				action="Thing/update"
				method="post">
				<table>
					<tr>
						<td><h2>Seleziona l'id della Thing da modificare</h2></td>
						<td><select id="id" name="thingId">
								<%
									for (int i = 0; i < things.size(); i++) {
								%>
								<option value="<%=things.get(i).getId()%>"><%=things.get(i).getId()%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>
							<h2>Inserire numero uscite:</h2>
						</td>
						<td><input type="text" name="numberPort"
							placeholder="inserire numero uscite"></td>
					</tr>
					<tr>
						<td><h2>Inserire nome thing:</h2></td>
						<td><input type="text" name="nameThing"
							placeholder="inserire nome thing"></td>
					</tr>
				</table>
				<input hidden value="<%=request.getParameter("thingid")%>" name="thingid">
				<button class="deleteButton"type="submit">Modifica</button>
				<br>
			</form>
		</div>
	</div>
</body>
</html>