<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div>

<ul>
	<li><a href="/hotel/booking">Booking</a></li>
	<li><a href="">Avialable Room</a></li>
	<li><a href="">Room Details</a></li>
	<li><a href="/hotel/booking">User</a></li>
</ul>
</div>
<h1>
	Hello world!  
</h1>
<h2>Welcome : ${pageContext.request.userPrincipal.name} 
           | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
