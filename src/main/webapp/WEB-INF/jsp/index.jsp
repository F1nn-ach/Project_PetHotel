<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="th">
<head>
    <meta charset="UTF-8">
    <title>Pet Harmony</title>
    <link rel="stylesheet" type="text/css" href="assets/style.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@400;500;700&family=Prompt:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">

        <!-- Header -->
        <div class="header">
            <header>
                <div class="Title">
                    <img alt="Logo of Pet Harmony" src="assets/img/logo.png">
                    <h1>Pet Harmony</h1>
                </div>
	                <div class="nav-head">
	                    <nav>
	                    	<div class="main-nav">
	                    		<a href="#home" class="home">Home</a>
		                        <a href="#service" class="service">Service</a>
		                        <a href="#about" class="about">About</a>
		                        <a href="#contact" class="contact">Contact</a>
                    	</div>
                        <div class="sub-nav">
                        	<div class="link-login">
                        		<img alt="Login icon" src="assets/img/enter.png">
                        		<a href="login">Login</a>
                        	</div>
                        	<div class="link-signup">
                        		<img alt="Sign-up icon" src="assets/img/add-user.png">
                        		<a href="register">Sign-up</a>
                        	</div>
                        	<div class="link-logout">
                        		<img alt="logout icon" src="assets/img/power-on.png">
                        		<a href="logout">Logout</a>
                        	</div>
		                </div>
                    </nav>
                </div>
                <div class="sub-header">
                	<div class="head-title">
                		<h3>สัตว์เลี้ยงมีความสุข มนุษย์ก็มีความสุข</h3>
                		<img alt="Customer service icon" src="assets/img/customer-service.png">
                	</div>
                    <p>คุณกำลังยุ่งจนไม่มีเวลาดูแลสัตว์เลี้ยงใช่ไหม? ถ้าการดูแลสัตว์เลี้ยงเป็นเรื่องยากในช่วงที่คุณไม่ว่าง ให้เราช่วยคุณดูแลพวกเขาเอง!</p>
                </div>
            </header>
        </div>

        <!-- Body Page -->
        <div class="body-content">

            <!-- Main Section -->
            <section id="home" class="main-content">
                <div class="main-paragraph">
                    <p>"สัตว์เลี้ยงของคุณสมควรได้รับการดูแลที่ดีที่สุดเสมอ เราพร้อมที่จะช่วยเหลือและให้ความรักต่อสัตว์เลี้ยงของคุณในทุกช่วงเวลา เพราะการดูแลสัตว์เลี้ยงไม่ใช่แค่หน้าที่ แต่คือการสร้างสายใยแห่งความรักและความผูกพันที่ยาวนาน"</p>
                    <p>"ความสุขของสัตว์เลี้ยง คือความสุขของคุณ ให้ Pet Harmony เป็นส่วนหนึ่งในการสร้างวันใหม่ที่เต็มไปด้วยรอยยิ้มของสัตว์เลี้ยงที่คุณรัก"</p>
                </div>
            </section>

            <!-- Service Section -->
            <section id="service" class="service-content">
                <div class="head-service">
                    <h2>มาดูกันว่าเรามีดีอะไร!</h2>
                </div>
                <div class="service">
                    <ul>
                        <li>
	                        <div class="se-li">
	                        <img alt="Veterinary care icon" src="assets/img/veterinary.png">
	                        <p>ดูแล</p>
	                        </div>
                        </li>
                        <li>
	                        <div class="se-li">
	                        <img alt="Pet food icon" src="assets/img/pet-food.png">
	                        <p>อาหาร</p>
	                        </div>
                        </li>
                        <li>
	                        <div class="se-li">
	                        <img alt="Pet health icon" src="assets/img/vet.png">
	                        <p>สุขภาพ</p>
	                        </div>
                        </li>
                        <li>
	                        <div class="se-li">
	                        <img alt="Dog playing icon" src="assets/img/dog.png">
	                        <p>เล่น</p>
	                        </div>
                        </li>
                    </ul>
                </div>
            </section>
    
            <!-- Sub Content -->
            <section id="about" class="sub-content">
                <div class="content-header">
                    <h2>ทำไมต้องเลือกเรา</h2>
                </div>
                <div class="content-body">
                    <p>
                        <strong>เพราะเรารักสุนัข</strong> <br>
                        เราเข้าใจดีว่าเพื่อนขนปุยของคุณไม่ใช่แค่สัตว์เลี้ยง แต่คือสมาชิกที่สำคัญในครอบครัวของคุณ เรามุ่งมั่นที่จะให้การดูแลอย่างดีที่สุดเพื่อให้พวกเขารู้สึกอบอุ่น ปลอดภัย และมีความสุขทุกครั้งที่อยู่กับเรา
                    </p>
                    <p>
                        <strong>สะดวกสบาย</strong> <br>
                        เรารู้ว่าคุณมีตารางที่ยุ่งเหยิง นอกจากการนัดหมายที่ยืดหยุ่นแล้ว เรายังมีระบบการจองออนไลน์ที่ง่ายและรวดเร็วเพื่อให้คุณสามารถนัดหมายการดูแลได้ตามที่คุณสะดวก
                    </p>
                    <p>
                        <strong>การดูแลส่วนบุคคล</strong> <br>
                        ทีมงานมืออาชีพของเราทุกคนได้รับการฝึกฝนมาเป็นอย่างดีและพร้อมให้การดูแลสุนัขแต่ละตัวอย่างใกล้ชิด เราใส่ใจรายละเอียดและต้องการให้สัตว์เลี้ยงของคุณได้รับประสบการณ์ที่ดีที่สุด
                    </p>
                    <p>
                        <strong>ความอุ่นใจ</strong> <br>
                        เราเข้าใจดีว่าการทิ้งสัตว์เลี้ยงของคุณไว้อาจทำให้คุณกังวล แต่เรามั่นใจได้ว่าพวกเขาจะได้รับการดูแลอย่างดีที่สุดเสมอในระหว่างที่คุณไม่อยู่
                    </p>
                    <p>
                        <strong>ความโปร่งใส</strong> <br>
                        เราให้ความสำคัญกับการสื่อสารและความไว้วางใจ คุณสามารถมั่นใจได้ว่าการดูแลที่เรามอบให้นั้นคำนึงถึงสุขภาพและความสุขของสัตว์เลี้ยงของคุณเป็นสำคัญ
                    </p>
                </div>
            </section>
        </div>

        <!-- Footer -->
        <footer>
            <p>&copy; 2024 Pet Harmony. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
