<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>แก้ไขข้อมูลโปรไฟล์</title>
<script src="assets/scripts.js"></script>
</head>
<body>
	<div class="container">
		<h2>แก้ไขข้อมูลโปรไฟล์</h2>
		<small style="color: red">${err_msg}</small>
		<form action="edityourprofile" method="post">
			<div>
				<label>ชื่อจริง:</label>
				<input type="text" name="firstname" value="${user.firstname}" maxlength="50" required>
			</div>
			
			<div>
				<label>นามสกุล:</label>
				<input type="text" name="lastname" value="${user.lastname}" maxlength="50" required>
			</div>
			
			<div>
				<label>เบอร์มือถือ:</label>
				<input type="tel" name="phone" value="${user.phoneNumber}" maxlength="10" required>
			</div>
			
			<div>
				<label>อีเมล:</label>
				<input type="text" name="email" value="${user.email}" readonly>
			</div>	
			
                <input type="hidden" name="password" maxlength="55" required>
			
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