<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles.css">
	<a href="superuserhome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Item</title>
</head>
<body>
<div class="readCustomer">
		<img src="https://png2.kisspng.com/show/812fa857dddd93107f5556efc9640d62/L0KzQYm3UcMxN6d2fZH0aYP2gLBuTgRma5lzh954Z4mwdcbqjPllbZJzRehuY4Tygn7wgB9vNZpoh9C2b3awebB7hgJvbaUyh9g2dHjsfrj6TgRma5lzh954Z4mwRbKAUMJmbGU4T6hrMkSxQIq5UsA3OWU2TaMCM0C0RIe3UsI4NqFzf3==/kisspng-technology-euclidean-vector-icon-icon-of-internet-of-things-technology-5a702ed4376b24.092206141517301460227.png"
			class="imgItem">
	<h1>Items</h1>
	
	</div>
	<div class="itemDiv">
	<div class="insertDiv">
		<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
			class="imgSuperUser" > <a href="ItemMenu?mode=censimentoForm"
			class="customerLink">Censimento item </a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/notes.png"
			class="imgSuperUser" > <a href="ItemMenu?mode=visualizzaItem"
			class="customerLink">Visualizza items </a>
	</div>
	<div class="insertDiv">
		<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
			class="imgSuperUser" > <a href="ItemMenu?mode=ModificaForm"
			class="customerLink">Modifica item </a>
	</div>
	<div class="insertDiv">
		<img src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
			class="imgSuperUser" > <a href="ItemMenu?mode=EliminaForm"
			class="customerLink">Elimina item </a>
	</div>
	</div>
	
	

</body>
</html>