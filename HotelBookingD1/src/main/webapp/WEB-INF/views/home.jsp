<%@ include file="header.jsp" %>
<div>

<h1>
	Welcome : ${pageContext.request.userPrincipal.name} 

</h1>
<ul>
	<li><a href="/hotel/booking">Booking</a></li>
	<li><a href="/hotel/rooms">Room Details</a></li>
	<li><a href="/hotel/booking">User</a></li>
</ul>
</div>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
