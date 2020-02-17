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
	<a href="publierAnnonce">Publier une annonce</a> <br/><br/>
	<a href="validerSitter">Valider un sitter</a> <br/><br/>
	<a href="noterS">Noter un sitter</a> <br/><br/>	
	<a href="accueil">Accueil</a> <br/><br/>
	<a href="#deco">Me deconnecter </a> <br/><br/>
</div> 

<div id="textePrincipal" class="col-8">

<p><h2> Propriétaire > Valider un sitter </h2></p> 

<p><h3> Valider un sitter </h3></p> 

	Vous voulez valider un sitter pour cette annonce. Voici la liste des réponses à votre annonce :
	<br/><br/>
	
<c:choose>
	
	<c:when test="${reponses.isEmpty()}">
		<div>
			<br/>
			<em>Vous n'avez aucune réponse concernant cette annonce</em>
		</div>
	</c:when>

	<c:otherwise>
		<div>
			<table class="table">
				<tr>
					<th>Message</th>
					<th>Page du sitter</th>
				</tr>
				
				<c:forEach items ="${reponses}" var="r">
					<tr>
						<!-- COLONNES -->
						<td>${r.message}</td>
						<td>page du sitter</td>	
						
						<!-- BOUTONS -->				
						<td><a href="${ctx}/proprio/validerSitter?numC=${r.key.sitter.getNumC()}&numA=${r.key.annonce.getNumA()}" class="btn btn-success">Valider</a></td>								
					</tr>
				</c:forEach>
			</table>
			
			<a href="${ctx}/proprio/consulterAnnonces" class="btn btn-warning">Annuler</a>
		</div>	
	</c:otherwise>	
</c:choose>
	
</div>

</body>
</html>
