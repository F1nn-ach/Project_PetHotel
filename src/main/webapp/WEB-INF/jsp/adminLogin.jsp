<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>เข้าสู่ระบบ:แอดมิน</title>
</head>
<body>
	<div class="container">
 		<h2>Admin Login</h2>
 		<small style="color: red"></small>
	    <form action="" method="POST">
	        <div class="form-group">
	            <label for="admin-username">Username:</label>
	            <input type="text" name="username" placeholder="Enter admin username" required>
	        </div>
	        <div class="form-group">
	            <label for="admin-password">Password:</label>
	            <input type="password" name="password" placeholder="Enter admin password" required>
	        </div>
	        <div class="form-group">
	            <button type="submit">Login</button>
	        </div>
	    </form>
	</div>
</body>
</html>