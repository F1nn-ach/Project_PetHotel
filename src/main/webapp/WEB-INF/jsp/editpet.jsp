<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>แก้ไขข้อมูลสัตว์เลี้ยงของคุณ</title>
    <link rel="stylesheet" type="text/css" href="assets/css/style_edit_pets.css?v=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
    <div class="page-container">
        <div class="content-container">
            <div class="content-card">
                <div class="header">
                    <div class="logo">
                        <img src="assets/img/logo.png" alt="Pet Logo">
                        <h1>แก้ไขข้อมูลสัตว์เลี้ยง</h1>
                    </div>
                </div>

                <small class="error-message">${err_msg}</small>
                <form id="pet_frm" action="editmypet" method="post" class="pet-form">
                    <input type="hidden" name="pet_id" value="${pet.id}">
                    <div class="form-section">
                        <h2>ข้อมูลสัตว์เลี้ยง</h2>

                        <div class="form-group">
                            <label for="pet_name">ชื่อสัตว์เลี้ยง:</label>
                            <input type="text" id="pet_name" name="pet_name" maxlength="50" value="${pet.name}" required>
                        </div>

                        <div class="form-group">
                            <label for="type">ประเภทสัตว์เลี้ยง:</label>
                            <select id="type" name="pet_type">
                                <option value="หมา" ${pet.type == 'หมา' ? 'selected' : ''}>หมา</option>
                                <option value="แมว" ${pet.type == 'แมว' ? 'selected' : ''}>แมว</option>
                                <option value="นก" ${pet.type == 'นก' ? 'selected' : ''}>นก</option>
                                <option value="กิ้งก่า" ${pet.type == 'กิ้งก่า' ? 'selected' : ''}>กิ้งก่า</option>
                                <option value="กบ" ${pet.type == 'กบ' ? 'selected' : ''}>กบ</option>
                                <option value="เต่า" ${pet.type == 'เต่า' ? 'selected' : ''}>เต่า</option>
                                <option value="งู" ${pet.type == 'งู' ? 'selected' : ''}>งู</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="species">สายพันธุ์สัตว์เลี้ยง:</label>
                            <input type="text" id="species" name="species" maxlength="100" value="${pet.species}" required>
                        </div>

                        <div class="form-group">
                            <label>เพศสัตว์เลี้ยง:</label>
                            <div class="radio-group">
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศผู้" ${pet.gender == 'เพศผู้' ? 'checked' : ''} required>
                                    <span>เพศผู้</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศเมีย" ${pet.gender == 'เพศเมีย' ? 'checked' : ''}>
                                    <span>เพศเมีย</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="ไม่ทราบ" ${pet.gender == 'ไม่ทราบ' ? 'checked' : ''}>
                                    <span>ไม่ทราบ</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pet_age">อายุ:</label>
                            <input type="text" id="pet_age" name="pet_age" placeholder="ระบุเป็นปี/เดือน" maxlength="50" value="${pet.age}" required>
                        </div>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">บันทึกการแก้ไข</button>
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
