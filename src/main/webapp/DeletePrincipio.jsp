<%@ page import="com.virtualpairprogrammers.model.Principio" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Principio> allPrincipio = (List<Principio>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
 		
 	<h3>Inserisci ID principio da cancellare</h3>
	 <form action = "BadgeReaderServlet" method= "post">
     <h3>id: <input type = "text" id = "user" name ="id"></h3>
    <button type="submit" value="deleteID" name="richiesta">Cancella</button>
       
     <h3> Indietro</h3>
     <form action="BadgeReaderServlet" method="post">
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