<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>หน้าการจองของคุณ</title>
</head>
<body>
<body>
    <div class="container">
        <div>
            <div>
                <h2>การจองสำเร็จ!</h2>
            </div>
            <div>
                <h3>รายละเอียดการจอง</h3>  
                <div>
                	รหัสการจอง ${booking.id}
                </div>
                <div>
                	คุณ ${user.firstname}&nbsp;${user.lastname}
                </div>
                <div>
                    ชื่อสัตว์เลี้ยง:${pet.name}
                </div>
                
                <div>
                    ประเภทสัตว์เลี้ยง:${pet.type}
                </div>
                
                <div>
                
                    วันที่เริ่มต้น:<fmt:formatDate value="${booking.startDate.time}" pattern="dd MMMM yyyy"/> 
                    เวลา: <fmt:formatDate value="${booking.startDate.time}" pattern="HH.mm"/> น.
                </div>
                
                <div>
                    วันที่สิ้นสุด:<fmt:formatDate value="${booking.endDate.time}" pattern="dd MMMM yyyy"/>
                    เวลา: <fmt:formatDate value="${booking.endDate.time}" pattern="HH.mm"/> น.
                </div>
                
                <div>
                    คำร้องขอเพิ่มเติม:${booking.request}
                </div>
                
                <div>
                    <strong>หมายเหตุ:</strong> กรุณาเก็บหน้านี้ไว้เป็นหลักฐานการจอง หากมีข้อสงสัยกรุณาติดต่อเจ้าหน้าที่
                </div>
            </div>
            <div>
                <a href="backtohome">กลับสู่หน้าหลัก</a>
            </div>
        </div>
    </div>
</body>
</html>