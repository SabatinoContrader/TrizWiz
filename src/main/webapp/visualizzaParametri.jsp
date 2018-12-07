<%@ page import="com.virtualpairprogrammers.dto.ParametroNomeDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<% List<ParametroNomeDTO> allParametro = (List<ParametroNomeDTO>) request.getAttribute("visualizzaParametroDTO");%>
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


</body>
</html>