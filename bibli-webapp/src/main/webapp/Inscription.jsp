<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>

<h1>Inscription</h1>

<s:a action = "index">Accueil</s:a>

<p>

	<s:form action = "newuser">
		<p>Pseudo : <s:textfield name ="user.pseudo" label = "Pseudo" requiredLabel = "true"/></p>
		<p>Mot de passe : <s:textfield name ="user.password" label = "Mdp" requiredLabel = "true"/></p>
		<p>Email : <s:textfield name ="user.email" label = "Email" requiredLabel = "true"/></p>
		<s:submit value = "S'inscrire"/>
	</s:form>

	<!-- <form action = "newUser">
		<p><label for = "createUser">Entrez vos données personnelles</label></p>
		<p>Pseudo : <input type = "text" name = "pseudo" required/></p>
		<p>Mot de passe : <input type = "password" name = "motdepasse" required/></p>
		<p>Email : <input type = "text" name = "email" required/></p>
		<p><input type = "submit" value = "Inscription"></p>
	</form>-->

</p>

</body>
</html>