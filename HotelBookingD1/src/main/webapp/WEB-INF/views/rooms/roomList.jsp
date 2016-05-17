<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Rooms</title>
</head>
<body>
	   <h1>All Rooms</h1>
	   <p><a href="/hotel">Home</a></p>
       
        <table border="1">
            <tr>
                <th>Name</th>
                <th>No of Persons</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${rooms}" var="room">
            <form action="/hotel/rooms/edit/${room.roomNo}" method="post">
                <tr>
                    <td>${room.roomType.roomName}
                    	<input type="hidden" name="roomName" value="${room.roomType.roomName}"/>
                    </td>
                    <td><c:out value="${room.noOfPersons}" /></td>
                    <td><c:out value="${room.description}" /></td>
                    <td><c:out value="${room.roomType.roomPrice}"/> </td>
                    <td><button type="submit" >Edit</button></td>
                </tr>
              </form>
            </c:forEach>
       </table>
</body>
</html>