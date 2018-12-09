<%@ page import="com.virtualpairprogrammers.model.CategorieStandard" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<CategorieStandard> allCategorieStandard = (List<CategorieStandard>) request.getAttribute("visualizzaCategorieStandard");%>
 </head>

 <body>

<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

    
	<h3>Inserisci ID della Categoria che desideri aggiornare</h3>

	          <form action = "CategorieStandarServlet" method= "post">
           <h3> id: <input type = "text" id = "user" name ="id"></h3>
     		<h3>nome in inglese: <input type = "text" id = "user" name ="nome"></h3>
     		<h3>nome in Italiano: <input type = "text" id = "user" name ="nomeIng"></h3>

     	</div>

	</div>

	<center>

    <button type="submit" value="aggiornaID" name="richiesta">Aggiorna</button></center>

</form>       



 <h3> Indietro</h3>

     <form action="CategorieStandarServlet" method="post">

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