<%@ page import="com.virtualpairprogrammers.model.Principio" %>
<!-- Asset -->
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="BadgeReaderServlet" method="post">
<table>
	<tr>
	<td>
    <h2>Nome principio in inglese</h2></td>	<td><input type="text" name="nomePrincipio">
    </td>
    </tr>
    
    <tr>
    <td>
    <h2>Nome principio in italiano</h2></td><td><input type="text" name="nomePrincipioIta">
    </td>
    </tr>
    
    <tr>
	<td>
    <h2>domande</h2></td>	<td><input type="text" name="domande">
    </td>
    </tr>
    
    <tr>
	<td>
    <h2>steps</h2></td>	<td><input type="text" name="steps">
    </td>
    </tr>
    
    <tr>
	<td>
    <h2>esempi</h2></td>	<td><input type="text" name="esempi">
    </td>
    </tr>
    
   	<tr><td>
    <button type="submit" value="insertBadgeReader" name="richiesta">Inserisci</button>
    </td></tr>
    </table>
</form>
</body>
</html>