<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connection</title>
</head>
<body>

<h1>Connection</h1>

<s:a action = "index">Accueil</s:a>

<p>

	<s:form action = "connexionUser">
		<p><s:textfield name ="user.pseudo" label = "Pseudo" requiredLabel = "true"/></p>
		<p><s:password name ="user.password" label = "Mot de passe" requiredLabel = "true"/></p>
		<s:submit value = "Connection"/>
	</s:form>

</p>

</body>
</html>