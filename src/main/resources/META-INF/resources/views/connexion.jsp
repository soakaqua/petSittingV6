<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<!-- bootstrap -->
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<!-- lien bootstrap js local -->
<script rel="stylesheet" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/style/CSSpetsitting.css">

<!-- Image -->
<link rel="icon" type="image/png" href="${ctx}/image/logo.jpg" />


<head>
<title>PetSitting</title>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="footer">PETSITTING 2020 AJC Ingénierie - SOPRA</div>

	<div id="entete" class="row">

		<div id="logoEntete" class="col-2">
			<a href="Main page.html"> <img height="135" width="130"
				src="logo.jpg" />
			</a> <br /> <br />
		</div>

		<div id="titreEntete" class="col-10">
			<p>
			<h1>Bienvenue sur PetSitting</h1>
			</p>
			<p
				style="font: bold; font-size: 20; text-align: right; margin-right: 5px">
				Le site de référence pour faire garder vos animaux</p>
		</div>

	</div>

	<div id="corps" class="row">

		<div id="banderole" class="col-2">
			<br />
			<h4 style="font-size: 23; color: white">Menu</h4>
			<br /> <a href="Main connexion.html">Connexion</a> <br /> <br /> <a
				href="Main inscription.html">Inscription</a> <br /> <br /> <a
				href="Main page.html">Accueil</a> <br /> <br />
		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Connexion</h2>
			</p>

			<form name="connexion" action="connexion" method="post">

				<em><p>
						<label for="mail">Entrez votre mail</label>
					</p></em> <input placeholder="ex: mail@test.com" required id="mail"
					name="mail" type="email" /> <br /> <br /> <em><p>
						<label for="mdp">Entrez votre mot de passe</label>
					</p></em> <input placeholder="**********" required id="mdp" name="mdp"
					type="password" /> <br /> <br /> <input value="Me connecter"
					type="submit" />

			</form>

		</div>



	</div>


</body>
</html>



