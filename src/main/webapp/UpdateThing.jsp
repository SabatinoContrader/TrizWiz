<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtualpairprogrammers.model.Thing"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Thing</title>
<link rel="stylesheet" href="styles.css">
<a href="thingManager.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Questa è la jsp che ti permette di modificare una thing</h1>
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
		<jsp:include page="/Thing">
			<jsp:param name="operation" value="ReadThing" />
		</jsp:include>

		<div class="updateThing">
			<form
				action="Thing?thingid=<%=request.getParameter("thingid")%>&operation=sendDataForUpdate"
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
				<button class="deleteButton"type="submit" value="sendDataForUpdate" name="operation">Modifica</button>
				<br>
			</form>
		</div>
	</div>
</body>
</html>