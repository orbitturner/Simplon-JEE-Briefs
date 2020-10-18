<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="services.UrlHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- /* === 🌌 WELCOME TO ORBIT WP REMIX 🌌  === -->
	<!-- *                      -->
	<!-- *	  By : -->
	<!-- * -->
	<!-- *     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗  -->
	<!-- *    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗ -->
	<!-- *    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝ -->
	<!-- *    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗ -->
	<!-- *    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║ -->
	<!-- *     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ -->
	<!-- *           -->
	<!-- *  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal -->
	<!-- *                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/  -->
	<!-- */ -->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>LOGIN | WELCOME TO SEN-FORAGE •&nbsp;</title>
	<link rel="icon" href=<c:out value="${UrlHelper.getImgRepos()}favicon.ico"/> />
	<link rel="stylesheet" href="${UrlHelper.getLoginRepos() }style.css">
</head>
<body onload="titleMarquee()">
	<%-- 
			// 	DEFINES THE DEFAULT HOME CONTROLLER 
			String defaultController = "http://localhost:8080/SenForage_JSP_Servlet_1/home";
			response.sendRedirect(defaultController); 
		--%>
	<div class="scroll-down">
		WELCOME TO SEN FORAGE<br/>
		DÉFILER VERS LE BAS
		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32">
		    <path d="M16 3C8.832031 3 3 8.832031 3 16s5.832031 13 13 13 13-5.832031 13-13S23.167969 3 16 3zm0 2c6.085938 0 11 4.914063 11 11 0 6.085938-4.914062 11-11 11-6.085937 0-11-4.914062-11-11C5 9.914063 9.914063 5 16 5zm-1 4v10.28125l-4-4-1.40625 1.4375L16 23.125l6.40625-6.40625L21 15.28125l-4 4V9z" /> 
		  </svg>
	</div>
	<div class="container"></div>
	<div class="modal">
		<div class="modal-container">
			<div class="modal-left">
				<h1 class="modal-title">Bienvenue à Sen Forage!</h1>
				<p class="modal-desc">Content de vous voir 🤗! Identifiez-vous
					pour accéder au système.</p>
				<form action="home" method="post">
					<div class="input-block">
						<label for="email" class="input-label">Votre Email</label> <input
							type="email" name="email" id="email" placeholder="Email">
					</div>
					<div class="input-block">
						<label for="password" class="input-label">Votre Password</label> <input
							type="password" name="password" id="password"
							placeholder="Password">
					</div>
					<div class="modal-buttons">
						<a href="" class="">Mot de Passe Oublié ?</a>
						<button class="input-button">Login</button>
					</div>
				</form>
				<p class="sign-up">
					Vous n'êtes pas un(e) Employé(e)? <a
						href="https://orbitturner.com/" target="_blank">Voir notre
						Site🡕</a>
				</p>
			</div>
			<div class="modal-right">
				<img src="${UrlHelper.getLoginRepos() }img/water.svg" alt="">
			</div>
			<button class="icon-button close-button">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50">
      			<path d="M 25 3 C 12.86158 3 3 12.86158 3 25 C 3 37.13842 12.86158 47 25 47 C 37.13842 47 47 37.13842 47 25 C 47 12.86158 37.13842 3 25 3 z M 25 5 C 36.05754 5 45 13.94246 45 25 C 45 36.05754 36.05754 45 25 45 C 13.94246 45 5 36.05754 5 25 C 5 13.94246 13.94246 5 25 5 z M 16.990234 15.990234 A 1.0001 1.0001 0 0 0 16.292969 17.707031 L 23.585938 25 L 16.292969 32.292969 A 1.0001 1.0001 0 1 0 17.707031 33.707031 L 25 26.414062 L 32.292969 33.707031 A 1.0001 1.0001 0 1 0 33.707031 32.292969 L 26.414062 25 L 33.707031 17.707031 A 1.0001 1.0001 0 0 0 32.980469 15.990234 A 1.0001 1.0001 0 0 0 32.292969 16.292969 L 25 23.585938 L 17.707031 16.292969 A 1.0001 1.0001 0 0 0 16.990234 15.990234 z"></path></svg>
			</button>
		</div>
		<button class="modal-button">Cliquez ici pour vous identifier</button>
	</div>

	<script src="${UrlHelper.getLoginRepos() }custom.js"></script>
	<script type="text/javascript">
		var titleText = document.title;

		function titleMarquee() {

			titleText = titleText.substring(1, titleText.length)
					+ titleText.substring(0, 1);
			document.title = titleText;
			setTimeout("titleMarquee()", 450);
		}
	</script>
</body>
</html>