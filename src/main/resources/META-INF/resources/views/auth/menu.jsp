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
						<a href="${ctx}/proprio/consulterAnnonces?numC=${sessionScope.numC}"> Consulter mes annonces</a> <br /><br />
						<a href="${ctx}/proprio/consulterAnnoncesTerminees?numC=${sessionScope.numC}">Consulter l'historique de mes annonces</a> <br/><br/>
						<a href="${ctx}/proprio/publierAnnonce?numC=${numC}">Publier une annonce</a> <br/><br/> 
						<a href="${ctx}/deconnexion">Me déconnecter</a> <br />
					</div>

					<div id="textePrincipal" class="col-8">

						<p>	<h2>Propriétaire</h2> </p>
						
							Bon retour parmi nous. Que souhaitez-vous faire ? <br /> <br />
						<ul>
							<li><b><a href="${ctx}/proprio/consulterAnnonces?numC=${sessionScope.numC}" style="color:black"> Consulter mes annonces</a></b></li> <br />
							<li><b><a href="${ctx}/proprio/consulterAnnoncesTerminees?numC=${sessionScope.numC}" style="color:black"> Consulter l'historique de mes annonces</a></b> </li><br/>
							<li><b><a href="${ctx}/proprio/publierAnnonce?numC=${sessionScope.numC}" style="color:black">Publier une annonce</a></b></li>	<br />
							<li><b><a href="${ctx}/deconnexion" style="color:black">Me déconnecter</a></b></li> <br />
						</ul>
					</div>
			</c:when>



			<c:when test="${sessionScope.typeC == 'sitter'}">

					<div id="banderole" class="col-2">
						<br/>
						<h4 style="font-size:23;color:white">Menu</h4>
						<br/>
						<a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a><br /><br />
						<a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces auxquelles j'ai postulé</a> <br /><br />
						<a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a><br /><br />
						<a href="${ctx}/deconnexion">Me déconnecter</a>
						<br /> <br />
					</div>

					<div id="textePrincipal" class="col-8">

						<p>	<h2>Pet-sitter</h2>	</p>

						Bon retour parmi nous. Que souhaitez-vous faire ? <br /> <br />
						<ul>
							<li><b><a href="${ctx}/sitter/afficherAnnonces" style="color:black">Consulter toutes les annonces</a></b></li>	<br />							
							<li><b><a href="${ctx}/sitter/afficherAnnoncesBySitter" style="color:black">Consulter les annonces auxquelles j'ai postulé</a></b></li><br />
							<li><b><a href="${ctx}/sitter/historiqueAnnonces" style="color:black">Afficher l'historique de vos petSitting</a></b></li>	<br />
							<li><b><a href="${ctx}/deconnexion" style="color:black">Me déconnecter</a></b></li><br />
							<br />
						</ul>



					</div>	
			</c:when>

		</c:choose>
</body>
</html>



