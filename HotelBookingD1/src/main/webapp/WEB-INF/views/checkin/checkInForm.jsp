<%@ include file="../header.jsp" %>
<div id="checkin">
<h3>CheckIn</h3>
<form:form action="${pageContext.request.contextPath}/checkin/confirm" modelAttribute="bookingNo" method="GET">
	Booking No<input type="text" name="bookingNo" />
	<input type="submit" value="CheckIn"/>
</form:form>
</div>
<%@ include file="../footer.jsp" %>