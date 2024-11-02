<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>แก้ไขข้อมูลสัตว์เลี้ยง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style_editpet.css?v=1.1">
    <link href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <script>
        function updateBreeds() {
            const petType = document.getElementById("pet_type").value;
            const breedsSelect = document.getElementById("breed");
            const originalBreed = '${pet.petBreed}'; // Get the original breed

            breedsSelect.innerHTML = '';

            let breeds = [];
            if (petType === "หมา") {
                breeds = ["โกเด้น รีทีฟเวอร์", "พุดเดิ้ล", "ชิวาวา", "บีเกิ้ล", "ดัชชุนด์", "เซนต์เบอร์นาร์ด", "ชเนาเซอร์", "อื่นๆ"];
            } else if (petType === "แมว") {
                breeds = ["เปอร์เซีย", "สฟิงซ์", "ไทย", "เมนคูน", "บริติช ชอร์ตแฮร์", "สก็อตติช โฟลด์", "อเมริกัน ชอร์ตแฮร์", "อื่นๆ"];
            } else if (petType === "นก") {
                breeds = ["ฟินซ์", "คอนัวร์", "นกแก้ว", "นกกระตั้ว", "นกกระเรียน", "นกพิราบ", "นกอีมู", "อื่นๆ"];
            } else if (petType === "กิ้งก่า") {
                breeds = ["กิ้งก่ามังกร", "กิ้งก่าผี", "กิ้งก่าอเมริกัน", "กิ้งก่าเลื้อยคลาน", "อื่นๆ"];
            } else if (petType === "กบ") {
                breeds = ["กบอเมริกัน", "กบป่า", "กบตายาย", "กบลูกกบ", "อื่นๆ"];
            } else if (petType === "เต่า") {
                breeds = ["เต่าบก", "เต่าทะเล", "เต่าหมายเลข", "เต่าบูลส์", "อื่นๆ"];
            } else if (petType === "งู") {
                breeds = ["งูหลาม", "งูพิษ", "งูเห่า", "งูแดง", "อื่นๆ"];
            } else if (petType === "หนู") {
                breeds = ["หนูบ้าน", "หนูแฮมสเตอร์", "หนูไจแอนท์", "หนูตะเภา", "อื่นๆ"];
            } 

            // Add options to select
            breeds.forEach(breed => {
                const option = document.createElement("option");
                option.value = breed;
                option.text = breed;
                breedsSelect.add(option);
            });

            // Check if the original breed is in the list
            const breedExists = breeds.includes(originalBreed);
            
            // If original breed is not in the list, select "อื่นๆ" and show custom input
            if (!breedExists) {
                breedsSelect.value = "อื่นๆ";
            } else {
                breedsSelect.value = originalBreed;
            }

            checkCustomBreedInput();
        }

        function checkCustomBreedInput() {
            const breedsSelect = document.getElementById("breed");
            const customBreedInput = document.getElementById("custom_breed_input");
            const customBreedField = document.getElementById("custom_breed");
            const originalBreed = '${pet.petBreed}';

            if (breedsSelect.value === "อื่นๆ") {
                customBreedInput.style.display = "block";
                customBreedField.required = true;
                // Set the custom breed value if original breed wasn't in the standard list
                if (!breedsSelect.querySelector(`option[value="${originalBreed}"]`)) {
                    customBreedField.value = originalBreed;
                }
            } else {
                customBreedInput.style.display = "none";
                customBreedField.required = false;
                customBreedField.value = "";
            }
        }

        window.onload = function() {
            updateBreeds();
        }
    </script>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div class="page-container">
        <div class="content-container">
            <div class="content-card">
                <div class="header">
                    <div class="logo">
                        <img src="assets/img/logo.png" alt="Pet Logo">
                        <h1>Pet Harmony</h1>
                    </div>
                </div>

                <small class="error-message">${err_msg}</small>

                <form action="updatepet" method="POST" class="pet-form">
                    <input type="hidden" name="petId" value="${pet.petId}">
                    
                    <div class="form-section">
                        <h2>แก้ไขข้อมูลสัตว์เลี้ยง</h2>

                        <div class="form-group">
                            <label for="pet_name">ชื่อสัตว์เลี้ยง:</label>
                            <input type="text" id="pet_name" name="pet_name" value="${pet.petName}" maxlength="50" required>
                        </div>

                        <div class="form-group">
                            <label for="pet_type">ประเภทสัตว์เลี้ยง:</label>
                            <select id="pet_type" name="pet_type" onchange="updateBreeds()" required>
                                <c:forEach items="${petTypes}" var="type">
                                    <option value="${type.petTypeName}"
                                        ${pet.petType.petTypeName == type.petTypeName ? 'selected' : ''}>
                                        ${type.petTypeName}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="breed">สายพันธุ์สัตว์เลี้ยง:</label>
                            <select id="breed" name="breed" required onchange="checkCustomBreedInput()">
                            </select>
                        </div>

                        <div class="form-group" id="custom_breed_input" style="display: none;">
                            <label for="custom_breed">กรุณากรอกสายพันธุ์สัตว์เลี้ยง:</label>
                            <input type="text" id="custom_breed" name="custom_breed" maxlength="50">
                        </div>

                        <div class="form-group">
                            <label>เพศสัตว์เลี้ยง:</label>
                            <div class="radio-group">
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศผู้"
                                        ${pet.petGender == 'เพศผู้' ? 'checked' : ''} required>
                                    <span>เพศผู้</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="เพศเมีย"
                                        ${pet.petGender == 'เพศเมีย' ? 'checked' : ''}>
                                    <span>เพศเมีย</span>
                                </label>
                                <label class="radio-label">
                                    <input type="radio" name="pet_gender" value="ไม่ทราบ"
                                        ${pet.petGender == 'ไม่ทราบ' ? 'checked' : ''}>
                                    <span>ไม่ทราบ</span>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="pet_age">อายุ:</label>
                            <input type="text" id="pet_age" name="pet_age" value="${pet.petAge}"
                                placeholder="ระบุเป็นปี/เดือน" maxlength="50" required>
                        </div>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary">บันทึกการแก้ไข</button>
                            <a href="listpets" class="btn btn-secondary">ยกเลิก</a>
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