<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>แก้ไขข้อมูลโปรไฟล์</title>
<script src="assets/scripts.js"></script>
	<link rel="stylesheet" type="text/css" href="assets/css/style_editprofile.css?v=1.1">
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&family=Prompt:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h2>แก้ไขข้อมูลโปรไฟล์</h2>
		<small style="color: red">${err_msg}</small>
		<form action="edityourprofile" method="post">
			<div>
				<label>ชื่อจริง:</label>
				<input type="text" name="firstname" value="${user.userFirstname}" maxlength="50" required>
			</div>
			
			<div>
				<label>นามสกุล:</label>
				<input type="text" name="lastname" value="${user.userLastname}" maxlength="50" required>
			</div>
			
			<div>
				<label>เบอร์มือถือ:</label>
				<input type="tel" name="phone" value="${user.userPhone}" maxlength="10" required>
			</div>
			
			<div>
				<label>อีเมล:</label>
				<input type="text" name="email" value="${user.userEmail}" readonly>
			</div>	
			
			<div>
                <button type="submit">แก้ไขข้อมูล</button>
            </div>	
		</form>

		<a href="yourprofile">
			หน้าโปรไฟล์ของคุณ
		</a>
	</div>
</body>
</html>