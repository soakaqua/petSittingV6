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
<!--  dans url : mettre ./ en premier => commence là où je suis -->
<!-- si directement / => commence à localhost:8080/ -->
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<!-- lien bootstrap js local -->
<script rel="stylesheet" src="./bootstrap/js/bootstrap.min.js"></script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Sans BootStrap -->
	<!-- <form action="form"  method="post" id = "afficheForm"> -->
	<!-- <label for="prenom">  -->
	<!-- 			<input id="prenom" name ="prenom" type="text" placeholder="Saisir votre prénom">prénom</input><br> -->
	<!-- </label> -->
	<!-- <label for="nom">  -->
	<!-- 	<input id="nom" name ="nom" type="text" placeholder="Saisir votre nom">nom</input><br> -->
	<!-- </label>  -->
	<!-- 	<input type = "submit"></input> -->
	<!-- 	</form> -->

	<!-- bootstrap -->

	<!-- action : page vers laquelle on souhaite aller | method : post/get -->
	<!-- 		<form action="form" method ="post" id = "afficheForm">  -->
	<p></p>
	<div class="container">
		<!-- recupere meme page avec : action = "" -->
		<form action="" method="post" id="afficheForm">
			<div class="form-group">
				<!-- dans input : c'est le "name" qui déclare le nom du parametre -->
				<label for="mail">Email address</label> <input type="email"
					class="form-control" id="mail" name="mail"
					aria-describedby="emailHelp"> <small id="emailHelp"
					class="form-text text-muted">We'll never share your email
					with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="mdp">Password</label> <input type="password"
					class="form-control" id="mdp" name="mdp">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>