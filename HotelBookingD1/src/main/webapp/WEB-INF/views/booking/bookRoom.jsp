<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Room Search</title>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

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
</head>
<body>
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

</body>
</html>