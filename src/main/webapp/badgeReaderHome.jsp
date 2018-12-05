<%@ page import="com.virtualpairprogrammers.model.Principio" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Principio> allPrincipio = (List<Principio>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>
<form action="BadgeReaderServlet" method="post">
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
             nomePrincipio
         </th>
         <th>
             nomePrincipioIta
         </th>
         <th>
             domande
         </th>
         <th>
             steps
         </th>
         <th>
             esempi
         </th>

     </tr>
        <%for (Principio Principio : allPrincipio) { %>
     <tr>

         <td>
             <%= Principio.getId()%>
         </td>

         <td>
             <%=  Principio.getNomePrincipio()%>
         </td>

         <td>
             <%=  Principio.getNomePrincipioIta()%>
         </td>

         <td>
             <%=  Principio.getSteps()%>
         </td>

         <td>
             <%=  Principio.getEsempi()%>
         </td>

     </tr>
     <% }%>
 </table>

 </body>
</html>