<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>การจอง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <link rel="stylesheet" href="style.css"> <!-- เชื่อมโยง CSS ของคุณที่นี่ -->
</head>
<body>
    <div class="container">
        <h2>Pet Booking</h2>

        <c:if test="${not empty message}">
            <div class="no-data-message">
                <p>${message}</p>
            </div>
        </c:if>

        <c:if test="${empty message}">
            <form action="booking" method="post">
                <div>
                    <label for="pet">เลือกสัตว์เลี้ยงของคุณ</label>
                    <select name="pet" id="pet" required>
                        <option value="" disabled selected>-- เลือกสัตว์เลี้ยง --</option>
                        <c:forEach items="${petList}" var="pet">
                            <option value="${pet.id}">${pet.name} - ${pet.type}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div>
                    <label for="startDate">Start Date</label>
                    <input type="date" id="startDate" name="startDate" >
                </div>
                
                <div>
                    <label for="startTime">Start Time</label>
                    <select id="startTime" name="startTime" >
                        <option value="" disabled selected>-- เลือกเวลา --</option>
                        <!-- เวลาเริ่มต้นจะถูกเติมข้อมูลที่นี่ด้วย JavaScript -->
                    </select>
                </div>
        
                <div>
                    <label for="endDate">End Date</label>
                    <input type="date" id="endDate" name="endDate" >
                </div>

                <div>
                    <label for="endTime">End Time</label>
                    <select id="endTime" name="endTime" >
                        <option value="" disabled selected>-- เลือกเวลา --</option>
                        <!-- เวลาสิ้นสุดจะถูกเติมข้อมูลที่นี่ด้วย JavaScript -->
                    </select>
                </div>
                
                <div>
                    <label for="requests">Requests:</label>
                    <textarea id="requests" name="requests" rows="4" cols="50"></textarea>
                </div>
        
                <div>
                    <button type="submit">ลงทะเบียน</button>&nbsp;<button type="reset">ยกเลิก</button>
                </div>
            </form>
        </c:if>
    </div>	

    <script src="assets/js/booking.js"></script>
</body>
</html>
