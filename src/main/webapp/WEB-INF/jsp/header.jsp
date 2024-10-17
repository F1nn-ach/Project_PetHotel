<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pet Harmony</title>
<link
	href="https://fonts.googleapis.com/css2?family=Prompt:wght@300;400;500;600;700&family=Playfair+Display:wght@700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/style_header.css">
<script>
	function toggleDropdown() {
		var dropdown = document.getElementById("userDropdown");
		dropdown.classList.toggle("show");
	}
</script>
</head>
<body>
	<header>
		<div class="glass-morphism"></div>
		<div class="header-container">
			<!-- Logo and Title -->
			<div class="brand">
				<a href="/Project_PetHotel/" class="logo-link">
					<div class="logo-container">
						<img src="assets/img/logo.png" alt="Pet Harmony Logo">
						<div class="logo-glow"></div>
					</div>
					<h1>Pet Harmony</h1>
				</a>
			</div>

			<!-- Navigation -->
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

				<!-- User Navigation -->
				<div class="user-nav">
					<%
					if (session.getAttribute("user") != null) {
					%>
					<div class="user-menu">
						<a class="bnt btn-user" onclick="toggleDropdown()">
							<img alt="User profile" src="assets/img/user.png"> <span>${user.firstname}</span>
						</a>
						
						<div id="userDropdown" class="dropdown-menu">
							<a href="yourprofile" class="menu-item"> <img
								src="assets/img/user.png" alt="Profile"> <span>Profile</span>
							</a> <a href="booking" class="menu-item"> <img
								src="assets/img/appointment.png" alt="appointment"> <span>Booking</span>
							</a> <a href="listpets" class="menu-item"> <img
								src="assets/img/paws.png" alt="paws"> <span>Pets</span>
							</a> <a href="logout" class="menu-item"
								onclick="return confirm('Do you want to logout?')"> <img
								src="assets/img/power-on.png" alt="Logout"> <span>Logout</span>
							</a>
						</div>
					</div>
					<%-- <% } else if (session.getAttribute("user").equals("admin")) { %>
				        	<div class="admin-menu">
				            <a class="bnt btn-admin" onclick="toggleDropdown()">
							<img alt="User profile" src="assets/img/profile.png"> <span>Admin</span>
							</a>
				            <div id="userDropdown" class="dropdown-menu">
				                <a href="adminprofile" class="menu-item">
				                    <img src="assets/img/settings.png" alt="Profile">
				                    <span>Setting</span>
				                </a>
				                <a href="logout" class="menu-item" onclick="return confirm('Do you want to logout?')">
				                    <img src="assets/img/power-on.png" alt="Logout">
				                    <span>Logout</span>
				                </a>
				            </div>
				        </div> --%>
					<%
					} else {
					%>
					<div class="auth-buttons">
						<a href="login" class="btn btn-login"> <img
							src="assets/img/enter.png" alt="Login"> <span>Login</span>
						</a> <a href="register" class="btn btn-signup"> <img
							src="assets/img/add-user.png" alt="Sign up"> <span>Sign-up</span>
						</a>
					</div>
					<%
					}
					%>
				</div>
			</nav>
		</div>
	</header>
</body>
</html>
