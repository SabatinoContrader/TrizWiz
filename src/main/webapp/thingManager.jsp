<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">

<title>Thing Menu</title>
<a href="/Installer/goBackSuper" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	   	<h1>Thing Menu</h1>
	   	<h2 class="things">Things</h2>
	   	
	   	
	   	<div class="thingDiv">
	   	<jsp:include page="/Thing/read">
     	<jsp:param name="operation" value="ReadThing"/>
     </jsp:include>
		<div>
			<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a href="Thing/insertForm"
					class="customerLink">Inserisci Thing </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://www.nerdhead.net/wp-content/uploads/2017/03/blue-282x300.png"
					class="imgThing"> <a href="Thing/updateForm"
					class="customerLink">Modifica Thing </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://cdn4.iconfinder.com/data/icons/logistic-delivery-20/40/Remove_box_cancel_delete_delivery-512.png"
					class="imgThing"> <a href="Thing/deleteForm"
					class="customerLink">Elimina Thing </a>
			</div>
		</div>
	</div>
<!--  <form action="Thing" method="post">
	<select id="operations" name="operation">
  		<option value="create">Crea Thing</option>
	</select>
	<button type="submit">Submit</button><br>
</form>
-->


</body>
</html>