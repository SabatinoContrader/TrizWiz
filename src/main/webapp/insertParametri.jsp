<%@ page import="com.virtualpairprogrammers.model.Parametro" %>
<!-- Asset -->
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>
<form action="ParametriServlet" method="post">
<table>
     <tr>
         
              <h2>NomeParametro</h2></td>	<td><input type="text" name="nomeParametro">
         </th>
         <th>
             <h2>NomeParametroIta</h2></td>	<td><input type="text" name="nomeParametroIta">
         </th>
         <th>
            <h2>Descrizione</h2></td>	<td><input type="text" name="descrizione">
         </th>
         <th>
              <h2>DescrizioneIta</h2></td>	<td><input type="text" name="descrizioneIta">
         </th>
         <th>
              <h2>Icona</h2></td>	<td><input type="text" name="icona">
         </th>

     	<tr><td>
    <button type="submit" value="insertParametri" name="richiesta">Inserisci</button>
    </td></tr>
    </table>
</form>
</body>
</html>