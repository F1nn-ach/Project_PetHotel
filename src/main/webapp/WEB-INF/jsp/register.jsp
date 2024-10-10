<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ลงทะเบียนผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
<script src="assets/scripts.js"></script>
<link rel="stylesheet" type="text/css" href="assets/style.css?v=1.0">
</head>
<body>
    <div class="container">
        <h2>ลงทะเบียนผู้ใช้ใหม่</h2>
        <small style="color: red">${err_msg}</small>
        <form action="register" name="frm" method="post" onsubmit="confirmPassword(event)">
            <div>
                <label for="email">Email:</label>
                <input type="email" name="email" maxlength="55" required>
            </div>

            <div>
                <label for="phonenumber">Phone Number:</label>
                <input type="tel" name="phone" maxlength="10" required>
            </div>

            <div>
                <label for="firstname">ชื่อ:</label>
                <input type="text" name="firstname" maxlength="50" required>
            </div>

            <div>
                <label for="lastname">นามสกุล:</label>
                <input type="text" name="lastname" maxlength="50" required>
            </div>

            <div>
                <label for="password">รหัสผ่าน:</label>
                <input type="password" id="password" name="password" autocomplete="off" maxlength="55" oninput="confirmPassword()" required>
            </div>

            <div>
                <label for="confirm_pwd">ยืนยันรหัสผ่าน:</label>
                <input type="password" id="confirm_pwd" name="confirm_pwd" autocomplete="off" maxlength="55" oninput="confirmPassword()" required>
            	<div id="pwd_msg" style="color: red;"></div>
            </div>            

            <div>
                <button type="submit">เข้าสู่ระบบ</button>&nbsp;<button type="reset">ยกเลิก</button>
            </div>
        </form>
    </div>
</body>
</html>
