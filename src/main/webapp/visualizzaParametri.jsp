<%@ page import="com.virtualpairprogrammers.model.Parametro" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<% List<Parametro> allParametro = (List<Parametro>) request.getAttribute("visualizzaParametro");%>
</head>
<body>

<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>
<form action="ParametriServlet" method="post">
    <input type="submit" value="insert" name="richiesta">
</form>
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
             Nome Parametro
         </th>
         <th>
             Nome Parametro Ita
         </th>
         <th>
             Descrizione
         </th>
         <th>
             Descrizione Ita
         </th>
         <th>
             Icona
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