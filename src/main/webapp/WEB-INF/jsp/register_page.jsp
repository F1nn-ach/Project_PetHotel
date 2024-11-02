<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ลงทะเบียนผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <script src="assets/js/register.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/style_register.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="page-container">
        <div class="register-container">
            <div class="register-card">
                <div class="logo">
                    <img alt="Logo" src="assets/icon/logo.png">
                    <h1>Pet Harmony</h1>
                </div>
                
                <h2>ลงทะเบียนผู้ใช้ใหม่</h2>
                
                <form action="register_form" name="frm" method="post" class="register-form" onsubmit="confirmPassword(event)">
                    <small class="error-message">${err_msg}</small>
                    
                    <div class="form-row">
                        <div class="form-group">
                            <label for="firstname">ชื่อ:</label>
                            <div class="input-wrapper">
                                <input type="text" id="firstname" name="user_firstname" maxlength="50" required>
                            </div>
	              			<div>
	                        	<small style="color: red;" id="err_firstname"></small>
	                        </div>
                        </div>

                        <div class="form-group">
                            <label for="lastname">นามสกุล:</label>
                            <div class="input-wrapper">
                                <input type="text" id="lastname" name="user_lastname" maxlength="50" required>
                            </div>
                    		<div>
                        		<small style="color: red;" id="err_lastname"></small>
                        	</div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email">อีเมล:</label>
                        <div class="input-wrapper">
                            <input type="email" id="email" name="user_email" maxlength="55" required>
                        </div>
                        <div>
                        	<small style="color: red;" id="err_email"></small>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phonenumber">เบอร์มือถือ:</label>
                        <div class="input-wrapper">
                            <input type="tel" id="phonenumber" name="user_phone" maxlength="10" required>
                        </div>
						<div>
                        	<small style="color: red;" id="err_phone"></small>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password">รหัสผ่าน:</label>
                        <div class="input-wrapper">
                            <input type="password" id="password" name="user_password" autocomplete="off" maxlength="55" oninput="confirmPassword()" required>
                        </div>
              			<div>
                        	<small style="color: red;" id="err_pwd"></small>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm_pwd">ยืนยันรหัสผ่าน:</label>
                        <div class="input-wrapper">
                            <input type="password" id="confirm_pwd" name="confirm_pwd" autocomplete="off" maxlength="55" oninput="confirmPassword()" required>
                        </div>
                        <div id="pwd_msg" class="password-message"></div>
                    </div>

                    <div class="button-group">
                        <button type="submit" class="submit-button" onclick="return isValidated(this.form)">ลงทะเบียน</button>
                        <button type="reset" class="reset-button">ยกเลิก</button>
                    </div>
                    
                    <div class="form-footer">
                        <p>มีบัญชีอยู่แล้ว? <a href="login">เข้าสู่ระบบ</a></p>
                        <a href="/Project_PetHotel/" class="back-home">กลับหน้าหลัก</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>