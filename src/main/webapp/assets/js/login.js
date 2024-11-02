function isValidated(frm) {
	var lengthEmail = /.{7,}/;
	var reguxEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	if (frm.user_email.value.trim() === "") {
		document.getElementById('err_email').innerHTML = "กรุณากรอกอีเมลของคุณ";
		frm.user_email.focus();
		return false;
	} else if(!lengthEmail.test(frm.user_email.value.trim())) {
		document.getElementById('err_email').innerHTML = "ต้องมีความยาวตั้งแต่ 7 ตัวขึ้นไป";
		frm.user_email.focus();
		return false;
	} else if (!reguxEmail.test(frm.user_email.value.trim())) {
		document.getElementById('err_email').innerHTML = "อีเมลไม่ถูกต้องกรุณากรอกใหม่อีกครั้ง";
		frm.user_email.focus();
		return false;
	} else {
		document.getElementById('err_email').innerHTML = " ";
	}
	
	var lengthPwd = /.{5,}/;
	var reguxPwd = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{5,}$/;
	if(frm.user_password.value === "") {
	    document.getElementById('err_pwd').innerHTML = "กรุณากรอกรหัสผ่านของคุณ";
	    frm.user_password.focus();
	    return false;
	} else if(!lengthPwd.test(frm.user_password.value)) {
		document.getElementById('err_pwd').innerHTML = "ต้องมีความยาวตั้งแต่ 5 ตัวขึ้นไป";
		frm.user_password.focus();
		return false;
	} else if(!reguxPwd.test(frm.user_password.value)) {
	    document.getElementById('err_pwd').innerHTML = "ต้องประกอบด้วยตัวอักษรภาษาอังกฤษพิมพ์เล็ก พิมพ์ใหญ่ และตัวเลข";
	    frm.user_password.focus();
	    return false;
	}	else {
			document.getElementById('err_pwd').innerHTML = " ";
	}
		
}