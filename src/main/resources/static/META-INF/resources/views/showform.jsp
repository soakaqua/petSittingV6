<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<!-- <link rel="stylesheet" -->
<!-- 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" -->
<!-- 	crossorigin="anonymous"> -->
	<!-- lien bootstrap css local -->
<!-- href : chemin : se baser sur l'url où on est => ici dans form (dans url) -->
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<!-- lien bootstrap js local -->
<script rel="stylesheet" src="./bootstrap/js/bootstrap.min.js"></script>
	
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="form" method ="post" id = "afficheForm">
		<div class="form-group">
			<h3>Mail</h3> 
			<h4>${sessionScope.identifiants.mail}</h4>
		</div>
		<div class="form-group">
			<h3>Mot de passe</h3>
			<h4>${sessionScope.identifiants.mdp}</h4>
		</div>

		
	</form>

	

</body>
</html>