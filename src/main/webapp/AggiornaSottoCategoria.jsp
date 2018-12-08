<%@ page import="com.virtualpairprogrammers.model.SottoCategorie" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<SottoCategorie> allSottoCategorie = (List<SottoCategorie>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>
	
	
	<h3>Inserisci ID della Standard Solution da cancellare</h3>
	 <form action = "StandardServlet" method= "post">
	 <div style="height: auto; overflow: hidden">
		<div style="width:25%; float:left;" >
     		<h3>id: <input type = "text" id = "user" name ="id"></h3>
     	</div>
     	<div style="width:25%; float:left;" >
     		<h3>Descrizione in inglese: <input type = "text" id = "user" name ="descrizione"></h3>
     	</div>
     	<div style="width:25%; float:left;" >
     		<h3>Classe di appartenenza: <input type = "text" id = "user" name ="categoria"></h3>
     	</div>
     	<div style="width:25%; float:left;" >
     		<h3>Descrizione in italiano: <input type = "text" id = "user" name ="descrizioneIta"></h3>
     	</div>
	</div>
	<center>
    <button type="submit" value="aggiornaID" name="richiesta">Aggiorna</button></center>
</form>       


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
             Id Classe di appartenenza
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