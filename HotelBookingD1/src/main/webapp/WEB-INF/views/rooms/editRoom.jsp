<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Room</title>
</head>
<body>
	<h1>Edit Room</h1>
	<form action="/hotel/rooms/saveRoom">

	<div>
		<p>Room Name:   <input type="text" name="RoomName" value="${roomData.roomType.roomName}"/></p>
		<p>NoOfPersons: <input type="text" name="NoPersons" value="${roomData.noOfPersons}"/></p>
		<p>Description: <input type="text" name="description" value="${roomData.description}"/></p>
		<p>Room Price: <input type="text" name="price" value="${roomData.roomType.roomPrice}"/></p>
		<p><button type="submit">Done</button></p>
	</div>
 </form>
 
</body>
</html>