<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pet Harmony - Booking Details</title>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/css/style_bookingdetails.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
    <div class="container">
    <div class="header">
            <div class="logo">
                <img src="assets/icon/logo.png" alt="Pet Harmony Logo">
                <h1>Pet Harmony</h1>
            </div>
            <div class="title-section">
                <h1>รายละเอียดการจอง</h1>
            </div>
        </div>
	
        <c:if test="${not empty booking}">
            <div class="booking-details">
                <h2>รหัสการจอง: ${booking.bookingId}</h2>
                <div class="detail-item">
                    <span class="detail-label">วันที่เข้าพัก</span>
                    <span class="detail-value">${booking.startDate.time}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label">วันที่ออกห้องพัก</span>
                    <span class="detail-value">${booking.endDate.time}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label">คำขอร้องเพิ่มเติม</span>
                    <span class="detail-value">${booking.request}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label">สถานะการจอง</span>
                    <span class="detail-value">${booking.status.statusName}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label">ห้องพัก</span>
                    <span class="detail-value">${booking.room.roomType.roomTypeName}</span>
                </div>
                <div class="detail-item">
                    <span class="detail-label">หมายเลขห้องพัก</span>
                    <span class="detail-value">${booking.room.roomId}</span>
                </div>
            </div>
        </c:if>

        <div class="activities-section">
            <h2>กิจกรรมสัตว์เลี้ยง</h2>
            <c:if test="${not empty activity}">
                <ul class="activities-list">
                    <c:forEach var="petActivity" items="${activity}">
                        <li class="activity-card">
                            <h3>${petActivity.activityDetail}</h3>
                            <img src="assets/img/${petActivity.activityImage}" alt="Activity Image">
                            <div class="activity-date">
                                Activity Date: ${petActivity.activityDate}
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>

            <c:if test="${empty activity}">
                <div class="message">${message}</div>
            </c:if>
        </div>

        <a href="/Project_PetHotel/" class="back-button">
            กลับไปยังหน้าหลัก
        </a>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>