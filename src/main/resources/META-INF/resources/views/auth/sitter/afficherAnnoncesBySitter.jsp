<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<link rel="icon" type="image/png" href="${ctx}/image/logo.jpg" />


<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="footer">PETSITTING 2020 AJC Ingénierie - SOPRA</div>

	<div id="entete" class="row">

		<div id="logoEntete" class="col-2">
			<img height="135" width="130" src="logo.jpg" />
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
			<br /> <a
				href="${ctx}/sitter/afficherAnnoncesBySitter?numC=${sessionScope.numC}">
				Consulter mes annonces</a> <br /> <br /> <a
				href="Sitter toutesAnnonces.html">Consulter toutes les annonces
			</a> <br /> <br /> <a
				href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler
				à une annonce</a> <br /> <br /> <a href="Sitter noterP.html">Noter
				un propriétaire</a> <br /> <br /> <a href="Main page.html">Accueil</a>
			<br /> <br /> <a href="#deco">Me deconnecter </a> <br /> <br />


		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Pet-sitter > Consulter mes annonces</h2>
			</p>

			<p>
			<h3>Consulter mes annonces</h3>
			</p>

			Voici la liste des annonces auxquelles vous avez postulé : <br /> <br />

			<table class="table">
				<tr>
					<th>titre</th>
					<th>message</th>
					<th>Votre réponse</th>
				</tr>
				<c:forEach items="${annonces}" var="a" varStatus="cpt">
					<tr>
						<td>${a.titre}</td>
						<td>${a.message}</td>
						<td>${reponse[cpt.index].message}</td>
						<td><a
							href="${ctx}/sitter/editReponse?numC=${reponse[cpt.index].key.sitter.numC}&numA=${reponse[cpt.index].key.annonce.numA}"
							class="btn btn-info">editer</a></td>
						<td><a
							href="${ctx}/sitter/delete?numC=${reponse[cpt.index].key.sitter.numC}&numA=${reponse[cpt.index].key.annonce.numA}"
							class="btn btn-warning">supprimer</a></td>
					</tr>
				</c:forEach>
		</div>
</body>
</html>