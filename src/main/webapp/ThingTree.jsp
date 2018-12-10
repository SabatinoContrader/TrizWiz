<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link href="/resources/css/styles.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-xs-8">
			<c:forEach var="floor" items="${buildingTree.getAllFloors()}">
				<div class="row treeBuildingContainer">
					<div class="col-xs-2 treeFloorContainer">${floor.getNomeFloor()}</div>
					<div class="col-xs-10 treeRoomContainer">
						<c:forEach var="room"
							items="${buildingTree.getRoomsByFloor(floor.getId())}">
							<div class="row treeItemContainer">
								<div class="col-xs-3 text-center">${room.getNomeRoom()}</div>
								<div class="col-xs-9">
									<c:forEach var="item"
										items="${buildingTree.getItemsByRoom(room.getId())}">
										<div class="col-xs-12 text-right">${item.getId()}</div>
									</c:forEach>

								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-xs-4">
		<form action="/BuildingTree/updateAssociation" method="post">
			<c:forEach var="thing" items="${things}">
				<div class="row treeFloorContainer"
					style="margin-left: 5%; font-size: 250%; margin-top: 4%;">NumUscite: ${thing.getNumUscite()}
					<input hidden name="thingId" value="${thing.getId()}">
					<select style="border-radius: 10%; color:black;font-size: 64%;" name="itemId">
				<c:forEach var="item" items="${items}">
						<option style="font-size: small;" value="${item.getId()}">${item.getId()}</option>
				</c:forEach>
			</select>
		
			<c:if test="${items.size()>0}">
					<button class="modifyButton" style="border-radius: 10%" type = "submit"> Associa</button>
				</c:if>
				
				</div>
			</c:forEach>
			</form>
		</div>
	</div>
</body>
</html>