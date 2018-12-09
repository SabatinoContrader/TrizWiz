<%@ page import="com.virtualpairprogrammers.model.Principio" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<% List<Principio> allPrincipi = (List<Principio>) request.getAttribute("visPrincipioMatrice");%>
</head>
<body>

	<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

<h3>---------------- LISTA PRINCIPI------------------</h3>

<table>
     <tr>
         <th>
             ID 
         </th>

         <th>
             Nome Principio
         </th>
         
         <th>
             Nome principio Ita 
         </th>

         <th>
             Domande
         </th>
         
         <th>
             Steps
         </th>

         <th>
             Esempi
         </th>
        
     </tr>
        <%for (Principio principio : allPrincipi) { %>
     <tr>

         <td>
             <%= principio.getId()%>
         </td>

         <td>
             <%=  principio.getNomePrincipio()%>
         </td>
         
         <td>
             <%= principio.getNomePrincipioIta()%>
         </td>

         <td>
             <%=  principio.getDomande()%>
         </td>
         
          <td>
             <%= principio.getSteps()%>
         </td>

         <td>
             <%=  principio.getEsempi()%>
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