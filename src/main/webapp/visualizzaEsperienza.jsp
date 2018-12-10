<%@ page import="com.virtualpairprogrammers.model.ExpParametro" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<% List<ExpParametro> allEsperienza = (List<ExpParametro>) request.getAttribute("listEspParametro");%>
</head>
<body>

<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

<h3>---------------- LISTA ESPERIENZA PARAMETRO ID: <%= request.getAttribute("idParam")%>------------------</h3>
   

 <table>
     <tr>
         <th>
             ID ESPERIENZA
         </th>

         <th>
             COMMENTO
         </th>
        
     </tr>
        <%for (ExpParametro esperienza : allEsperienza) { %>
     <tr>

         <td>
             <%= esperienza.getId()%>
         </td>

         <td>
             <%=  esperienza.getCommento()%>
         </td>

     </tr>
     <% }%>
 </table>


 <h3> Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>

</body>
</html>