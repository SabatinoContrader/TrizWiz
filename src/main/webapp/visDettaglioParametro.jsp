<%@ page import="com.virtualpairprogrammers.dto.ParametroDTO" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<% ParametroDTO parametroDTO = (ParametroDTO) request.getAttribute("visParametroDTO");%>
</head>
<body>

<h2>Sei loggato come <%= request.getSession().getAttribute("utente")%></h2>

<h3>---------------- DETTAGLIO PARAMETRO------------------</h3>
   
 
 <table>
     <tr>
         <th>
             ID PARAMETRO
         </th>

         <th>
             NOME PARAMETRO
         </th>
         
         <th>
             NOME PARAMETRO ITA 
         </th>

         <th>
             DESCRIZIONE
         </th>
         
         <th>
             DESCRIZIONE ITA 
         </th>

         <th>
             ICONA
         </th>
        
     </tr>
       
     <tr>

         <td>
             <%= parametroDTO.getIdDTO()%>
         </td>

         <td>
             <%=  parametroDTO.getNomeParametroDTO()%>
         </td>
         
         <td>
             <%= parametroDTO.getNomeParametroItaDTO()%>
         </td>

         <td>
             <%=  parametroDTO.getDescrizioneDTO()%>
         </td>
         
         <td>
             <%= parametroDTO.getDescrizioneItaDTO()%>
         </td>

         <td>
             <%=  parametroDTO.getIconaDTO()%>
         </td>

     </tr>
     
 </table>

 <h3> Indietro</h3>
     <form action="MenuServlet" method="post">
     <input type="submit" value="Indietro" name="richiesta">
     </form>

</body>
</html>