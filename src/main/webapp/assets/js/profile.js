function isValidated(frm) {
	if (frm.firstname.value.trim() === "") {
		document.getElementById('err_firstname').innerHTML = "กรุณากรอกชื่อจริงของคุณ";
		frm.firstname.focus();
		return false;
	} else {
		document.getElementById('err_firstname').innerHTML = " ";
	}
	
	if (frm.lastname.value.trim() === "") {
		document.getElementById('err_lastname').innerHTML = "กรุณากรอกนามสกุลของคุณ";
		frm.lastname.focus();
		return false;
	} else {
		document.getElementById('err_lastname').innerHTML = " ";
	}
	
	var reguxTel = /^(0[689]{1})+([0-9]{8})+$/;
	if(frm.phone.value === "") {
	    document.getElementById('err_phone').innerHTML = "กรุณากรอกเบอร์โทรศัพท์ของคุณ";
	    frm.phone.focus();
	    return false;
	} else if(!reguxTel.test(frm.phone.value)) {
	    document.getElementById('err_phone').innerHTML = "เบอร์โทรศัพท์ไม่ถูกต้องกรุณาลองใหม่อีกครั้ง";
	    frm.phone.focus();
	    return false;
	}	else {
			document.getElementById('err_phone').innerHTML = " ";
	}
}