<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <meta charset="UTF-8">
    <title>ข้อมูลส่วนตัว</title>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&family=Prompt:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <%@ include file="header.jsp" %>
        
        <h2>ข้อมูลโปรไฟล์</h2>
        <a href="edityourprofile"><i class="fa-solid fa-user-pen"></i>แก้ไขข้อมูล</a>
        
        <div>
            <label>ชื่อจริง:</label>
            <input type="text" name="firstname" value="${user.firstname}" readonly>
        </div>

        <div>
            <label>นามสกุล:</label>
            <input type="text" name="lastname" value="${user.lastname}" readonly>
        </div>

        <div>
            <label>เบอร์มือถือ:</label>
            <input type="text" name="phone" value="${user.phoneNumber}" readonly>
        </div>

        <div>
            <label>อีเมล:</label>
            <input type="text" name="email" value="${user.email}" readonly>
        </div>

        <a href="listpets">
            <i class="fa-solid fa-paw"></i>ไปดูสัตว์เลี้ยงของคุณกันเถอะ!
        </a>
        <a href="/Project_PetHotel/">กลับหน้าหลัก</a>
    </div>
</body>
</html>