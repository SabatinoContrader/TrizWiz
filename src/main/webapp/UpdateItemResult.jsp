<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Hai modificato correttamente l'Item:</p>
	<p>Id:  <c:out value = "${item.getId()}"/></p>
	<p>Categoria:  <c:out value = "${item.getCategoria()}"/></p>
	<p>Marca:  <c:out value = "${item.getMarca()}"/></p>
	<p>Modello: <c:out value = "${item.getModello()}"/></p>
	<p>Descrizione: <c:out value = "${item.getDescrizione()}"/></p>
	<p><a href="ItemMenu?mode=MainMenu">Vai a Menu Item</a></p>
</body>
</html>