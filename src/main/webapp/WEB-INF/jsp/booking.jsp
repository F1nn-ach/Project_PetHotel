<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>การจอง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/style_booking.css?v=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&family=Prompt:wght@400;500;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="header">
			<div class="logo">
				<img alt="Logo" src="assets/img/logo.png">
				<h1>Pet Harmony</h1>
			</div>

			<div class="title-section">
				<h2>Pet Booking</h2>
			</div>
		</div>

		<small style="color: red;">${err_msg}</small>
		<form action="booking" method="post">
			<div>
				<label for="pet">เลือกสัตว์เลี้ยงของคุณ</label> <select name="pet"
					id="pet" required>
					<option value="" disabled selected>-- เลือกสัตว์เลี้ยง --</option>
					<c:forEach items="${petList}" var="pet">
						<option value="${pet.id}">${pet.name}-${pet.type}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<label for="startDate">Start Date</label> <input type="date"
					id="startDate" name="startDate" required>
			</div>

			<div>
				<label for="startTime">Start Time</label> <select id="startTime"
					name="startTime" required>
					<option value="" disabled selected>-- เลือกเวลา --</option>
				</select>
			</div>

			<div>
				<label for="endDate">End Date</label> <input type="date"
					id="endDate" name="endDate" required>
			</div>

			<div>
				<label for="endTime">End Time</label> <select id="endTime"
					name="endTime" required>
					<option value="" disabled selected>-- เลือกเวลา --</option>
				</select>
			</div>

			<div>
				<label for="requests">Requests:</label>
				<textarea id="requests" name="requests" rows="4" cols="50"
					maxlength="150"></textarea>
			</div>

			<div>
				<button type="submit">ลงทะเบียน</button>
				&nbsp;
				<button type="reset">ยกเลิก</button>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
	<script src="assets/js/booking.js"></script>
</body>
</html>