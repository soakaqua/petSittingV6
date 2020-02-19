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
	<br/>
	<h4 style="font-size:23;color:white">Menu</h4>
	<br/>
	<a href="proprio/consulterAnnonces">Consulter mes annonces</a> <br/><br/>
	<!--
	<a href="proprio/modifierAnnonce">Modifier une annoncee</a> <br/><br/>
	-->
	<a href="publierAnnonce">Publier une annonce</a> <br/><br/>
	<a href="validerSitter">Valider un sitter</a> <br/><br/>
	<a href="noterS">Noter un sitter</a> <br/><br/>	
	<a href="accueil">Accueil</a> <br/><br/>
	<a href="#deco">Me deconnecter </a> <br/><br/>
</div> 

<div id="textePrincipal" class="col-8">

<p><h2> Propriétaire > Gérer une annonce </h2></p> 

<p><h3> Gérer une annonce </h3></p> 

	Veuillez remplir les champs suivants :
	
	<br/><br/>
	
	<!-- FORMULAIRE -->	
	<form:form action="/petsitting/proprio/save" method="post" modelAttribute="annonce" > 
	
			<form:hidden path="proprio.numC"/>
			<form:hidden path="numA"/>
			<form:hidden path="version"/>
			<!-- CHAMPS DE CREATTION D'ANNONCE -->
			<div class="form-group">
				<form:label path="titre"> Titre de l'annonce </form:label>
				<form:input path="titre" placeholder="${titre}" cssClass="form-control"/>
				<form:errors path="titre" cssClass="alert alert-danger">
					<div class="alert alert-danger"> Champ obligatoire </div>
				</form:errors>   
			</div>
			
			<div class="form-group">
				<form:label path="message"> Message </form:label>
				<br/>
				<form:textarea path="message" placeholder="${message}" row="5" cols="60" ></form:textarea>
				<form:errors path="message" cssClass="alert alert-danger">
					<div class="alert alert-danger"> Champ obligatoire </div>
				</form:errors>   
			</div>
		
			<div class="form-group">			
		    <fieldset>  
		    
			    Selectionnez le(s) service(s) : <br/><br/>
			    
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="1" value="1">
			    <label for="1"> Garde chez le propriétaire</label>
			    </div>
			      
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="2" value="2">
			    <label for="2"> Garde chez le sitter</label>
			    </div> 
			    
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="3" value="3">
			    <label for="3"> Soins médicaux</label>
			    </div>
			    
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="4" value="4">
			    <label for="4"> Ballade</label>  
			    </div>
			    
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="5" value="5">
			    <label for="5"> Services de Massage</label>
			    </div>
			     
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="6" value="6">
			    <label for="6"> Services de Toilettage</label>
			    </div>
			    
			    <div>
			    <input class="checkboxServices" type="checkbox" name="checkboxServices" id="7" value="7">
			    <label for="7"> Services Alimentaire</label>  
			    </div>
		        
		    </fieldset>  		
			</div>
	
				<!-- BOUTONS DE VALIDATION OU ANNULATION -->
			<div class="form-group">
				<button type="submit" class="btn btn-success">Valider</button>
				<a href="${ctx}/proprio/consulterAnnonces" class="btn btn-warning">Annuler</a>
			</div>
			
		</form:form>
	<br/><br/>
</div>

</body>
</html>
