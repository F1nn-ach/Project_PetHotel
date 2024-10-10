<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% int i = 1; %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
<meta charset="UTF-8">
<title>ข้อมูลสัตว์เลี้ยงของฉัน</title>
</head>
<body>
	<div class="container">
		<h2>รายชื่อสัตว์เลี้ยง</h2>
		<table>
	        <thead>
	            <tr>
	            	<th>ลำดับ</th>
	                <th>Name</th>
	                <th>Gender</th>
	                <th>Breed</th>
	                <th>Species</th>
	                <th>Request</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${pet}" var="item">
		            <tr>
		            	<td><%= i++ %></td>
		                <td>${item.name}</td>
		                <td>${item.gender}</td>
		                <td>${item.breed}</td>
		                <td>${item.species}</td>
		                <td>${item.requests}</td>
		                <td>
		                	<a href="editmypet?id=${item.id}">
		                		<i class="fa-regular fa-pen-to-square"></i>แก้ไขข้อมูล
		                	</a>
		                </td>
		            </tr>        	
	        	</c:forEach>
	        </tbody>
   	 	</table>
   	 	<a href="/index">กลับไปหน้าหลัก</a>&nbsp;<a href="pet_register">กลับไปลงทะเบียนสัตว์</a>
	</div>
</body>
</html>