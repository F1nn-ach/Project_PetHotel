
function isValidated(frm) {
	var reguxEmail = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
	if (!reguxEmail.test(frm.email.value.trim())) {
		document.getElementById('err_email').innerHTML = "*อีเมลไม่ถูกต้องกรุณากรอกใหม่อีกครั้ง";
		frm.email.focus();
		return false;
	} else {
		document.getElementById('err_email').innerHTML = " ";
	}
}