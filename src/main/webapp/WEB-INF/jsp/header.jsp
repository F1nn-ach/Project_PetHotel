<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pet Harmony</title>

<link
	href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&family=Playfair+Display:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/style_header.css?v=1.0">

<script>
	function toggleDropdown() {
		var dropdown = document.querySelector(".dropdown-menu");
		dropdown.classList.toggle("show");
	}
</script>
</head>

<body>
	<header>
		<div class="glass-morphism"></div>
		<div class="header-container">
			<div class="brand">
				<a href="/Project_PetHotel/" class="logo-link">
					<div class="logo-container">
						<img src="assets/icon/logo.png" alt="Pet Harmony Logo">
						<div class="logo-glow"></div>
					</div>
					<h1>Pet Harmony</h1>
				</a>
			</div>

			<nav class="nav-container">
				<ul class="main-nav">
					<li><a href="/Project_PetHotel/" class="nav-link"> <span
							class="nav-text">Home</span> <span class="nav-indicator"></span>
					</a></li>
					<li><a href="#service" class="nav-link"> <span
							class="nav-text">Service</span> <span class="nav-indicator"></span>
					</a></li>
					<li><a href="#about" class="nav-link"> <span
							class="nav-text">About</span> <span class="nav-indicator"></span>
					</a></li>
					<li><a href="contact" class="nav-link"> <span
							class="nav-text">Contact</span> <span class="nav-indicator"></span>
					</a></li>
				</ul>

				<div class="user-nav">
					<c:choose>
						<c:when test="${!user.isAdmin() && not empty user}">
							<div class="user-menu">
								<a class="btn btn-user" onclick="toggleDropdown()"> <img
									alt="User profile" src="assets/icon/user.png">${user.userFirstname}
								</a>
								<div id="userDropdown" class="dropdown-menu">
									<a href="profile" class="menu-item"> <img
										src="assets/icon/user.png" alt="Profile"> <span>Profile</span>
									</a> <a href="listbookings" class="menu-item"> <img
										src="assets/icon/appointment.png" alt="appointment"> <span>Booking</span>
									</a> <a href="listpets" class="menu-item"> <img
										src="assets/icon/paws.png" alt="paws"> <span>Pets</span>
									</a> <a href="logout" class="menu-item"
										onclick="return confirm('Do you want to logout?')"> <img
										src="assets/icon/power-on.png" alt="Logout"> <span>Logout</span>
									</a>
								</div>
							</div>
						</c:when>
						<c:when test="${user.isAdmin() && not empty user}">
							<div class="admin-menu">
								<a class="btn btn-user" onclick="toggleDropdown()"> <img
									alt="User profile" src="assets/icon/profile.png">Admin
								</a>
								<div id="userDropdown" class="dropdown-menu">
									<a href="adminDashboard" class="menu-item"> <img
										src="assets/icon/settings.png" alt="Dashboard"> <span>Dashboard</span>
									</a> <a href="logout" class="menu-item"
										onclick="return confirm('Do you want to logout?')"> <img
										src="assets/icon/power-on.png" alt="Logout"> <span>Logout</span>
									</a>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="auth-buttons">
								<a href="login" class="btn btn-login"> <img
									src="assets/icon/enter.png" alt="Login"> <span>Login</span>
								</a> <a href="register" class="btn btn-signup"> <img
									src="assets/icon/add-user.png" alt="Sign up"> <span>Sign-up</span>
								</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</nav>
		</div>
	</header>
</body>
</html>