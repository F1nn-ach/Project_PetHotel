<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>การลงทะเบียนสัตว์เลี้ยง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
    <script src="assets/scripts.js"></script>
    <style>
        .hidden {
            display: none;
        }
    </style>
    <script src="assets/scripts.js"></script>
</head>
<body>
	<div class="container">
	    <h1>ลงทะเบียนสัตว์เลี้ยง</h1>
	    <small style="color: red;">${err_msg}</small>
	    <form id="pet_frm" action="pet_register" method="post">
	       <div class="pet-entry">
			    <h2>ข้อมูลสัตว์เลี้ยง</h2>
			    <div>
			        <label for="pet_name">ชื่อสัตว์เลี้ยง:</label>
			        <input type="text" name="pet_name" maxlength="50" required>
			    </div>
			    
			    <div>
			        <label>ประเภทสัตว์เลี้ยง:</label>
			        <div>
			            <label>
			                <input type="radio" name="pet_type" value="common" onchange="togglePetType()" required> Common Pet
			            </label>
			            <label>
			                <input type="radio" name="pet_type" value="exotic" onchange="togglePetType()"> Exotic Pet
			            </label>
			        </div>
			    </div>
			
			    <div id="commonPets" class="hidden">
			        <label>สายพันธุ์สัตว์เลี้ยง (Common):</label>
			        <div>
			            <label>
			                <input type="radio" name="breed" value="หมา"> หมา
			            </label>
			            <label>
			                <input type="radio" name="breed" value="แมว"> แมว
			            </label>
			        </div>
			    </div>
			
			    <div id="exoticPets" class="hidden">
			        <label>สายพันธุ์สัตว์เลี้ยง (Exotic):</label>
			        <div>
			            <label>
			                <input type="radio" name="breed" value="กิ้งก่า"> กิ้งก่า
			            </label>
			            <label>
			                <input type="radio" name="breed" value="กบ"> กบ
			            </label>
			            <label>
			                <input type="radio" name="breed" value="เต่า"> เต่า
			            </label>
			            <label>
			                <input type="radio" name="breed" value="งู"> งู
			            </label>
			        </div>
			    </div>
			
			    <div id="breedInput" class="hidden">
			        <label for="breed">กรุณากรอกสายพันธุ์ (Common):</label>
			        <input type="text" name="common_species" maxlength="50">
			    </div>
			
				<div id="exotic_breed_input" class="hidden">
				   <label for="exotic_breed_detail">กรุณากรอกสายพันธุ์ (Exotic):</label>
				   <input type="text" name="exotic_species" maxlength="50">
				</div>
			    
				<div>
			        <label>เพศสัตว์เลี้ยง:</label>
			        <div>
			            <label>
			                <input type="radio" name="pet_gender" value="เพศผู้" required> เพศผู้
			            </label>
			            <label>
			                <input type="radio" name="pet_gender" value="เพศเมีย"> เพศเมีย
			            </label>
			            <label>
			                <input type="radio" name="pet_gender" value="ไม่ทราบ"> ไม่ทราบ
			            </label>
			        </div>
			    </div>
			    
			    <div>
			        <label for="pet_ageyear">อายุปี:</label>
			        <input type="number" name="pet_ageyear" min="0" required>		
			    </div>
			
			    <div>            
			        <label for="pet_agemonth">อายุเดือน:</label>
			        <input type="number" name="pet_agemonth" min="0" max="11" required>
			    </div>
			    
			 	<div>
			 		<label for="weight">น้ำหนักสัตว์เลี้ยง (กิโลกรัม):</label>
        			<input type="number" id="weight" name="pet_weight" step="0.1" placeholder="กรอกน้ำหนัก" required>
        			
        			<input type="checkbox" id="notKnown" name="notKnown" value="unknown" onclick="toggleWeightInput()">
        			<label for="notKnown">ไม่ทราบได้</label>
			 	</div>
			
			    <div>
			        <label for="pet_request">คำร้องขอเพิ่มเติม:</label>
			        <textarea name="pet_request" maxlength="200"></textarea>
			    </div>
			</div>
			
			<div>
				<button type="submit">ลงทะเบียน</button>&nbsp;<button type="reset">ยกเลิก</button>
			</div>
			<a href="listpets">แสดงรายชื่อสัตว์เลี้ยงของคุณ</a>  
	    </form>	
	</div>

</body>
</html>