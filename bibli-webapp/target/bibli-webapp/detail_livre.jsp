<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informations du livre</title>
</head>
<body>
	<h1>Informations du livre</h1>
	
	<p>
	Titre : <s:property value = "livre.titre"/>
	</p>
	
	<p>
	Auteur : <s:property value = "livre.auteur"/>
	</p>
	
	<p>
	Description : <s:property value = "livre.description"/>
	</p>
	
	<p>
	Editeur : <s:property value = "livre.editeur"/>
	</p>
	<p>
	Nombre d'exemplaires disponibles : <s:property value = "livre.nbRestant"/>
	</p>
	<p>
	
	<s:if test="#session.user">
	
		<s:if test ="livre.nbRestant > 0">
		
        <s:a action="emprunter">
        <s:param name = "id_livre" value= "livre.id"></s:param>
        <s:param name = "id" value= "#session.user.id"></s:param>
        Emprunter
        </s:a>
        </s:if>
        
        <s:if test ="livre.nbRestant == 0">
		
        <s:a action="reserver">
        <s:param name = "id_livre" value= "livre.id"></s:param>
        <s:param name = "id" value= "#session.user.id"></s:param>
        Réserver
        </s:a>
        </s:if>
    </s:if>
	</p>
</body>
</html>