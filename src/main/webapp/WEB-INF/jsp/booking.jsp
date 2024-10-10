<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>การจอง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="assets/style_booking.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
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
            <form action="process_booking" method="post">
                <div>
                    <label for="pet">เลือกสัตว์เลี้ยงของคุณ</label>
                    <select name="pet" id="pet" required>
                        <option value="" disabled selected>-- เลือกสัตว์เลี้ยง --</option>
                        <c:forEach items="${petList}" var="pet">
                            <option value="${pet.id}">${pet.name} - ${pet.breed}</option>
                        </c:forEach>
                    </select>    	
                </div>
                
                <div>
                    <label for="startDate">Start Date</label>
                    <input type="date" id="startDate" name="startDate" required>		
                </div>
                
                <div>
                    <label for="startTime">Start Time</label>
                    <select id="startTime" name="startTime" required>
                        <option value="" disabled selected>-- เลือกเวลา --</option>

                    </select>				
                </div>
        
                <div>
                    <label for="endDate">End Date</label>
                    <input type="date" id="endDate" name="endDate" required>
                </div>

                <div>
                    <label for="endTime">End Time</label>
                    <select id="endTime" name="endTime" required>
                        <option value="" disabled selected>-- เลือกเวลา --</option>

                    </select>
                </div>
                <div>
                    <button type="submit">ลงทะเบียน</button>&nbsp;<button type="reset">ยกเลิก</button>
                </div>
            </form>
        </c:if>
    </div>	

    <script src="assets/booking.js"></script>
</body>
</html>
