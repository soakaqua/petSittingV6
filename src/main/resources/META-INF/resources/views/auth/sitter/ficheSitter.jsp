<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- bootstrap -->
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<!-- lien bootstrap js local -->
<script rel="stylesheet" src="${ctx}/bootstrap/js/bootstrap.min.js"></script>

<!-- CSS -->
  <link rel="stylesheet" type="text/css"
	href="${ctx}/style/CSSpetsitting.css">


<title>PetSitting</title>
<h1>Bienvenue sur PetSitting</h1>
</head>
<body>

	<div id="footer">PETSITTING 2020 AJC Ingénierie - SOPRA</div>

	<div id="entete" class="row">

		<div id="logoEntete" class="col-2">
			<img height="135" width="130" src="logo.jpg" />
		</div>

		<div id="titreEntete" class="col-10">
			<p>
			
			<h1>Profil du Sitter</h1>
			</p>

			
		</div>
	<div id="corps" class="row">

		<div id="banderole" class="col-2">
			<br />
			<h4 style="font-size: 23; color: white">Menu</h4>
			<br /> <a href="Sitter consulterAnnoncesS.html"> Consulter mes
				annonces</a> <br />
			<br /> <a href="Sitter toutesAnnonces.html">Consulter toutes les
				annonces </a> <br />
			<br /> <a href="Sitter postulerAnnonce.html">Postuler à une
				annonce</a> <br />
			<br /> <a href="Sitter noterP.html">Noter un propriétaire</a> <br />
			<br /> <a href="Main page.html">Accueil</a> <br />
			<br /> <a href="#deco">Me deconnecter </a> <br />
			<br />


		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h1> Marine Cattier ></h1> 
			</p>

			<p>
			<h3>Consulter toutes les annonces</h3>
			</p>
	
</body>
</html>