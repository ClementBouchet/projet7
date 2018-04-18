<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rechercher un livre</title>
</head>
<body>

<h1>Recherche</h1>

<!-- 
	<form action="search_livre">
		<input type = "text" name = "search"/>
		<input type = "submit" value = "Recherche"/>
	</form>-->
	  
	<s:form action = "search_livre">
		<s:textfield name ="search" label = "Search"/>
		<s:submit value = "Rechercher"/>	
	</s:form>
		
	<p>
		<ul>
			<s:iterator value = "livres">
			<li>
				<s:a action = "detail_livre">
					<s:param name = "id" value = "id"/>
					<s:property value = "titre"/>
				</s:a>
				Auteur : 
				<s:property value = "auteur"/>
				</li>
			</s:iterator>
		</ul>
	</p>

	<p>
	<s:a action = "index">Accueil</s:a>	
	</p>

</body>
</html>