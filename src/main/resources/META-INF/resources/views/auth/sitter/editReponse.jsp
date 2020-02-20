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
				les annonces</a><br />
			<br /> <a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter
				les annonces auxquelles j'ai postulé</a> <br />
			<br /> <a href="${ctx}/sitter/historiqueAnnonces">Afficher
				l'historique de vos petSitting</a><br />
			<br /> <a href="${ctx}/deconnexion">Me déconnecter</a> <br /> <br />
		</div>

		<div id="textePrincipal" class="col-8">
			<p>
			<h2>Pet-sitter > Consulter mes annonces</h2>
			</p>

			<p>
			<h3>Consulter mes annonces</h3>
			</p>

			Voici la liste des annonces auxquelles vous avez postulé : <br /> <br />
			
<c:choose>
	
	<c:when test="${annonces.isEmpty()}">
			<em>Vous n'avez postulé à aucune annonce</em>
	</c:when>
			
	<c:otherwise>

			<table class="table">
				<tr>
					<th>Titre</th>
					<th>Message</th>
				</tr>
				<tr>
					<td>${annonce.titre}</td>
					<td>${annonce.message}</td>
				</tr>
			</table>
			<p></p>
			<form:form action="${ctx}/sitter/saveReponse" method="get"
				modelAttribute="reponse">
				<form:hidden path="key.sitter.numC" />
				<form:hidden path="key.annonce.numA" />
				<form:hidden path="version" />

				<div class="form-group">


					<form:label path="message">Votre réponse : </form:label>
					<form:input path="message" cssClass="form-control"
						placeHolder="reponse à l'annonce"></form:input>


				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-success">Valider</button>

					<a
						href="${ctx}/sitter/afficherAnnoncesBySitter?numC=${reponse.key.sitter.numC}"
						class="btn btn-warning">Annuler</a>
				</div>



			</form:form>
			<br /><br />
			
	</c:otherwise>	
</c:choose>

			<p>
				<a href="${ctx}/auth/menu" class="btn btn-info">Retour au menu</a>
			</p>

		</div>
</body>
</html>