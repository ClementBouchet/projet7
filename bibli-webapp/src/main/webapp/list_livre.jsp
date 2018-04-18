<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des livres</title>
</head>
<body>
	<h1>Liste des livres</h1>
	
	<p>
	
	<ul>
		<s:iterator value = "livres">
			<li>
				<s:a action = "detail_livre">
				<s:param name = "id" value = "id"></s:param>
				<s:property value = "titre"/>
				</s:a>
				- Auteur : 
				<s:property value = "auteur"/>
			</li>
		</s:iterator>
	</ul>
	
	</p>
</body>
</html>