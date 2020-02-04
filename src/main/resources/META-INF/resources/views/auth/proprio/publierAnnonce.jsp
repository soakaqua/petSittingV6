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

<p><h2> Propriétaire > Publier une annonce </h2></p> 

<p><h3> Publier une annonce </h3></p> 

	Vous voulez publier une annonce. Veuillez remplir les champs suivants :
	
	<br/><br/>
	
	<!-- FORMULAIRE -->	
	<form:form action="savePubli?numC=${sessionScope.numC}" method="get" modelAttribute="annonce">
	
			<form:hidden path="numC"/>
			<!-- CHAMPS DE CREATTION D'ANNONCE -->
			<div class="form-group">
				<form:label path="titre">Titre</form:label>
				<form:input path="titre" placeholder="Entrez un titre" cssClass="form-control"/>
				<form:errors path="titre" cssClass="alert alert-danger">
					<div class="alert alert-danger"> Champ obligatoire </div>
				</form:errors>   
			</div>
			
			<div class="form-group">
				<form:label path="message">  Message</form:label>
				<br/>
				<form:textarea path="message" placeholder="Entrez un message" row="5" cols="60" ></form:textarea>
				<form:errors path="message" cssClass="alert alert-danger">
					<div class="alert alert-danger"> Champ obligatoire </div>
				</form:errors>   
			</div>
	
				<!-- BOUTONS DE VALIDATION OU ANNULATION -->
			<div class="form-group">
				<button type="submit" class="btn btn-success">Valider</button>
				<a href="${ctx}/proprio/consulterAnnonces?numC=${session.numC}" class="btn btn-warning">Annuler</a>
			</div>
			
		</form:form>

<!-- 
<em><p><label for="services">Selectionnez le(s) service(s)</label></p></em>
<input type="checkbox" id="gp" name="gp"/> <label for="gp">Garde chez propriétaire</label> <br/>
<input type="checkbox" id="gs" name="gs"/> <label for="gs">Garde chez le sitter</label> <br/>
<input type="checkbox" id="med" name="med"/> <label for="med">Soins médicaux</label> <br/>
<input type="checkbox" id="bal" name="bal"/> <label for="bal">Ballade</label> <br/>
<input type="checkbox" id="mas" name="mas"/> <label for="mas">Massage</label> <br/>
<input type="checkbox" id="to" name="to"/> <label for="to">Toilettage</label> <br/>
<input type="checkbox" id="ali" name="ali"/> <label for="ali">Alimentaire</label>
 -->


	
</div>

</body>
</html>
