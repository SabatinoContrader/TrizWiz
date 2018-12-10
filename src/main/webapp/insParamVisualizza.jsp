</html><%@ page import="com.virtualpairprogrammers.dto.ParametroNomeDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<% List<ParametroNomeDTO> allParametro = (List<ParametroNomeDTO>) request.getAttribute("insParametroDTO");%>
</head>
<body>
	<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

<h3>---------------- LISTA PARAMETRI------------------</h3>
   

 <table>
     <tr>
         <th>
             ID 
         </th>

         <th>
             Nome Parametro
         </th>
        
     </tr>
        <%for (ParametroNomeDTO parametro : allParametro) { %>
     <tr>

         <td>
             <%= parametro.getIdDTO()%>
         </td>

         <td>
             <%=  parametro.getNomeParametroDTO()%>
         </td>

     </tr>
     <% }%>
 </table>

<form action = "ExpParametroServlet" method= "post">
	 <h3>Inserisci ID parametro per visualizzare le esperienze associate</h3>
     <h3>id: <input type = "text" id = "user" name ="idParam"></h3>
     <button type="submit" value="listaEsperienza" name="richiesta">Visualizza Esperienza</button>
</form>
	
	
 <h3> Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
</body>
</html>