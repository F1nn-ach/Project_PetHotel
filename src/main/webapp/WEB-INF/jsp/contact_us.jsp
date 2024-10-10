<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ติดต่อพวกเรา</title>
    <link rel="stylesheet" type="text/css" href="assets/style_contact.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <header class="header">
            <div class="header-content">
                <div class="logo">
                    <img alt="Logo" src="assets/img/logo.png">
                    <h1>Pet Harmony</h1>
                </div>
                <nav>
                    <div class="main-nav">
                        <a href="http://localhost:8080/Project_PetHotel/" class="nav-link">Home</a>
                        <a href="#service" class="nav-link">Service</a>
                        <a href="#about" class="nav-link">About</a>
                        <a href="contact" class="nav-link active">Contact</a>
                    </div>
                    <div class="auth-nav">
                        <a href="login" class="btn btn-login">
                            <img alt="" src="assets/img/enter.png">
                            <span>Login</span>
                        </a>
                        <a href="register" class="btn btn-signup">
                            <img alt="" src="assets/img/add-user.png">
                            <span>Sign-up</span>
                        </a>
                    </div>
                </nav>
            </div>
        </header>

        <main class="main-content">
            <section class="contact-section">
                <h1 class="page-title">ติดต่อพวกเรา</h1>
                
                <div class="contact-grid">
                    <div class="contact-info">
                        <div class="info-card">
                            <h2>รายละเอียดการติดต่อ</h2>
                            <div class="info-item">
                                <strong>ที่อยู่:</strong>
                                <p>123 ถนนตัวอย่าง แขวงตัวอย่าง เขตตัวอย่าง กรุงเทพฯ 12345</p>
                            </div>
                            <div class="info-item">
                                <strong>เบอร์โทรศัพท์:</strong>
                                <p>02-123-4567</p>
                            </div>
                            <div class="info-item">
                                <strong>เวลาทำการ:</strong>
                                <p>จันทร์-ศุกร์ 9:00 น. - 18:00 น.</p>
                            </div>
                        </div>

                        <div class="social-links">
                            <a href="https://www.facebook.com/yourpage" target="_blank" class="social-link">
                                <img alt="facebook icon" src="assets/img/facebook.png">
                            </a>
                            <a href="https://line.me/ti/p/yourlineid" target="_blank" class="social-link">
                                <img alt="line icon" src="assets/img/line.png">
                            </a>
                            <a href="https://www.instagram.com/" target="_blank" class="social-link">
                                <img alt="instagram icon" src="assets/img/instagram.png">
                            </a>
                        </div>
                    </div>

                    <div class="map-container">
                        <h2>แผนที่ตำแหน่งของเรา</h2>
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3151.8354345090585!2d144.9556513155069!3d-37.81732617975144!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6ad65d43f5fef35f%3A0x2d2aa1ba9aa23f27!2sFederation%20Square!5e0!3m2!1sen!2sth!4v1602729216070!5m2!1sen!2sth"
                            allowfullscreen="" loading="lazy">
                        </iframe>
                    </div>
                </div>
            </section>
        </main>
    </div>
</body>
</html>