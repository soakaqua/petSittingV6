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
			<a href="accueil"> <img height="135" width="130"
				src="${pageContext.request.contextPath}/logo.jpg" />
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



		<c:choose>
			<c:when test="${compte.getClass().simpleName == 'Admin'}">
				<p>Admin</p>
			</c:when>





			<c:when test="${compte.getClass().simpleName == 'Proprio'}">
				<div id="corps" class="row">

					<div id="banderole" class="col-2">
						<br />
						<h4 style="font-size: 23; color: white">Menu</h4>
										<c:url var="action" value="/personne/saveEleve"></c:url>
						
						<br /> <a  href="${ctx}/proprio/consulterAnnonces?numC=${sessionScope.numC}"> Consulter mes annonces</a> <br />
						<br /> <a href="${ctx}/proprio/modifierAnnonce?numC=${sessionScope.numC}">Modifier une annonce</a> <br /> <br />
						<a href="${ctx}/proprio/publierAnnonce?numC=${sessionScope.numC}">Publier une annonce</a> <br /> <br /> <a
							href="proprio?id=4">Valider un sitter</a> <br /> <br /> <a
							href="proprio?id=5">Noter un sitter</a> <br /> <br /> <a
							href="accueil">Me déconnecter</a> <br />



					</div>

					<div id="textePrincipal" class="col-8">

						<p>
						<h2>Propriétaire</h2>
						</p>
						<p>
							Bon retour parmi nous. Que souhaitez-vous faire ? <br /> <br />
						<ul>
							<li><a href="${ctx}/proprio/consulterAnnonces?numC=${sessionScope.numC}"> Consulter mes annonces</a></li>
							<br />
							<li><a href="${ctx}/proprio/modifierAnnonce?numC=${sessionScope.numC}">Modifier une annonce</a></li>
							<br />
							<li><a href="${ctx}/proprio/publierAnnonce?numC=${sessionScope.numC}">Publier une annonce</a></li>
							<br />
							<li><a href="proprio?id=4">Valider un pet-sitter sur une
									annonce</a></li>
							<br />
							<li><a href="proprio?id=5">Noter un pet-sitter sur un
									petsitting réalisé</a></li>
							<br />
							<li><a href="accueil">Me déconnecter</a></li>
							<br />
						</ul>
					</div>
			</c:when>



			<c:when test="${compte.getClass().simpleName == 'Sitter'}">

				<div id="corps" class="row">

					<div id="banderole" class="col-2">
						<br />
						<h4 style="font-size: 23; color: white">Menu</h4>
						<li><a href="${ctx}/sitter/afficherAnnoncesBySitter?numC=${sessionScope.numC}">Consulter les annonces
								auxquelles j'ai postulé</a></li> <br />
						<li><a href="sitter?id=2">Consulter toutes les annonces</a></li> <br />
						<li><a href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler à une annonce</a></li> <br />
						<li><a href="sitter?id=4">Noter un propriétaire sur un
								petsitting réalisé</a></li> <br />
						<li><a href="accueil">Me déconnecter</a></li> <br /> <br />

					</div>

					<div id="textePrincipal" class="col-8">

						<p>
						<h2>Pet-sitter</h2>
						</p>

						Bon retour parmi nous. Que souhaitez-vous faire ? <br /> <br />
						<ul>
							<li><a href="${ctx}/sitter/afficherAnnoncesBySitter?numC=${sessionScope.numC}">Consulter les annonces
									auxquelles j'ai postulé</a></li>
							<br />
							<li><a href="sitter?id=2">Consulter toutes les annonces</a></li>
							<br />
							<li><a href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler à une annonce</a></li>
							<br />
							<li><a href="sitter?id=4">Noter un propriétaire sur un
									petsitting réalisé</a></li>
							<br />
							<li><a href="accueil">Me déconnecter</a></li>
							<br />
							<br />
						</ul>



					</div>
			</c:when>

		</c:choose>
</body>
</html>



