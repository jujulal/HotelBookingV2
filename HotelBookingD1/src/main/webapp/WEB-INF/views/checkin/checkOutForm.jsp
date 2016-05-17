<%@ include file="../header.jsp" %>
<div id="checkout">
<h3>CheckOut</h3>
<form:form action="${pageContext.request.contextPath}/checkout/confirm" modelAttribute="bookingNo" method="GET">
	Booking No<input type="text" name="bookingNo" />
	<input type="submit" value="CheckOut"/>
</form:form>
</div>
<%@ include file="../footer.jsp" %>