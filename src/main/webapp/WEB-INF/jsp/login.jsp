<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>เข้าสู่ระบบ</title>
	<script src="assets/scripts.js"></script>
	<link rel="stylesheet" type="text/css" href="assets/style_login.css">
</head>
<body>
	<div class="container">
		<h3>เข้าสู่ระบบผู้ใช้</h3>
		<small style="color: red">${err_msg}</small>
		<section>
			<div>
				<label for="name">Email:</label>
				<input type="email" name="email" required>
				<small id="err_email" style="color: red;"></small>
			</div>
			<div>
				<label for="passwprd">Password:</label>
				<input type="password" name="password" required>
			</div>
			<div>
				<button type="submit" onClick="return isValidated(this.form)">Login</button>&nbsp;<button type="reset">Cancel</button>
			</div>
		</section>
	</div>
</body>
</html>