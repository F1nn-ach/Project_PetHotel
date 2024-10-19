<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="th">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>หน้าการจองของคุณ</title>
<link
	href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&family=Prompt:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="assets/css/style_yourbooking.css?v=2.0">
</head>
<body>
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
		<div class="form-header">
			<div class="booking-number">หมายเลขการจอง ${booking.id}</div>
			<div class="status">กำลังดำเนินการ</div>
		</div>

		<div class="info-section">
			<h3>ข้อมูลลูกค้า</h3>
			<div class="info-item">
				<span class="info-label">ผู้จอง</span> <span>${user.firstname}
					${user.lastname}</span>
			</div>
			<div class="info-item">
				<span class="info-label">ชื่อสัตว์เลี้ยง</span> <span>${pet.name}</span>
			</div>
			<div class="info-item">
				<span class="info-label">ประเภทสัตว์เลี้ยง</span> <span>${pet.type}</span>
			</div>
		</div>

		<div class="info-section">
			<h3>รายละเอียดการจอง</h3>
			<div class="info-item">
				<span class="info-label">วันที่เข้าพัก</span> <span><fmt:formatDate
						value="${booking.startDate.time}"
						pattern="dd MMMM yyyy - HH:mm น." /></span>
			</div>
			<div class="info-item">
				<span class="info-label">วันที่รับสัตว์เลี้ยง</span> <span><fmt:formatDate
						value="${booking.endDate.time}" pattern="dd MMMM yyyy - HH:mm น." /></span>
			</div>
		</div>
		<%--     <div class="booking-summary">
      <table>
        <thead>
          <tr>
            <th>Description</th>
            <th>Start Date</th>
            <th>End Date</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Pet Booking</td>
            <td><fmt:formatDate value="${booking.startDate.time}" pattern="dd MMMM yyyy - HH:mm น." /></td>
            <td><fmt:formatDate value="${booking.endDate.time}" pattern="dd MMMM yyyy - HH:mm น." /></td>
          </tr>
        </tbody>
      </table>
    </div> --%>

		<div class="thank-you">ขอบคุณที่ใช้บริการของเรา!</div>
		<div class="note">
			<strong>หมายเหตุ:</strong> กรุณาเก็บหน้านี้ไว้เป็นหลักฐานการจอง
			หากมีข้อสงสัยกรุณาติดต่อเจ้าหน้าที่
		</div>
		<a href="backtohome" class="back-button">กลับสู่หน้าหลัก</a>
	</div>
</body>
</html>