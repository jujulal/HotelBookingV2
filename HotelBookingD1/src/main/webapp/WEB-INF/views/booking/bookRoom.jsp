<%@ include file="../header.jsp" %>
<script>

  $(document).ready(function() {
    $("#checkIndatepicker").datepicker();
    $("#checkOutdatepicker").datepicker();
  });

  </script>
  <style>
    .error {
        color: red; font-weight: bold;
    }
 </style>
	<h1>Booking Room Search</h1>
	<form:form action="/hotel/booking/roomsBook" modelAttribute="booking" method="post">
		
			<p><a href="/hotel">Home</a></p>
			
			<table border="0">
			
			<tr>
				<td>Check-In Date:</td><td><form:input type="text" path="checkInDate" name="checkIn" id="checkIndatepicker"/></td>
				<td><form:errors path="checkInDate" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Check-Out Date:</td><td><form:input type="text" path="checkoutDate" name="checkOut" id="checkOutdatepicker"/></td> 
				<td><form:errors path="checkoutDate" cssClass="error"/></td>
			</tr>
			<tr>
				<td>No Of Persons:</td><td><input type="text" name="number" id="noOfPersons"/></td>
				<td></td>
			</tr>
			</table>
			<p><input type="submit" value="Search"/></p>	
	</form:form>

<%@ include file="../footer.jsp" %>