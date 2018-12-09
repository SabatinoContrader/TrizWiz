<%@ page import="com.virtualpairprogrammers.model.CategorieStandard" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CategorieStandarServlet" method="post">
<table>
<tr>

    </tr>
	<tr>
	<td>
    <h2>Inserisci Nome Categoria</h2></td>	<td><input type="text" name="nome">
    </td>
    </tr>
    
    <tr>
    <td>
    <h2> Inserisci Nome Categoria Inglese</h2></td><td><input type="text" name="nomeIng">
    </td>
    </tr>
   
   	<tr><td>
     <button type="submit" value="insert" name="richiesta">Inserisci</button>
    </td></tr>
    </table>
</form>
</body>
</html>