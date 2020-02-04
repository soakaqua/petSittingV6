<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>

<head>

<!-- bootstrap -->
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<!-- lien bootstrap js local -->
<script rel="stylesheet" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>

<!-- CSS -->
  <link rel="stylesheet" type="text/css"
	href="${ctx}/style/CSSpetsitting.css">

<!-- Image -->
<link rel="icon" type="image/png"
	href="${ctx}/image/logo.jpg" /> 
	


<meta charset="UTF-8">
<title>PetSitting</title>
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
			<br /> <a href="connexion">Connexion</a> <br /> <br /> <a
				href="connexion?id=2" >Inscription</a> <br /> <br /> <a
				href="Main page.html">Accueil</a> <br /> <br /> <a
				href="Proprio main.html"> Accès cheat Proprio</a> <br /> <br /> <a
				href="Sitter main.html"> Accès cheat Sitter</a> <br /> <br />
		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Page Principale</h2>
			</p>

			Ce site permet de mettre en lien des pet-sitters compétents avec des
			propriétaires voulant prendre soin de leurs animaux. Nous offrons
			différents services comme des promenades, massages ou soins médicaux
			pour le bien-être de vos animaux. <br /> Nous offrons une
			optmisation du temps de trajet via la selection des annonces par code
			postal. <br /> (carte de la france ?) <br /> <br /> <a
				href="connexion">Connexion</a> <br /> <br /> <a href="toto">Inscription</a>
			<br /> <br /> <br /> <br />

		</div>



	</div>
</body>
</html>



