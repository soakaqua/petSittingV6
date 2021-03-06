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

</head>
<body>

	<div id="footer">PETSITTING 2020 AJC Ingénierie - SOPRA</div>

	<div id="entete" class="row">

<div id="logoEntete" class="col-2">
			<a href="${ctx}/accueil"> <img height="135" width="130"
				src="${ctx}/image/logo.jpg" align="left" />
			</a> 
		</div>



		<div id="titreEntete" class="col-10">
			<p>
			<p></p>
			</p>
<p
				style="font: bold; font-size: 20; text-align: center">
				Bienvenue sur PetSitting</p>
				
		</div>

	</div>

	<div id="corps" class="row">

		<div id="banderole" class="col-2">
			<br />
			<h4 style="font-size: 23; color: white; font: bold;">Menu</h4>
						<a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a><br /><br />
						<a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces auxquelles j'ai postulé</a> <br /><br />
						<a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a><br /><br />
						<a href="${ctx}/deconnexion">Me déconnecter</a>


		</div>
			
			<div id="textePrincipal" class="col-8">

			<p>
			<h2>Profil du Pet-sitter </h2>
			
			<br/>
			<h4 style="font-size: 23; color: black; font: bold;">Marine Cattier</h4>
			<br/>
			    <p>Adresse: <em>6 Rue Rougemont, 75009 Paris</em></p>
			    <p> Téléphone : <em>0785078191</em></p>
			    <p> Note : <em>4.6/5</em></p>

              
			<br/>
			<h4>Motivation</h4>
			_______________________________________
			<div>
			<br/>
			<p>Je m'appelle Marine, j'ai 28 ans, passionnée par les animaux j'en ai fait mon métier.</p>
			  <p>Actuellement je suis toiletteuse et petsitter professionnelle pour garder les animaux domestiques et les nouveaux animaux de compagnie.</p> 
			  <p>Responsable et rigoureuse, je suis une personne de confiance et c'est avec plaisir que je prendrais soin de votre compagnon</p>
			   <p>pendant votre absence ce qui vous laissera partir en vacances en toute sérénité</p>
          </div>
			
			
			<br/>
			<h4>Expérience</h4>
			_______________________________________
			<div>
			<br/>
			<p>Ayant 5 ans  d'expérience professionnelle pour garder les animaux et répondre à leurs besoins,</p>
			<p> je vous propose mes services de toilettage, ballade, garde et de soins médicaux.</p> 
			
		</div>
	
<br/><br/><br/>
		
	
</body>
</html>