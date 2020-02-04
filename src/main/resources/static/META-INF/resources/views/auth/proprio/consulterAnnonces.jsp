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
<body class="container">

<div id="footer">
	PETSITTING 2020 AJC Ingénierie - SOPRA
</div>
	
<div id="entete" class="row">

	<div id="logoEntete" class="col-2">
		<a href="Main page.html"> <img height="135" width="130" src="logo.jpg"/> </a> <br/><br/>
	</div>
	
	<div id="titreEntete" class="col-10">
	<p> <h1> Bienvenue sur PetSitting </h1> </p>
	
	<p style="font:bold;font-size:20;text-align:right;margin-right:5px"> Le site de référence pour faire garder vos animaux </p>
	</div>
	
</div> 


<div id="corps" class="row">
	
	<div id="banderole" class="col-2">
	<br/>
	<h4 style="font-size:23;color:white">Menu</h4>
	<br/>
	<a href="proprio/consulterAnnonces">Consulter mes annonces</a> <br/><br/>
	<!--
	<a href="proprio/modifierAnnonce">Modifier une annoncee</a> <br/><br/>
	-->
	<a href="proprio/publierAnnonce">Publier une annonce</a> <br/><br/>
	<a href="proprio/validerSitter">Valider un sitter</a> <br/><br/>
	<a href="proprio/noterS">Noter un sitter</a> <br/><br/>	
	<a href="accueil">Accueil</a> <br/><br/>
	<a href="#deco">Me deconnecter </a> <br/><br/>
</div> 
	
<div id="textePrincipal" class="col-8">

<p> <h2> Propriétaire > Consulter mes annonces </h2> </p> 

<p> <h3> Consulter mes annonces </h3> </p> 

	Voici les annonces que vous avez publiées : <br/><br/>

<c:choose>
	
	<c:when test="${annonces.isEmpty()}">
		<div>
			<br/>
			<em>Vous n'avez aucune annonce en cours</em>
		</div>
	</c:when>

	<c:otherwise>
		<div>	
			<table class="table">
				<tr>
					<th>Titre</th>
					<th>Message</th>
	
					<th>Statut</th>
				</tr>
				
				<c:forEach items ="${annonces}" var="a">
					<tr>
						<!-- COLONNES -->
						<td>${a.titre}</td>
						<td>${a.message}</td>
	
						<td>${a.statut}</td>	
						
						<!-- BOUTONS -->				
						<td><a href="${ctx}/proprio/saveModif?numA=${a.numA}&numC=${numC}" class="btn btn-primary">Modifier</a></td>
						<td><a href="${ctx}/proprio/delete?numA=${a.numA}&numC=${numC}" class="btn btn-danger">Supprimer</a></td>									
					</tr>
					
				</c:forEach>
			</table>
	<!-- http://localhost:8080/petSitting_FrontV4/proprio/consulterAnnonces?numC=101 -->	
		</div>
	</c:otherwise>	
	
</c:choose>
	
</div>

</body>
</html>
