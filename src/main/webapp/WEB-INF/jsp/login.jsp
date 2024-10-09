<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>เข้าสู่ระบบผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
<script src="assets/scripts.js"></script>
</head>
<body>
	<div class="container">
		<h2>เข้าสู่ระบบผู้ใช้</h2>
		<small style="color: red">${err_msg}</small>
		<form action="register" name="frm" method="post">
			<div>
		     	<label for="email">Email:</label>
		   		<input type="email" name="email" maxlength="55" required>
		   	</div>
		    	
			<div>
		      	<label for="password">รหัสผ่าน:</label>
		      	<input type="password" name="password" autocomplete="off" maxlength="50" required>
		    </div>
		    	  
		   	<div>
		   		<button type="submit">เข้าสู่ระบบ</button>
		   	</div>
		</form>
	</div>
</body>
</html>