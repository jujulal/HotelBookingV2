<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Form</title>
</head>
<body>
<div>
${rooms[0].description}
</div>
	<div>
	<h1>Booking Form</h1>
	<form:form action="${pageContext.request.contextPath}/booking/confirm" commandName="booking" method="POST">
		<div id="searchDiv">
			<h3>Search</h3>
			<div>Check-in</div>
			<div><form:input type="datetime-local" path="checkInDateTrans"/></div> 
			<div>Check-out</div>
			 <%-- <div><form:input path="checkoutDateTrans"/></div> --%> 
		</div>
		
		
		<table border="0">
			<tr>
				<td>First Name</td><td><form:input path="customer.fristName"/></td>
			</tr>
			<tr>
				<td>Last Name</td><td><form:input path="customer.lastName"/></td>
			</tr>
			<tr>
				<td>Email</td><td><form:input path="customer.email"/></td>
			</tr>
			<tr>
				<td>Phone</td><td><form:input path="customer.phone"/></td>
			</tr>
			<tr>
				<td>Street</td><td><form:input path="customer.street"/></td>		
			</tr>
			<tr>
				<td>City</td><td><form:input path="customer.city"/></td>
			</tr>
			<tr>
				<td>State</td><td><form:input path="customer.state"/></td>
			</tr>
			<tr></tr><td><input type="submit" value="Confirm Booking"/></td>
		</table>
					
		</form:form>
	</div>
</body>
</html>