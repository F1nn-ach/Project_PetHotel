function confirmPassword(event) {
	var pwd = document.getElementById("password").value;
	var confirmPassword = document.getElementById("confirm_password").value;
	var msg = document.getElementById("pwd_msg");

	if (pwd === confirmPassword) {
		msg.style.color = "green";
		msg.innerHTML = "รหัสผ่านตรงกัน";
	} else {
		msg.style.color = "red";
		msg.innerHTML = "รหัสผ่านไม่ตรงกัน";
		event.preventDefault();
	}
}