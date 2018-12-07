<%@ page import="com.virtualpairprogrammers.model.SottoCategorie" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<SottoCategorie> allSottoCategorie = (List<SottoCategorie>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

 <h3> Indietro</h3>
     <form action="StandardServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
    

 <table>
     <tr>
         <th>
             ID 
         </th>

         <th>
             Descrizione
         </th>
         <th>
             Id standard
         </th>
         <th>
             Descrizione ita
         </th>
     </tr>
        <%for (SottoCategorie SottoCategorie : allSottoCategorie) { %>
     <tr>

         <td>
             <%= SottoCategorie.getId()%>
         </td>

         <td>
             <%=  SottoCategorie.getDescrizione()%>
         </td>

         <td>
             <%=  SottoCategorie.getIdStandard()%>
         </td>
          <td>
             <%=  SottoCategorie.getDescrizioneIta()%>
         </td>
         
     </tr>
     <% }%>
 </table>

 </body>
</html>