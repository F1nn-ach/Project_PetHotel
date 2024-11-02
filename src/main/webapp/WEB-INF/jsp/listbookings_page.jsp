<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ข้อมูลการจองของฉัน</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style_bookinglist.css?v=1.2">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="header.jsp" />
    
    <div class="page-container">
        <div class="content-container">
            <div class="content-card">
                <div class="header">
                    <div class="logo">
                        <img alt="Logo" src="assets/icon/logo.png">
                        <h1>Pet Harmony</h1>
                    </div>

                    <div class="title-section">
                        <h2>ข้อมูลการจอง</h2>
                        <a href="booking" class="add-booking-button">
                            <i class="fas fa-plus"></i> จองห้อง
                        </a>
                    </div>
                </div>

                <div class="table-container">
                    <c:if test="${not empty message}">
                        <div class="no-data-message">
                            <p>${message}</p>
                        </div>
                    </c:if>
                    
                    <c:if test="${empty message}">
                        <c:if test="${not empty err_msg}">
                            <div class="error-message">
                                <p>${err_msg}</p>
                            </div>
                        </c:if>
                        
                        <table class="booking-table">
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
                                <c:forEach items="${bookings}" var="item" varStatus="status">
                                    <tr onclick="window.location.href='getBooking?id=${item.bookingId}'">
                                        <td class="center-align">${status.count}</td>
                                        <td>${item.bookingId}</td>
                                        <td><fmt:formatDate value="${item.startDate.time}" pattern="dd/MM/yyyy"/></td>
                                        <td><fmt:formatDate value="${item.endDate.time}" pattern="dd/MM/yyyy"/></td>
                                        <td>${item.room.roomId}</td>
                                        <td>${item.pet.petName}</td>
                                        <td class="status-cell status-${item.status.statusName.toLowerCase()}">${item.status.statusName}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>

                <div class="navigation-links">
                    <a href="/" class="nav-button">
                        <i class="fas fa-home"></i> กลับไปหน้าหลัก
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>