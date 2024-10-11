<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>เข้าสู่ระบบ</title>
    <script src="assets/js/scripts.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/style_login.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="page-container">
        <div class="login-container">
            <div class="login-card">
                <div class="logo">
                    <img alt="Logo" src="assets/img/logo.png">
                    <h1>Pet Harmony</h1>
                </div>
                
                <h2>เข้าสู่ระบบผู้ใช้</h2>
                
                <form action="login" name="frm" method="post" class="login-form">
                    <small class="error-message">${err_msg}</small>
                    
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <div class="input-wrapper">
                            <input type="email" id="email" name="email" maxlength="55" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password">รหัสผ่าน:</label>
                        <div class="input-wrapper">
                            <input type="password" id="password" name="password" autocomplete="off" maxlength="50" required>
                        </div>
                    </div>

                    <button type="submit" class="login-button">เข้าสู่ระบบ</button>
                    
                    <div class="form-footer">
                        <p>ยังไม่มีบัญชี? <a href="register">สมัครสมาชิก</a></p>
                        <a href="/Project_PetHotel/" class="back-home">กลับหน้าหลัก</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>