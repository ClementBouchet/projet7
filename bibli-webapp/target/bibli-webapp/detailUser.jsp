<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Détail utilisateur</title>
</head>
<body>
	<h1>Vos Informations Personnelles</h1>
	
	<p>
	<s:a action = "logout">Déconnection</s:a></p>
	
		<p><strong>Pseudo</strong> : <s:property value = "user.pseudo"/></p>
		<!-- <p>Mot de Passe : <s:property value = "user.password"/></p>-->
		<p><strong>Email</strong>  : <s:property value = "user.email"/></p>
	<p>
	
	<p>
	Liste des Emprunts :
	<ul>
		<s:iterator value = "ouvrages">
		<s:if test="user.id == idEmprunteur">
			<li>
			<ul>
				<!--  <li>
				- id :
				<s:property value = "id"/>
				</li>-->
				<li>
				- <strong>Livre</strong> : 
				<s:iterator value = "livres">
					<!--<s:if test="id == idLivre">-->
						<s:property value = "titre"/>
					<!--</s:if>-->
				</s:iterator>
				</li>
				<!--  <li>
				- idLivre : 
				<s:property value = "idLivre"/>
				</li>-->
				<li>
				- <strong>Date d'emprunt</strong> :
				<s:property value = "dateEmprunt"/>
				</li>
				<li>
				-<strong> Date de retour</strong> :
				<s:property value = "dateRetour"/>
				<s:a action = "doRendre">
					<s:param name = "id_ouvrage" value = "id"></s:param>
					<s:param name = "id_livre" value = "idLivre"></s:param>
					Rendre
				</s:a>
				<s:if test="prolongement == false">
				<s:if test="depasse == false">
					<s:a action = "doProlonger">
						<s:param name = "id_ouvrage" value = "id"></s:param>
						<s:param name = "id_livre" value = "idLivre"></s:param>
						<s:param name = "id" value = "user.id"></s:param>
						Prolonger
					</s:a>
				</s:if>
				</s:if>
				<p></p>
				</li>
			</ul>
			</li>
		</s:if>
		</s:iterator>
	</ul>
	</p>
	<s:a action = "index">Accueil</s:a></p>
</body>
</html>