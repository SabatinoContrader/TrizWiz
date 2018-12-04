<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Customer Menu</title>
</head>
<body>
  	<h1>Building Menu</h1>
	<h2 class="things">Buildings</h2>
	<div class="thingDiv">
		<jsp:include page="/Building">
			<jsp:param name="richiesta" value="VisualizzaBuildings" />
		</jsp:include>
		<div>
			<div class="insertDiv">
				<img
					src="https://cdn4.iconfinder.com/data/icons/symbol-color-business-1/32/office_building-add-512.png"
					class="imgThing"> <a
					href="Building?richiesta=InserisciBuilding" class="customerLink">Inserisci
					building </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://image.flaticon.com/icons/png/512/1155/1155556.png"
					class="imgThing"> <a
					href="Building?richiesta=ModificaBuilding" class="customerLink">Modifica
					building </a>
			</div>
			<div class="insertDiv">
				<img
					src="http://icons-for-free.com/free-icons/png/512/905647.png"
					class="imgThing"> <a
					href="Building?richiesta=EliminaBuilding" class="customerLink">Elimina
					building </a>
			</div>
		</div>
	</div>
</body>
</html>