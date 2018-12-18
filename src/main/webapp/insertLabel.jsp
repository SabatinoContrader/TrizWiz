	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/resources/css/styles.css" rel="stylesheet">

<title>Insert Item</title>
	<a href="/Item/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>

	<div class="insertItem">
		<img
			src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/add-user.png"
			class="imgSuperUser">
		<h1>Inserisci item</h1>
	</div>
	<form class="insertForm" action="/Label/insert" method="post">
		<table class="insertTable">
			<tr>
				<td><h2>idItem:</h2></td>
				<td><input class="form-control" id="idItems" name="idItems"
					placeholder="Inserisci idItem"></td>
			</tr>
			<tr>
				<td><h2>Nome item:</h2></td>
				<td><input type="text" class="form-control" id="commento" name="commento"
					placeholder="Inserisci item"></td>
			</tr>
			
			<tr>
				<td><h2>Tipologia:</h2></td>
				<td>
				<fieldset>
				<legend> Tipologia </legend> 
             <select name="tipologia" id="tipologia">
            <option value="passato" selected="selected"> passato </option>
            <option value="presente" > presente </option>
               <option value="futuro" > futuro </option> 
               <option value="subSystem" > subSystem </option>
               <option value="System" > System </option>
               <option value="superSystem" > superSystem </option>  
              </select>
              </fieldset>
<!--	<input type="text" class="form-control" id="tipologia" name="tipologia"</td>
			<!--	<input type="text" class="form-control" id="tipologia" name="tipologia"
					placeholder="Tipologia"></td> -->
			</tr>
			
		</table>
		<button type="submit" class="registerButton">Invia</button>
	</form>
	
</body>
