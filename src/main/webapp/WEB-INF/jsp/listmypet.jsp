<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% int i = 1; %>
<!DOCTYPE html>
<html>
<head>
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
	                <th>Type</th>
	                <th>Request</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${user.pets}" var="item">
		            <tr>
		            	<td><%= i++ %></td>
		                <td>${item.name}</td>
		                <td>${item.gender}</td>
		                <td>${item.type}</td>
		                <td>${item.request}</td>
		            </tr>        	
	        	</c:forEach>
	        </tbody>
   	 	</table>
	</div>
</body>
</html>