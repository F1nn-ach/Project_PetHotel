<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pet Harmony - Booking Edit</title>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/css/style_editbooking.css">
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

        <!-- Alert Messages -->
        <div id="successAlert" class="alert alert-success">
            การดำเนินการเสร็จสิ้น
        </div>
        <div id="errorAlert" class="alert alert-error">
            เกิดข้อผิดพลาด กรุณาลองใหม่อีกครั้ง
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

                <form action="updateStatus" method="POST" class="status-buttons">
                    <input type="hidden" name="bookingId" value="${booking.bookingId}">
                    <button type="submit" name="status" value="3" class="btn btn-cancel">ยกเลิก</button>
                    <button type="submit" name="status" value="4" class="btn btn-success">สำเร็จ</button>
                    <button type="submit" name="status" value="2" class="btn btn-progress">กำลังดำเนินการ</button>
                </form>
            </div>

            <div class="activities-section">
                <h2>กิจกรรมสัตว์เลี้ยง</h2>
                
                <!-- Existing Activities -->
                <div class="pet-activities">
                    <c:forEach items="${petActivities}" var="activity">
                        <div class="activity-card">
                            <p><strong>วันที่:</strong> ${activity.activityDate}</p>
                            <p><strong>รายละเอียด:</strong> ${activity.activityDetail}</p>
                            <c:if test="${not empty activity.activityImage}">
                                <img src="assets/images/activities/${activity.activityImage}" 
                                     alt="Pet Activity" class="activity-image">
                            </c:if>
                        </div>
                    </c:forEach>
                </div>

                <!-- Add New Activity Form -->
                <form action="updateActivity" method="POST" enctype="multipart/form-data" class="activity-form">
                    <div>
                        <label for="activityImg">รูปภาพกิจกรรม:</label>
                        <input type="file" id="activityImg" name="activityImg" 
                               accept="image/*" required class="file-input">
                    </div>
                    
                    <div>
                        <label for="activityDetail">รายละเอียดกิจกรรม:</label>
                        <input type="text" id="activityDetail" name="activityDetail" 
                                  required>
                    </div>
                    
                    <div>
                        <label for="activityDate">วันที่ทำกิจกรรม:</label>
                        <input type="date" id="activityDate" name="activityDate" 
                               required class="date-input">
                    </div>
                    
                    <input type="hidden" value="${booking.pet.petId}" name="petId">
                    <input type="hidden" value="${booking.bookingId}" name="bookingId">
                    
                    <button type="submit" class="btn-submit">บันทึกกิจกรรม</button>
                </form>
            </div>
        </c:if>

        <a href="/Project_PetHotel/" class="back-button">กลับไปยังหน้าหลัก</a>
    </div>

    <%@ include file="footer.jsp"%>

    <script>
        // Show alerts based on URL parameters
        window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get('success') === 'true') {
                const successAlert = document.getElementById('successAlert');
                successAlert.style.display = 'block';
                setTimeout(() => {
                    successAlert.style.display = 'none';
                }, 3000);
            }
            if (urlParams.get('error') === 'true') {
                const errorAlert = document.getElementById('errorAlert');
                errorAlert.style.display = 'block';
                setTimeout(() => {
                    errorAlert.style.display = 'none';
                }, 3000);
            }
        }
    </script>
</body>
</html>