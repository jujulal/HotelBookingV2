<%@ include file="../header.jsp" %>
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
<%@ include file="../footer.jsp" %>