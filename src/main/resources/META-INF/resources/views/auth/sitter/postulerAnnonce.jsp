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
						<br/>
						<h4 style="font-size:23;color:white">Menu</h4>
						<br/>

						<a href="${ctx}/sitter/afficherAnnoncesBySitter">Consulter les annonces auxquelles j'ai postulé</a> <br /><br />
						<a href="${ctx}/sitter/afficherAnnonces">Consulter toutes les annonces</a><br /><br />
						<a href="${ctx}/sitter/historiqueAnnonces">Afficher l'historique de vos petSitting</a><br /><br />
						<a href="${ctx}/deconnexion">Me déconnecter</a>
						<br /> <br />
					</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Pet-sitter > Consulter toutes les annonces</h2>
			</p>

			<p>
			<h3>Consulter toutes les annonces</h3>
			</p>
		
         <form:form action="${ctx}/sitter/postulerAnnonce" method="post" modelAttribute="reponseAnnonce" >
  <%--     ${ctx}/sitter/postulerAnnonce : url a appeler
      post : le type de la methode get ou post
      reponseAnnonce : l'objet à poster , dans notre cas l'objet est une annonce --%>
        
			<div class="form-group">
					Voici la liste des annonces existantes :<br> 
					 
					<!-- annonce : le nom de la variable : a toi de le nommer et utiliser
                         $ : variable -->
 
						<form:select path="numA"> <!-- nom de l'attribut numA dans l'annonce -->
   
      <form:options items="${listAnnonces}" itemValue="numA" itemLabel="titre"/>
 </form:select>  
					

				</div>
				
				<div class="form-group">
					<h3>Message</h3>
					<form:input path="message" id="message" cssClass="form-control"/>
				</div>
           <button type="submit">Postuler</button>       
			<a href="${ctx}/sitter/postulerAnnonce" class="btn btn-warning">annuler</a>
			
		</form:form>

		</div>
</body>
</html>