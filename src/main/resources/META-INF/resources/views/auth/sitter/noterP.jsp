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
			<br />
			<h4 style="font-size: 23; color: white">Menu</h4>
			<br /> <a href="Sitter consulterAnnoncesS.html"> Consulter mes
				annonces</a> <br />
			<br /> <a href="Sitter toutesAnnonces.html">Consulter toutes les
				annonces </a> <br />
			<br /> <a href="Sitter postulerAnnonce.html">Postuler à une
				annonce</a> <br />
			<br /> <a href="Sitter noterP.html">Noter un propriétaire</a> <br />
			<br /> <a href="Main page.html">Accueil</a> <br />
			<br /> <a href="#deco">Me deconnecter </a> <br />
			<br />


		</div>

		<div id="textePrincipal" class="col-8">

			<p>
			<h2>Pet-sitter > Noter un propriétaire</h2>
			</p>

			<p>
			<h3>Noter un propriétaire sur une annonce passée</h3>
			</p>

			Vous voulez noter un propriétaire sur vos interactions sur l'une des
			annonces passées. <br />
			<br />
			 <form:form action="${ctx}/sitter/noterAnnonce" method="post" modelAttribute="annonce" >
 
			<em><p>Choix de l'annonce réalisée :</p></em>
			<form:select path="numA">
   
      <form:options items="${list}" itemValue="numA" itemLabel="titre"/>
 </form:select>
			<br /> Veuillez remplir les champs suivants : <br />
			<br /> <em><p>
					<label for="noteS">Notez entre 0 (à ne pas recommander) et
						5 (à recommander) :</label>
				
				</p></em>  <tr>
               <td><form:label path = "noteP">Note</form:label></td>
               <td>
                  <form:radiobutton path = "noteP" value = "1" label = "1" />
                  <form:radiobutton path = "noteP" value = "2" label = "2" />
                  <form:radiobutton path = "noteP" value = "3" label = "3" />
                  <form:radiobutton path = "noteP" value = "4" label = "4" />
                  <form:radiobutton path = "noteP" value = "5" label = "5" />
               </td>
            </tr>
			<br /> <input value="Valider" type="submit" /> <br />
			<br />

			 </form:form> 

		</div>
</body>
</html>



