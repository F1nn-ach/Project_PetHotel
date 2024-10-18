<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>การลงทะเบียนสัตว์เลี้ยง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <link rel="stylesheet" type="text/css" href="assets/css/style_pet_register.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="page-container">
        <div class="content-container">
            <div class="content-card">
                <div class="header">
                    <div class="logo">
                        <img src="assets/img/logo.png" alt="Pet Logo">
                        <h1>ลงทะเบียนสัตว์เลี้ยง</h1>
                    </div>
                </div>

                <small class="error-message">${err_msg}</small>

                <form id="pet_frm" action="pet_register" method="post" class="pet-form">
                    <div class="form-section">
                        <h2>ข้อมูลสัตว์เลี้ยง</h2>

                        <div class="form-group">
                            <label for="pet_name">ชื่อสัตว์เลี้ยง:</label>
                            <input type="text" id="pet_name" name="pet_name" maxlength="50" required>
                        </div>

                        <div class="form-group">
                            <label for="pet_type">ประเภทสัตว์เลี้ยง:</label>
                            <select id="pet_type" name="pet_type" required>
                            	<option value="" disabled selected>-- เลือกสัตว์เลี้ยง --</option>
                                <option value="หมา">หมา</option>
                                <option value="แมว">แมว</option>
                                <option value="นก">นก</option>
                                <option value="กิ้งก่า">กิ้งก่า</option>
                                <option value="กบ">กบ</option>
                                <option value="เต่า">เต่า</option>
                                <option value="งู">งู</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="species">สายพันธุ์สัตว์เลี้ยง:</label>
                            <input type="text" id="species" name="species" maxlength="100" required>
                        </div>

                        <div class="form-group">
                            <label>เพศสัตว์เลี้ยง:</label>
                            <div class="radio-group">
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศผู้" required>
                                    <span>เพศผู้</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศเมีย">
                                    <span>เพศเมีย</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="ไม่ทราบ">
                                    <span>ไม่ทราบ</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pet_age">อายุ:</label>
                            <input type="text" id="pet_age" name="pet_age" placeholder="ระบุเป็นปี/เดือน" maxlength="50" required>
                        </div>

                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">ลงทะเบียน</button>
                        <button type="reset" class="btn btn-secondary">ยกเลิก</button>
                    </div>

                    <div class="form-footer">
                        <a href="listpets" class="link-pets">แสดงรายชื่อสัตว์เลี้ยงของคุณ</a>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>