<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<a href="thingManager.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<title>Inserisci Thing</title>
</head>
<body>
<body>
	<div class="readThing">
		<img
			src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
			class="imgSuperUser">
		<h1>Inserisci una nuova Thing</h1>
	</div>
	<form action="Thing" method="post">
		<div class="readCustomer">
			<h2>
				Inserire nome thing: <input type="text" name="thingName"
					placeholder="inserire nome thing">
			</h2>
		</div>
		<div class="readCustomer">
			<h2>Seleziona numero uscite</h2>
			<select style="margin-left: 4%" name="numeroUscite">
				<option value="2">2</option>
				<option value="4">4</option>
				<option value="8">8</option>
				<option value="16">16</option>
				<option value="32">32</option>
			</select>
		</div>
	</form>
	<div>
		<button class="modifyButton" type="submit" value="sendDataForInsert"
			name="operation">Crea Thing</button>
		<br>
	</div>
</body>
</html>