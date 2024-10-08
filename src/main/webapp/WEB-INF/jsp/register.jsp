<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ลงทะเบียนผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
</head>
<body>
	<div class="container">
		<h2>ลงทะเบียนผู้ใช้ใหม่</h2>
		<small style="color: red">${err_msg}</small>
		<form action="register" name="frm" method="post">
			<div>
				<label for="firstName">ชื่อจริง</label>
				<input type="text" name="firstName" required>
			</div>

			<div>
				<label for="lastName">นามสกุล</label>
				<input type="text" name="lastName" required>
			</div>

			<div>
				<label for="username">ชื่อผู้ใช้</label>
				<input type="text" name="username" required>
			</div>

			<div>
				<label for="email">อีเมล</label>
				<input type="email" name="email" required>
			</div>

			<div>
				<label for="phone">เบอร์โทรศัพท์</label>
				<input type="tel" name="phone" required>
			</div>

			<div>
				<label for="password">รหัสผ่าน</label>
				<input type="password" name="password" required>
			</div>

			<div>
				<label for="url">เว็บไซต์ (ถ้ามี)</label>
				<input type="url" name="url">
			</div>

			<button type="submit">ลงทะเบียน</button>
		</form>
	</div>
</body>
</html>
