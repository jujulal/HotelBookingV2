<%@ include file="../header.jsp" %>
<div class="container-fluid">
<h3>Booking Infromation</h3>
<div class="row">
	<div class="col-md-6">
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
		<tr>
			<td>Room charge per night</td>
			<td>${booking.bookedRoom.roomType.roomPrice}<input type="hidden" id="roomPriceInput" value="${booking.bookedRoom.roomType.roomPrice}"/> </td>
		</tr> 
		<tr>
			<td>Check-In Date</td>
			<td>${booking.checkInDate}</td>
		</tr>
		
	</table>
	
	<a class="btn btn-primary" href="${pageContext.request.contextPath}/checkout/confirmByPass?bookingNo=${booking.bookingNo}">
		Check Out</a>
		</div><!--  end of class="san6" -->
		
		<div class="col-md-6">
		 <div class="panel panel-info">
    	<div class="panel-heading">Hotel: Bill</div>
    	<div class="panel-body">
			<form action="${pageContext.request.contextPath}/checkout/" method="POST" class="form-horizontal" role="form">
					<input type="hiddne" name="bookingNo" value="${booking.bookingNo}"/>
						<div class="form-group">
							<label for="checkInDate" class="col-sm-3 control-label">Check-In
								Date</label>
							<div class="col-sm-9">
									<input type="text" id="checkInDate" name="checkInDate" class="form-control" value="${booking.checkInDate}" disabled/>
							</div>
						</div>

						<div class="form-group">
							<label for="checkOutDate" class="col-sm-3 control-label">Check-Out
								Date</label>
							<div class="col-sm-9">
								<div class='input-group date' id='datetimepicker1'>
									<input type="date" name="checkOutDate" data-date-format="Y m d" class="form-control" oninput="calDays()"/>
								</div>
							</div>
						</div>

				<script type="text/javascript">
					function calDays(){
						//var checkInDate =new Date(document.getElementById("checkInDate").value);
						var checkOutDate = new Date(document.getElementById("checkOutDate").value);
						
						//var diff = new Date(checkOutDate.getTime() - checkInDate.getTime());
						//var days = diff.getUTCFullYear() - 1970;
						alert("Hello" + checkOutDate);
					}
				</script>
				<div class="form-group">
					<label for="numberOfNights" class="col-sm-3 control-label">Number of Nights</label>
					<div class="col-sm-9">
					<input type="number" id="numberOfNights" name="numberOfNights" min="0" onchange="calcRoomCharge()" class="form-control" placeholder="0"/>
					</div>
				</div>
				<script type="text/javascript">
					function calcRoomCharge(){
						var rate = document.getElementById("roomPriceInput").value;
						
						document.getElementById("roomCharge").value = rate * document.getElementById("numberOfNights").value;
						calcBillAmount();
					}
				</script>
				
				<div class="form-group">
					<label for="roomCharge" class="col-sm-3 control-label">Room Charge</label>
					<div class="col-sm-9">
					<input type="text" id="roomCharge" name="roomCharge" class="form-control" placeholder="Room Charge"/>
					</div>
				</div>
				<div class="form-group">
					<label for="miscCharge" class="col-sm-3 control-label">Miscellaneous Charge</label>
					<div class="col-sm-9">
					<input type="text" id="miscCharge" name="miscCharge" onchange="calcBillAmount()" class="form-control" placeholder="Miscellaneous Charge"/>
					</div>
				</div>
				<div class="form-group">
					<label for="tax" class="col-sm-3 control-label">Tax</label>
					<div class="col-sm-9">
					<input type="text" id="tax" name="tax" onchange="calcBillAmount()" class="form-control" placeholder="Tax"/>
					</div>
				</div>
				<div class="form-group">
					<label for="discount" class="col-sm-3 control-label">Discount</label>
					<div class="col-sm-9">
					<input type="text" id="discount" name="discount" onchange="calcBillAmount()" class="form-control" placeholder="Discount"/>
					</div>
				</div>								
				
				<div class="form-group">
					<label for="billAmount" class="col-sm-3 control-label">Bill Amount</label>
					<div class="col-sm-9">
					<input type="text" id="billAmount" name="billAmount" class="form-control" placeholder="Bill Amount"/>
					</div>
				</div>		
				<script type="text/javascript">
					function calcBillAmount(){
						var sum=0;
						if( parseFloat(document.getElementById("roomCharge").value)>=0)
							sum =sum + parseFloat(document.getElementById("roomCharge").value);
						if(parseFloat(document.getElementById("miscCharge").value)>=0)
							sum=sum + parseFloat(document.getElementById("miscCharge").value);
						if(parseFloat(document.getElementById("tax").value)>=0)
							sum=sum + parseFloat(document.getElementById("tax").value);
						if(parseFloat(document.getElementById("discount").value)>=0)
							sum = sum - parseFloat(document.getElementById("discount").value);
						
						document.getElementById("billAmount").value = sum;
					}
					
				</script>
				
				
				<div class="form-group">
					<label for="description" class="col-sm-3 control-label">Description</label>
					<div class="col-sm-9">
					<textarea rows="" cols="" name="discription" class="form-control" placeholder="Description"></textarea>
					</div>
				</div>
				<div class="form-group">
					<input type="submit" value="Payment Done" class="btn btn-primary"/>
				</div>								
										
												
												
												
			</form>
			</div>
			</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../footer.jsp" %>