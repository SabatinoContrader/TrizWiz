<%@ page import="com.virtualpairprogrammers.model.CategorieStandard" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<CategorieStandard> allCategorieStandard = (List<CategorieStandard>) request.getAttribute("visualizzaCategorieStandard");%>
 </head>
 <body>
 		
 	<h3>Inserisci ID principio da cancellare</h3>
	 <form action = "CategorieStandarServlet" method= "post">
	 
     <h3>id: <input type = "text" id = "user" name ="id"></h3>
    <button type="submit" value="deleteID" name="richiesta">Cancella</button>
       
    </form>
 <h3> Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>
    
    

 <table>
     <tr>
         <th>
             Id 
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