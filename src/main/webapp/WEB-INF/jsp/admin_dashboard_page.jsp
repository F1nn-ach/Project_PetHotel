<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pet Harmony - Admin Dashboard</title>
<link
	href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&family=Playfair+Display:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/style_dashboard.css?v=1.0">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="header">
			<div class="logo">
				<img src="assets/icon/logo.png" alt="Pet Harmony Logo">
				<h1>Pet Harmony</h1>
			</div>
			<div class="title-section">
				<h1>Admin Dashboard - ${admin.userFirstname}</h1>
			</div>
		</div>

		<c:if test="${not empty err_msg}">
			<div class="err_msg">${err_msg}</div>
		</c:if>

		<div class="user-section">
			<h2>User and Pet Management</h2>
			<table class="user-table">
				<thead>
					<tr>
						<th>Email</th>
						<th>Name</th>
						<th>Phone</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userPetsMap}" var="entry">
						<tr class="user-row" data-email="${entry.key.userEmail}">
							<td><span class="arrow"></span> ${entry.key.userEmail}</td>
							<td>${entry.key.userFirstname}${entry.key.userLastname}</td>
							<td>${entry.key.userPhone}</td>
						</tr>
						<tr class="pet-details" id="petDetails-${entry.key.userEmail}">
							<td colspan="3">
								<table class="pet-table">
									<thead>
										<tr>
											<th>Pet Name</th>
											<th>Type</th>
											<th>Gender</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${entry.value}" var="pet">
											<tr>
												<td>${pet.petName}</td>
												<td>${pet.petType.petTypeName}</td>
												<td>${pet.petGender}</td>
											</tr>
										</c:forEach>
										<c:if test="${empty entry.value}">
											<tr>
												<td colspan="4">No pets registered</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="booking-content">
			<h2>Booking Management</h2>

			<c:forEach items="${bookingsByStatus}" var="statusGroup">
				<div class="booking-status-section">
					<h3 class="status-header status-${statusGroup.key.toLowerCase()}">${statusGroup.key}</h3>
					<table>
						<thead>
							<tr>
								<th>ลำดับ</th>
								<th>รหัสการจอง</th>
								<th>วันที่เริ่มต้น</th>
								<th>วันที่สิ้นสุด</th>
								<th>ห้อง</th>
								<th>สัตว์เลี้ยง</th>
								<th>สถานะ</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${statusGroup.value}" var="item"
								varStatus="status">
								<tr
									onclick="window.location.href='editBooking?id=${item.bookingId}'">
									<td>${status.count}</td>
									<td>${item.bookingId}</td>
									<td><fmt:formatDate value="${item.startDate.time}"
											pattern="dd/MM/yyyy" /></td>
									<td><fmt:formatDate value="${item.endDate.time}"
											pattern="dd/MM/yyyy" /></td>
									<td>${item.room.roomId}</td>
									<td>${item.pet.petName}</td>
									<td class="status-${item.status.statusName.toLowerCase()}">${item.status.statusName}</td>
								</tr>
							</c:forEach>
							<c:if test="${empty statusGroup.value}">
								<tr>
									<td colspan="7" class="no-bookings">ไม่มีการจองในสถานะนี้</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</div>
		<script>
        document.addEventListener('DOMContentLoaded', function() {
            document.querySelectorAll('.user-row').forEach(row => {
                row.addEventListener('click', function() {
                    const email = this.getAttribute('data-email');
                    const petDetails = document.getElementById('petDetails-' + email);
                    const arrow = this.querySelector('.arrow');
                    
                    if (petDetails.style.display === 'none' || !petDetails.style.display) {
                        petDetails.style.display = 'table-row';
                        arrow.classList.add('expanded');
                    } else {
                        petDetails.style.display = 'none';
                        arrow.classList.remove('expanded');
                    }
                });
            });
        });
    </script>
</body>
</html>