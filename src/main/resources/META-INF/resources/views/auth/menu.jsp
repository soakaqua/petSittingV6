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



<head>
<title>PetSitting</title>

<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h1>Bienvenue sur PetSitting</h1>
			</p>
			<p
				style="font: bold; font-size: 20; text-align: right; margin-right: 5px">
				Le site de référence pour faire garder vos animaux</p>
		</div>

	</div>

	<div id="corps" class="row">

		<c:choose>
			<c:when test="${sessionScope.typeC == 'admin'}">
				<p>Admin</p>
			</c:when>


			<c:when test="${sessionScope.typeC == 'proprio'}">

					<div id="banderole" class="col-2">
						<br/>
						<h4 style="font-size:23;color:white">Menu</h4>
						<br/>
						<br /> <a  href="${ctx}/proprio/consulterAnnonces?numC=${sessionScope.numC}"> Consulter mes annonces</a> <br />
						<br /> <a href="${ctx}/proprio/modifierAnnonce?numC=${sessionScope.numC}">Modifier une annonce</a> <br /> <br />
						<a href="${ctx}/proprio/publierAnnonce?numC=${sessionScope.numC}">Publier une annonce</a> <br /> <br /> <a
							href="proprio?id=4">Valider un sitter</a> <br /> <br /> <a
							href="proprio?id=5">Noter un sitter</a> <br /> <br /> <a
							href="${ctx}/deconnexion">Me déconnecter</a> <br />


					</div>

					<div id="textePrincipal" class="col-8">

						<p>	<h2>Propriétaire</h2> </p>
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
							<li><a href="${ctx}/deconnexion">Me déconnecter</a></li>
							<br />
						</ul>
					</div>
			</c:when>



			<c:when test="${sessionScope.typeC == 'sitter'}">

					<div id="banderole" class="col-2">
						<br/>
						<h4 style="font-size:23;color:white">Menu</h4>
						<br/>
						<li><a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces
								auxquelles j'ai postulé</a></li> <br />
						<li><a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a></li> <br />
						<li><a href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler à une annonce</a></li> <br />
						<li><a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a></li>

						<li><a href="${ctx}/deconnexion">Me déconnecter</a></li> <br /> <br />

					</div>

					<div id="textePrincipal" class="col-8">

						<p>
						<h2>Pet-sitter</h2>
						</p>

						Bon retour parmi nous. Que souhaitez-vous faire ? <br /> <br />
						<ul>
							<li><a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces
									auxquelles j'ai postulé</a></li>
							<br />
							<li><a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a></li>
							<br />
							<li><a href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler à une annonce</a></li>
							<br />
							<li><a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a></li>
							<br />
							<li><a href="${ctx}/deconnexion">Me déconnecter</a></li>
							<br />
							<br />
						</ul>



					</div>	
			</c:when>

		</c:choose>
</body>
</html>



