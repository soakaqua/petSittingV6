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

		<div id="banderole" class="col-2"><br />
			<h4 style="font-size:23;color:white">Menu</h4>
			<br />
			<a href="${ctx}/proprio/consulterAnnonces">Consulter mes annonces</a> <br/><br/>
			<a href="${ctx}/proprio/consulterAnnoncesTerminees">Consulter l'historique de mes annonces</a> <br/><br/>
			<a href="${ctx}/proprio/publierAnnonce?numC=${numC}">Publier une annonce</a> <br/><br/>
			<a href="${ctx}/deconnexion">Me deconnecter </a> <br/><br/>
		</div> 
	
<div id="textePrincipal" class="col-10">

<p> <h2> Propriétaire > Consulter mes annonces terminées </h2> </p> 
<p> <h3> Consulter l'historique de mes annonces </h3> </p> 

<!-- 
Pour créer une nouvelle annonce :<br /><br />

	<a href="${ctx}/proprio/publierAnnonce?numC=${numC}"
				class="btn btn-success">Nouvelle annonce</a>
	<br />
	 -->
	<br />	

 
	Voici les annonces que vous avez publiées :

	<br /><br />

<c:choose>
	
	<c:when test="${annoncesT.isEmpty()}">
			<em>Vous n'avez aucune annonce en cours</em>
	</c:when>

	<c:otherwise>
		<div>	
			<table class="table" style="text-align: center;">
				<tr>
					<th style="text-align:center">Titre</th>
					<th style="text-align:center">Message</th>
					<th colspan="7" style="text-align:center">Services</th>
	
					<th>Noter le Sitter</th>
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
					<td>sur sa prestation</td>	
						
				</tr>
				
				<c:forEach items="${annoncesT}" var="a" varStatus="cpt">
					<tr>
						<!-- COLONNES -->
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

					
						<!-- BOUTONS -->	
						
						<c:choose>
							<c:when test="${a.statut == 1 && a.noteS == null}"> 
								<form action="${ctx}/proprio/noterAnnonce?numA=${a.numA}&numC=${numC}" method="post" id="form${cpt.index}">									
									<td>
										<input type="text" id="numA" name="numA" hidden="true" value="${a.numA}">
										<select required="true" name="noteS" id="noteS" class="mdb-select md-form">
										  <option value="" selected>0 mauvaise - 5 excellente</option>																
										  <option value="0">0</option>										
										  <option value="1">1</option>
										  <option value="2">2</option>
										  <option value="3">3</option>
										  <option value="4">4</option>
										  <option value="5">5</option>
										</select>
									</td>
									
									<td><button type="submit" form="form${cpt.index}" value="Submit" class="btn btn-success">Noter</button></td>
									
								</form>
							</c:when>
							<c:when test="${a.noteS != null}">
								<td>
								${a.noteS}
								</td>
							</c:when>
						
						</c:choose>
									
					</tr>
					
				</c:forEach>
			</table>
		</div>		
	</c:otherwise>		
</c:choose>
<br /><br />
		<p><a href="${ctx}/auth/menu" class="btn btn-info">Retour au menu</a></p>

<br /><br />	
</div>
<br /><br />
<br /><br />

</body>
</html>
