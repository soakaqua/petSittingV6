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

		<div id="banderole" class="col-2">
			<br />
			<h4 style="font-size: 23; color: white">Menu</h4><br />
			<a href="${ctx}/accueil" > Accueil</a> <br /> <br />
			<a href="${ctx}/connexion">Connexion</a> <br /> <br /> 
			<a href="${ctx}/inscription">Inscription</a> <br /> <br /> 
		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Accueil</h2>
			</p>

			 <h3><em>Tout l'amour dont votre animal a besoin</em></h3>
			 <br/>
          <p> Vous ne passez pas autant de temps que vous le voudriez avec votre animal ?</p>
          <p>  Vous partez en vacances et vous voulez garder votre animal ?</p>
          <p> Votre animal a besoin des soins médicaux ou de toilettage et vous ne trouvez pas le temps pour le faire ? </p>
          <p><b>PetSitting</b>, vous met en contact avec des pet-sitters compétents et qualifiés pour prendre soin de votre compagnon.</p>
			<br />
			<a href="${ctx}/connexion" class="btn btn-info">Connexion</a> 
			<a href="${ctx}/inscription" class="btn btn-dark">Inscription</a>
			<br /> <br /> <br /> <br />

		</div>



	</div>
</body>
</html>



