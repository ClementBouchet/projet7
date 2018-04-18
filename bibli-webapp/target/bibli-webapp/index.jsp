<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>  
   <head>
      <title>Bibliothèque</title>
   </head>
   
   <body>
      <h1>Bienvenue sur le site de la bibliothèque</h1>
      <h2>Vous pouvez ici gérer vos emprunts et consulter la disponibilité des ouvrages</h2>
      
      <p>
       <s:a action = "booksearch">Chercher un livre</s:a>    
       
    <s:if test="#session.user">
        <s:a action="user_detail"><s:param name = "id" value = "#session.user.id"></s:param>Mon Espace</s:a>  
        <s:a action="logout">Deconnexion</s:a>
    </s:if>
    <s:else>
        <s:a action ="connexion">Se connecter</s:a>
    </s:else>
       
           <s:a action = "pageInscription">S'inscrire</s:a>  
      </p>
      
      <p>
      	<s:a action = "list_livre"> Liste des livres</s:a>
      </p>
      <!--  
      <form action = "hello">
         <label for = "name">Please enter your name</label><br/>
         <input type = "text" name = "name"/>
         <input type = "submit" value = "Say Hello"/>
      </form>-->
   </body>
</html>
