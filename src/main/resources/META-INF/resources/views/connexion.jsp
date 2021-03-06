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
		
		<p>	<h2>Connexion</h2> </p>

			<div>
			<c:if test="${param.error!=null}">
				<div class="alert alert-danger">Erreur d'authentification</div>
			</c:if>
			<!-- pour formulaire login : toujours method post et action "" -->
			<form method="post" action="">
				<!-- Pour éviter certaines attaques -->
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div>
					<!-- input : doit s'appeler username (pour spring) -->
					<label for="username">Entrez votre mail : </label> <input id="username"
						name="username" class="form-control" placeholder="exemple@gmail.com">

				</div>
				<br/>
				<div>
					<!-- input : doit s'appeler password (pour spring) -->
					<label for="password">Entrez votre mot de passe : </label><input type="password"
						id="password" name="password" class="form-control" placeholder="*****************">
				</div> <br />
				<div>
					<button type="submit" class="btn btn-success">Valider</button>
<%-- 					<a href="${ctx}" class="btn btn-link">Retour accueil</a> --%>
				</div>
				<br />
				Pas encore inscrit ? <em>Rejoignez-nous : </em>
				<br /><br />
				
				<a href="${ctx}/inscription" class="btn btn-dark">Inscription</a>
				
			</form>
		</div>

		</div>



	</div>


</body>
</html>



