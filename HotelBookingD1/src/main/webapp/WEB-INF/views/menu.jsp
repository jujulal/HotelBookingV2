<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
	<c:url value="/loginnow?logout" var="logoutUrl" />

	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<div class="container-fluid">
		<div class="navbar-header"></div>
		<ul class="nav navbar-nav">
			<li ><a href="${pageContext.request.contextPath}">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/checkin">CheckIn</a></li>
			<li><a href="${pageContext.request.contextPath}/checkout">CheckOut</a></li>
				<li><a href="${pageContext.request.contextPath}/booking">Booking</a></li>
	<li><a href="${pageContext.request.contextPath}/rooms">Room Details</a></li>
	<li><a href="${pageContext.request.contextPath}/booking">User</a></li>
		</ul>
		
	</div>
	<div class="navbar-brand pull-right">
	<div class="navbar-header">Welcome : ${pageContext.request.userPrincipal.name}| </div>
	 <a href="javascript:formSubmit()" class="nav navbar-nav"><strong> Logout</strong></a>
		</div>
</nav>