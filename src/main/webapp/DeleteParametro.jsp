<%@ page import="com.virtualpairprogrammers.model.Parametro" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Parametro> allParametro = (List<Parametro>) request.getAttribute("visualizzaParametro");%>
 </head>
 <body>
 		
 	<h3>Inserisci ID parametro da cancellare</h3>
	 <form action = "ParametriServlet" method= "post">
     <h3>id: <input type = "text" id = "user" name ="id"></h3>
    <button type="submit" value="deleteID" name="richiesta">Cancella</button>
       
     <h3> Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
    

 <table>
     <tr>
         <th>
             ID 
         </th>

         <th>
             nomeParametro
         </th>
         <th>
             nomeParametroIta
         </th>
         <th>
             descrizione
         </th>
         <th>
             descrizioneIta
         </th>
         <th>
             icona
         </th>

     </tr>
        <%for (Parametro Parametro : allParametro) { %>
     <tr>

         <td>
             <%= Parametro.getId()%>
         </td>

         <td>
             <%=  Parametro.getNomeParametro()%>
         </td>

         <td>
             <%=  Parametro.getNomeParametroIta()%>
         </td>

         <td>
             <%=  Parametro.getDescrizione()%>
         </td>

         <td>
             <%=  Parametro.getDescrizioneIta()%>
         </td>
         
                  <td>
             <%=  Parametro.getIcona()%>
         </td>

     </tr>
     <% }%>
 </table>

 </body>
</html>