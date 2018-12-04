<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Building</title>
<link rel="stylesheet" href="styles.css">
<a href="CustomerHome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class="deleteCustomer">
		<img src="http://icons-for-free.com/free-icons/png/512/905647.png"
			class="imgThing">
		<h1>Elimina Building</h1>
	</div>
	<div>
		<div class="thingDiv" style="margin-top: 5%">
			<jsp:include page="/Building">
				<jsp:param name="richiesta" value="VisualizzaBuildings" />
			</jsp:include>
			<div class="deleteBuilding" style="margin-top: -6%">
				<form action="Building" method="post">
					<table>
						<tr>
							<td><h2 style="display:block">Id Building:</h2></td>
							<td><select name="idselected">
									<c:forEach var="building" items="${buildings}">
										<option value="${building.buildingId}">${building.buildingId}</option>
									</c:forEach>
							</select></td>
						</tr>
					</table>



					<button class="deleteButton" type="submit" value="Delete" name="richiesta">Elimina</button>
					<br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>