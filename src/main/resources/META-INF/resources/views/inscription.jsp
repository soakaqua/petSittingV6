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




<meta charset="UTF-8">
<title>PetSitting</title>
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
			<br /> <a href="connexion">Connexion</a> <br /> <br /> <a
				href="connexion?id=2" >Inscription</a> <br /> <br /> <a
				href="Main page.html">Accueil</a> <br /> <br /> <a
				href="Proprio main.html"> Accès cheat Proprio</a> <br /> <br /> <a
				href="Sitter main.html"> Accès cheat Sitter</a> <br /> <br />
		</div>

		<div id="textePrincipal" class="col-8">

			<p>
				<h2>Inscription</h2>
			</p>
		
		<form:form action="${ctx}/inscription" methode="post" modelAttribute="compte">
			<form:hidden path="numC" />
			<form:hidden path="statut" />
			<form:hidden path="version" />
			
			
			<select name = "type" cssClass="form-control" required="required">
				<option value="" >Veuillez selectionner le type de compte correspondant à vos besoins !</option>
				<option value="sitter" >Vous désirez garder des animaux : Sitter</option>
				<option value="proprio" >Vous voulez faire garder vos animaux : Propriétaire</option>
			</select>
			

			<div class="form-group">
				<form:label path="prenom">Prenom :</form:label>
				<form:input path="prenom" cssClass="form-control"></form:input>
				<%-- affiche message d'erreur quand binding result déclenché --%>
				<form:errors path="prenom" cssClass="alert alert-danger" element="div"></form:errors>
			</div>	
			<div class="form-group">
				<form:label path="nom">Nom :</form:label>
				<form:input path="nom" cssClass="form-control"></form:input>
				<%-- affiche message d'erreur quand binding result déclenché --%>
				<form:errors path="nom" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="mail">Adresse email :</form:label>
				<form:input path="mail" cssClass="form-control"></form:input>
				<%-- affiche message d'erreur quand binding result déclenché --%>
				<form:errors path="mail" cssClass="alert alert-danger" element="div"></form:errors>
			</div>				
			<div class="form-group">
				<form:label path="mdpC">Mot de passe :</form:label>
				<form:input path="mdpC" cssClass="form-control"></form:input>
				<%-- affiche message d'erreur quand binding result déclenché --%>
				<form:errors path="mdpC" cssClass="alert alert-danger" element="div"></form:errors>
			</div>			
			<div class="form-group">
				<form:label path="cp">Code postal :</form:label>
				<form:input path="cp" cssClass="form-control"></form:input>
			</div>			
			<button type="submit" class="btn btn-success">envoyer</button>			
		</form:form>
	

		</div>



	</div>
</body>
</html>



