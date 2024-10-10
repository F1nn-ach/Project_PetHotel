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

function confirmPassword(event) {
	var password = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirm_pwd").value;
	var message = document.getElementById("pwd_msg");

	if (password !== confirmPassword) {
		message.style.color = "red";
		message.innerHTML = "รหัสผ่านไม่ตรงกัน";
		event.preventDefault();
	} else {
		message.style.color = "green";
		message.innerHTML = "รหัสผ่านตรงกัน";
	}
}