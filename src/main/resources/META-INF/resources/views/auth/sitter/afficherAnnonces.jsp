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

		<div id="banderole" class="col-2">

			<br />
			<h4 style="font-size: 23; color: white">Menu</h4>
			<br /> <a href="${ctx}/sitter/afficherAnnonces">Consulter toutes
				les annonces</a><br /> <br /> <a
				href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les
				annonces auxquelles j'ai postulé</a> <br /> <br /> <a
				href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de
				vos petSitting</a><br /> <br /> <a href="${ctx}/deconnexion">Me
				déconnecter</a> <br /> <br />
		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Pet-sitter > Consulter les annonces disponibles</h2>
			</p>

			<p>
			<h3>Consulter les annonces disponibles</h3>
			</p>

			Voici la liste des annonces des propriétaires : <br /> <br />

			<table class="table" style="text-align: center;">
				<tr>
					<th style="text-align:center">Titre</th>
					<th style="text-align:center">Message</th>
					<th colspan="7" style="text-align:center">Services</th>

					<th style="text-align:center">Note du propriétaire</th>
					<td></td>

				</tr>
				<tr>
					<th></th>
					<th></th>
						<td><em>Garde propriétaire</em></td>
						<td><em>Garde sitter</em></td>
						<td><em>Soins médicaux</em></td>
						<td><em>Ballade</em></td>
						<td><em>Massage</em></td>
						<td><em>Toilettage</em></td>
						<td><em>Alimentation</em></td>
						<th></th>
				</tr>
				<c:forEach items="${annonces}" var="a" varStatus="cpt">
					<tr>
						<td>${a.titre}</td>
						<td>${a.message}</td>
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 1}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
 						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 2}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 3}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 4}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 5}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 6}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>
						
						<td>
							<c:set var="contains" value="false" />
							<c:forEach var="as" items="${a.annonce_service}">
							  <c:if test="${as.key.service.numSer eq 7}">
							  
							    <c:set var="contains" value="true" />
							    
							  </c:if>
							</c:forEach>
							<c:if test="${contains eq true}">X</c:if>
						</td>

						<td><c:if test="${moyenneP[cpt.index] != 'null'}">
								${moyenneP[cpt.index]}
							</c:if></td>
						<td><a href="${ctx}/sitter/postuler?numA=${a.numA}"
							class="btn btn-info">Postuler</a></td>
					</tr>
				</c:forEach>


			</table>
			<br /> <br />
			<p>
				<a href="${ctx}/auth/menu" class="btn btn-info">Retour au menu</a>
			</p>
		</div>
	</div>
	<br />
	<br />
	<br />
</body>
</html>