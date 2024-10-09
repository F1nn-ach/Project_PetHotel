<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ลงทะเบียนผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
<script src="assets/scripts.js"></script>
</head>
<body>
    <div class="container">
        <h2>ลงทะเบียนผู้ใช้ใหม่</h2>
        <small style="color: red;">${err_msg}</small>
        <form action="register" name="frm" method="post" onsubmit="confirmPassword(event)">
            <div>
                <label for="firstName">ชื่อจริง</label>
                <input type="text" name="firstname" maxlength="50" required>
            </div>

            <div>
                <label for="lastName">นามสกุล</label>
                <input type="text" name="lastname" maxlength="50" required>
            </div>

            <div>
                <label for="email">อีเมล</label>
                <input type="email" name="email" maxlength="50" required>
            </div>

            <div>
                <label for="phone">เบอร์โทรศัพท์</label>
                <input type="tel" name="phone" maxlength="10" required>
            </div>

            <div>
                <label for="password">รหัสผ่าน</label>
                <input type="password" id="password" name="password" maxlength="55" required oninput="confirmPassword()">
            </div>

            <div>
                <label for="confirm_password">ยืนยันรหัสผ่าน</label>
                <input type="password" id="confirm_password" name="confirm_password" maxlength="55" required oninput="confirmPassword()">
                <div id="pwd_msg" style="color: red;"></div>
            </div>

            <div>
                <button type="submit">ลงทะเบียน</button>&nbsp;<button type="reset">ยกเลิก</button>
            </div>
        </form>
    </div>
</body>
</html>
