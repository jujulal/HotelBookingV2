<%@ include file="../header.jsp" %>

	<h1>Edit Room</h1>
	<form action="/hotel/rooms/saveRoom">

	<div>
		<p>Room Name:   <input type="text" name="RoomName" value="${roomData.roomType.roomName}"/>
		 </p>
		<p>NoOfPersons: <input type="text" name="NoPersons" value="${roomData.noOfPersons}"/></p>
		<p>Description: <input type="text" name="description" value="${roomData.description}"/></p>
		<p>Room Price: <input type="text" name="price" value="${roomData.roomType.roomPrice}"/></p>
		<p><button type="submit">Done</button></p>
	</div>
 </form>
 
<%@ include file="../footer.jsp" %>