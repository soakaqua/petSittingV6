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



<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div id="footer">PETSITTING 2020 AJC Ingénierie - SOPRA</div>

	<div id="entete" class="row">

					<div id="banderole" class="col-2">
						<br/>
						<h4 style="font-size:23;color:white">Menu</h4>
						<br/>

						<a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces auxquelles j'ai postulé</a> <br /><br />
						<a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a><br /><br />
						<a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a><br /><br />
						<a href="${ctx}/deconnexion">Me déconnecter</a>
						<br /> <br />
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
				href="${ctx}/sitter/afficherAnnoncesBySitter">
				Consulter mes annonces</a> <br /> <br /> <a
				href="Sitter toutesAnnonces.html">Consulter toutes les annonces
			</a> <br /> <br /> <a
				href="${ctx}/sitter/postulerAnnonce?numC=${sessionScope.numC}">Postuler
				à une annonce</a> <br /> <br /> <a href="Sitter noterP.html">Noter
				un propriétaire</a> <br /> <br /> <a href="Main page.html">Accueil</a>
			<br /> <br /> <a href="#deco">Me déconnecter </a> <br /> <br />


		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Pet-sitter > Consulter l'historique de mes annonces</h2>
			</p>

			<p>
			<h3>Consulter l'historique de mes annonces</h3>
			</p>

			Voici la liste des annonce de petsittings que vous avez réalisées : <br /> <br />

			<table class="table" style="text-align: center;">
				<tr>
					<th>Titre</th>
					<th>Message</th>
					<th>Votre réponse</th>
					<th>Noter le Propriétaire</th>
					
				</tr>
					<th></th>
					<th></th>
					<th></th>
					<td>sur votre échange</td>
				<tr>
				
				</tr>
				<c:forEach items="${annonces}" var="annonce" varStatus="cpt">
					<tr>
						<td>${annonce.titre}</td>
						<td>${annonce.message}</td>
						<td>${reponse[cpt.index].message}</td>
						
						<c:choose>
							<c:when test ="${annonce.noteP == null}">
								<form action= "${ctx}/sitter/noterAnnonce" method="post" id="form${cpt.index}">									
									<td> 
									<!-- emplacement select -->
										<input type="text" id="numA" name="numA" hidden="true" value="${annonce.numA}">
										<select required="true" name="noteP" id="noteP" class="mdb-select md-form">
										  <option value="" selected>0 mauvais - 5 excellent</option>																
										  <option value="0">0</option>										
										  <option value="1">1</option>
										  <option value="2">2</option>
										  <option value="3">3</option>
										  <option value="4">4</option>
										  <option value="5">5</option>
										</select>
									</td>
									<td>
										<button type="submit" form="form${cpt.index}" value="Submit" class="btn btn-primary">Noter</button>
									</td>
								</form>
							</c:when>
							<c:when test ="${annonce.noteP != null}">
								<td>
								${annonce.noteP}
								</td>
							</c:when>
						
						</c:choose>
						
					</tr>
				</c:forEach>
		
		</table>
		<br/><br/>
		<p><a href="${ctx}/auth/menu"
							class="btn btn-info">Retour au menu</a>
		</p>
		<br/><br/>	<br/>				
</body>

</html>