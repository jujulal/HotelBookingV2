<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Room</title>
</head>
<body>
	<h1>Book Room</h1>
	<p><a href="/hotel">Home</a></p>
	
	<h3>Available Rooms</h3>
         <table border="1">
            <tr>
            	<th></th>
                <th>Name</th>
                <th>No of Persons</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
           <c:forEach items="${rooms}" var="room">
            <form action="/hotel/booking/confirm" method="post">
                <tr>
                 	<td><input type="radio" name="selectedRoom" value="${room.roomNo}"></input></td>
                    <td>${room.roomType.roomName}</td>
                    <td><c:out value="${room.noOfPersons}" /></td>
                    <td><c:out value="${room.description}" /></td>
                    <td><c:out value="${room.roomType.roomPrice}"/> </td>          
                </tr>
               
            </c:forEach>
       </table> 
       <table>
       <tr><td>Customer No:</td><td><input type="text" name="custNo"/></td></tr>
       </table>
       <br/>
       		<input type="submit" value="Book"/>
        </form> 
</body>
</html>