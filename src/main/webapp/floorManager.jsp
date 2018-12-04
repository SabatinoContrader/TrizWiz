<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Floor Menu</title>
<link rel="stylesheet" href="styles.css">
<a href="CustomerHome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Floor Menu</h1>
<%
		String buildingId = request.getParameter("buildingId");
	%>
	<h2 class="things">Floor del building con id <%=buildingId%> </h2>
	 	<div class="thingDiv">
	<jsp:include page="/Floor">
			<jsp:param name="operation" value="read" />
		</jsp:include>
	
		<div>
			<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="Floor?operation=create&buildingId=<%=buildingId%>">Inserisci Floor </a>
			</div>
		<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="Floor?operation=update&buildingId=<%=buildingId%>">Modifica Floor </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="Floor?operation=delete&buildingId=<%=buildingId%>">Elimina Floor </a>
			</div>
				<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="Downloader?type=xml&buildingId=<%=buildingId%>">Genera XML </a>
			</div>
				<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="Downloader?type=csv&buildingId=<%=buildingId%>">Genera CSV </a>
			</div>
		</div>
	</div>

	<!--  <form action="Floor" method="post">
	<select id="operations" name="operation">
  		<option value="create">Crea Floor</option>
    	<option value="read">Visualizza Floor</option>
   		<option value="update">Modifica Floor</option>
   		<option value="delete">Cancella Floor</option>
	</select>
	<button type="submit">Submit</button><br>
</form>-->


</body>
</html>