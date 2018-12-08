<%@ page import="com.virtualpairprogrammers.model.Principio" %>
<!-- Asset -->
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="StandardServlet" method="post">
<table>
	<tr>
	<td>
    <h2> Descrizione in inglese</h2></td>	<td><input type="text" name="descrizioneIng">
    </td>
    </tr>
    
    <tr>
    <td>
    <h2>Descrizione in italiano</h2></td><td><input type="text" name="descrizioneIta">
    </td>
    </tr>
    
    <tr>
	<td>
    <h2> Classe di categoria  </h2></td>	<td><input type="text" name="categoria">
    </td>
    </tr>
    
   	<tr><td>
    <button type="submit" value="insertSotto" name="richiesta">Inserisci</button>
    </td></tr>
    </table>
</form>
</body>
</html>