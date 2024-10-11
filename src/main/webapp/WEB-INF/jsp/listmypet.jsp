<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% int i = 1; %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ข้อมูลสัตว์เลี้ยงของฉัน</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style_pet_list.css?v=1.1">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
    <div class="page-container">
        <div class="content-container">
            <div class="content-card">
                <div class="header">
                    <div class="logo">
                        <img alt="Logo" src="assets/img/logo.png">
                        <h1>Pet Harmony</h1>
                    </div>
                    
                    <div class="title-section">
                        <h2>รายชื่อสัตว์เลี้ยง</h2>
                        <a href="pet_register" class="add-pet-button">
                            <i class="fas fa-plus"></i>
                            เพิ่มสัตว์เลี้ยง
                        </a>
                    </div>
                </div>

                <div class="table-container">
                    <table class="pet-table">
                        <thead>
                            <tr>
                                <th>ลำดับ</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>Breed</th>
                                <th>Species</th>
                                <th>Request</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${pet}" var="item">
                                <tr>
                                    <td class="center-align"><%= i++ %></td>
                                    <td>${item.name}</td>
                                    <td>${item.gender}</td>
                                    <td>${item.breed}</td>
                                    <td>${item.species}</td>
                                    <td>${item.requests}</td>
                                    <td>
                                        <a href="editmypet?id=${item.id}" class="edit-button">
                                            <i class="fa-regular fa-pen-to-square"></i>
                                            แก้ไขข้อมูล
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="navigation-links">
                    <a href="/Project_PetHotel/" class="nav-button">
                        <i class="fas fa-home"></i>
                        กลับไปหน้าหลัก
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>