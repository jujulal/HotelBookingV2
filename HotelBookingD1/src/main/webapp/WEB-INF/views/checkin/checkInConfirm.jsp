<%@ include file="../header.jsp" %>
<div>
<script type="text/javascript">

</script>
<h3>Booking Infromation</h3>
	<table class="table table-striped">
		<tr>
			<td>Booking No</td>
			<td>${booking.bookingNo}</td>
		</tr>
		<tr>
			<td>Booking Date</td>
			<td>${booking.bookingDate}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${booking.customer.firstName} ${booking.customer.lastName}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${booking.customer.phone}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${booking.customer.email}</td>
		</tr>
		<tr>
			<td>Room</td>
			<td>${booking.bookedRoom.roomType.roomName}</td>
		</tr>
		<tr>
			<td>Room Capacity Person</td>
			<td>${booking.bookedRoom.noOfPersons}</td>
		</tr>
		<tr>
			<td>Room No</td>
			<td>${booking.bookedRoom.roomNo}</td>
		</tr>
	</table>
	
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/checkin/confirmByPass?bookingNo=${booking.bookingNo}&updated=ok">
		Check In</a>
	<%
    if (request.getParameter("updated") != null) {
        
        out.println("<div class = 'alert alert-success'><b>Check In Successfull</b>!</div>");
    }
%>
</div>
<%@ include file="../footer.jsp" %>