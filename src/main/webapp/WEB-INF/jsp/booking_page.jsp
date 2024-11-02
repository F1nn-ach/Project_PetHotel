<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pet Harmony - Booking</title>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="assets/css/style_booking.css">
</head>
<body>
    <%@ include file="header.jsp"%>
    
    <div class="container">
        <div class="header">
            <div class="logo">
                <img src="assets/img/logo.png" alt="Pet Harmony Logo">
                <h1>Pet Harmony</h1>
            </div>
            <div class="title-section">
                <h2>Book a Stay for Your Pet</h2>
            </div>
        </div>

        <c:if test="${not empty err_msg}">
            <div class="error-message">${err_msg}</div>
        </c:if>

        <form action="booking" method="post" id="bookingForm">
            <div class="form-group">
                <label for="pet">Select Your Pet</label>
                <select name="pet" id="pet" required>
                    <option value="" disabled selected>-- Select Your Pet --</option>
                    <c:forEach items="${petList}" var="pet">
                        <option value="${pet.petId}">${pet.petName} - ${pet.petType.petTypeName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>Select Room Type</label>
                <c:forEach items="${roomTypes}" var="roomType">
                    <div class="room-type-card" onclick="selectRoomType(${roomType.roomTypeId})">
                        <input type="radio" name="roomTypeId" value="${roomType.roomTypeId}" required>
                        <h3>${roomType.roomTypeName}</h3>
                        <p>${roomType.description}</p>
                        <p class="price">Price: ฿${roomType.roomTypePrice} per night</p>
                    </div>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="startDate">Check-in Date</label>
                <input type="date" id="startDate" name="startDate" required min="${today}">
            </div>

            <div class="form-group">
                <label for="startTime">Check-in Time</label>
                <select id="startTime" name="startTime" required>
                    <option value="" disabled selected>-- Select Time --</option>
                    <c:forEach var="hour" begin="9" end="17">
                        <option value="${hour}:00">${hour}:00</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="endDate">Check-out Date</label>
                <input type="date" id="endDate" name="endDate" required min="${today}">
            </div>

            <div class="form-group">
                <label for="endTime">Check-out Time</label>
                <select id="endTime" name="endTime" required>
                    <option value="" disabled selected>-- Select Time --</option>
                    <c:forEach var="hour" begin="9" end="17">
                        <option value="${hour}:00">${hour}:00</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="requests">Special Requests</label>
                <textarea id="requests" name="requests" rows="4" maxlength="150" 
                    placeholder="Any special requirements for your pet?"></textarea>
            </div>

            <div class="button-group">
                <button type="submit">Confirm Booking</button>
                <button type="reset">Clear Form</button>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp"%>

    <script>
        const today = new Date().toISOString().split('T')[0];
        document.getElementById('startDate').min = today;
        document.getElementById('endDate').min = today;

        function selectRoomType(roomTypeId) {
            document.querySelectorAll('.room-type-card').forEach(card => {
                card.classList.remove('selected');
            });
            const selectedCard = document.querySelector(`[value="${roomTypeId}"]`).closest('.room-type-card');
            selectedCard.classList.add('selected');
        }

        document.getElementById('endDate').addEventListener('change', function() {
            const startDate = new Date(document.getElementById('startDate').value);
            const endDate = new Date(this.value);
            
            if (endDate < startDate) {
                alert('Check-out date cannot be earlier than check-in date');
                this.value = document.getElementById('startDate').value;
            }
        });

        document.getElementById('bookingForm').addEventListener('submit', function(e) {
            const pet = document.getElementById('pet').value;
            const roomType = document.querySelector('input[name="roomTypeId"]:checked');
            const startDate = document.getElementById('startDate').value;
            const endDate = document.getElementById('endDate').value;
            const startTime = document.getElementById('startTime').value;
            const endTime = document.getElementById('endTime').value;

            if (!pet || !roomType || !startDate || !endDate || !startTime || !endTime) {
                e.preventDefault();
                alert('Please fill in all required fields');
            }
        });
    </script>
</body>
</html>