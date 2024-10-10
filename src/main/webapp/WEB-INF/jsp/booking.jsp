<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>การจอง - เว็บไซต์รับฝากสัตว์เลี้ยง</title>
</head>
<body>
	<div class="container">
	    <h2>Pet Booking</h2>
	    <form action="" method="post">
	    	<div>
		        <label for="pet">Select Your Pet</label>
		        <select name="pet" id="pet" required>
		            <!-- Example options, should be dynamically populated from database -->
		            <option value="PET001">Bella - Dog</option>
		            <option value="PET002">Max - Cat</option>
		            <option value="PET003">Charlie - Rabbit</option>
		            <option value="PET004">Luna - Dog</option>
		        </select>	    	
	    	</div>
			
			<div>
		        <label for="startDate">Start Date</label>
		        <input type="date" id="startDate" name="startDate" required>		
			</div>
			
			<div>
		        <label for="startTime">Start Time</label>
		        <select id="startTime" name="startTime" required>
		            
		        </select>				
			</div>
	
			<div>
	            <label for="endDate">End Date</label>
	            <input type="date" id="endDate" name="endDate" required>
			</div>

			<div>
		        <label for="endTime">End Time</label>
		        <select id="endTime" name="endTime" required>
		            
		        </select>
			</div>
			<div>
				<button type="submit">ลงทะเบียน</button>&nbsp;<button type="reset">ยกเลิก</button>
			</div>
	    </form>
	</div>	
	
	<script src="assets/booking.js"></script>
</body>
</html>