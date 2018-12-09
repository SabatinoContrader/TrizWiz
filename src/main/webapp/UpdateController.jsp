<%@ page import="com.virtualpairprogrammers.model.CategorieStandard" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<CategorieStandard> allCategorieStandard = (List<CategorieStandard>) request.getAttribute("visualizzaCategorieStandard");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

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
            nome 
         </th>
          
 <th>
            nomeIng 
         </th>
         
     </tr>
      <%for (CategorieStandard CategorieStandard : allCategorieStandard) { %>
       
     <tr>

         <td>
             <%= CategorieStandard.getId()%>
         </td>

         <td>
             <%=  CategorieStandard.getNome()%>
         </td>

         <td>
             <%=  CategorieStandard.getNomeIng()%>
         </td>

         

     </tr>
     <% }%>
 </table>

 </body>
</html>