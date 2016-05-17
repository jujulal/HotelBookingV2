<%@ include file="../header.jsp" %>


 <h1>Available Rooms</h1>
 <p><a href="/hotel">Home</a></p>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>No of Persons</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${rooms}" var="room">
            <form action="/hotel/rooms/edit/${room.roomNo}" method="post"">
                <tr>
                    <td>${room.roomType.roomName}</td>
                    <td><c:out value="${room.noOfPersons}" /></td>
                    <td><c:out value="${room.description}" /></td>
                    <td><c:out value="${room.roomType.roomPrice}"/> </td>
                    <td><button type="submit" >Edit</button></td>
                </tr>
              </form>
            </c:forEach>
       </table>
       
       
<%@ include file="../footer.jsp" %>