<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://bootswatch.com/5/litera/bootstrap.min.css">
    <meta charset="UTF-8">
    <title>ลงทะเบียนผู้ใช้ - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">ลงทะเบียนผู้ใช้ใหม่</h2>
        <form action="register.jsp" method="post">
            <!-- ชื่อจริง -->
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="firstName" placeholder="Firstname" required>
                <label for="firstName">ชื่อจริง</label>
            </div>
            
            <!-- นามสกุล -->
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="lastName" placeholder="Lastname" required>
                <label for="lastName">นามสกุล</label>
            </div>
            
            <!-- ชื่อผู้ใช้ -->
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="username" placeholder="Username" required>
                <label for="username">ชื่อผู้ใช้</label>
            </div>
            
            <!-- อีเมล -->
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="E-mail" required>
                <label for="email">อีเมล</label>
            </div>
            
            <!-- เบอร์โทรศัพท์ -->
            <div class="form-floating mb-3">
                <input type="tel" class="form-control" name="phone" placeholder="Phone Number" pattern="[0-9]{10}" required>
                <label for="phone">เบอร์โทรศัพท์</label>
            </div>
            
            <!-- รหัสผ่าน -->
            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" placeholder="Password" minlength="6" required>
                <label for="password">รหัสผ่าน</label>
            </div>
            
            <!-- URL -->
            <div class="form-floating mb-3">
                <input type="url" class="form-control" name="url" placeholder="Website URL">
                <label for="url">เว็บไซต์ (ถ้ามี)</label>
            </div>
            
            <!-- ปุ่ม Submit -->
            <button type="submit" class="btn btn-primary">ลงทะเบียน</button>
        </form>
    </div>
</body>
</html>
