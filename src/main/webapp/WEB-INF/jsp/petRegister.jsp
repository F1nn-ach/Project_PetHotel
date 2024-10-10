<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>การลงทะเบียนสัตว์เลี้ยง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
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
	            <label>ประเถทสัตว์เลี้ยง:</label>
	            <select name="breed">
	                <option value="หมา">หมา</option>
	                <option value="แมว">แมว</option>
					<option value="กิ้งก่า">กิ้งก่า</option>
	                <option value="กบ">กบ</option>
	                <option value="เต่า">เต่า</option>
	                <option value="งู">งู</option>
	            </select>
	        </div>
	        
	        <div>
	        	<label>สายพันธุ์สัตว์เลี้ยง:</label>
	        	<input type="text" name="species" maxlength="100" required>
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
	            <input type="text" name="pet_age" placeholder="ระบุเป็นปี/เดือน" maxlength="50" required>
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