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

function togglePetType() {
	const petType = document.querySelector('input[name="pet_type"]:checked').value;
	const commonPets = document.getElementById("commonPets");
	const exoticPets = document.getElementById("exoticPets");
	const breedInput = document.getElementById("breedInput");
	const exoticBreedInput = document.getElementById("exotic_breed_input");

	if (petType === "common") {
		commonPets.classList.remove("hidden");
		exoticPets.classList.add("hidden");
		breedInput.classList.remove("hidden");
		exoticBreedInput.classList.add("hidden");
	} else if (petType === "exotic") {
		exoticPets.classList.remove("hidden");
		commonPets.classList.add("hidden");
		breedInput.classList.add("hidden");
		exoticBreedInput.classList.remove("hidden");
	} else {
		commonPets.classList.add("hidden");
		exoticPets.classList.add("hidden");
		breedInput.classList.add("hidden");
		exoticBreedInput.classList.add("hidden");
	}
}

function toggleWeightInput() {
	var weightInput = document.getElementById("weight");
	var notKnownCheckbox = document.getElementById("notKnown");

	if (notKnownCheckbox.checked) {
		weightInput.value = "";
		weightInput.disabled = true;
	} else {
		weightInput.disabled = false;
	}
}