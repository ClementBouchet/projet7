package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.ocproject.dao.DaoFactory;
import org.ocproject.beans.Livre;
import org.ocproject.dao.LivreDao;
import org.ocproject.dao.OuvrageDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName = "LivreManager")
public class LivreManagerImpl extends AbstractManager{
		
	@WebMethod
	public Livre emprunterLivre(int id) {
		
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		ResultSet result = livreDao.detailLivre(context, id);
		Livre livre = new Livre();
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		int nb_exemplaire = 0;
		int nb_restant = 0;
		try {
			while(result.next()) {
		    titre = result.getString("titre");
			description = result.getString("description");
			auteur = result.getString("auteur");
			editeur = result.getString("editeur");
			nb_exemplaire = result.getInt("nb_exemplaire");
			nb_restant = result.getInt("nb_restant");
			
			livre.setAuteur(auteur);
			livre.setDescription(description);
			livre.setEditeur(editeur);
			livre.setId(id);
			livre.setNb_exemplaire(nb_exemplaire);
			livre.setNb_restant(nb_restant);
			livre.setTitre(titre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nb_restant > 0) {
			nb_restant = nb_restant - 1;
		}
		livreDao.emprunter(context,id, nb_restant);
		return livre;
	}
	
	public List<Livre> afficherResultat(String search){
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory daoFactory = context.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		ResultSet result = livreDao.rechercheLivre(context,search);
	
		List<Livre> livres = new ArrayList<Livre>();
		int id = 0;
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		
		try {
			while (result.next()) {
				
				id = result.getInt("id");
				titre = result.getString("titre");
				description = result.getString("description");
				auteur = result.getString("auteur");
				editeur = result.getString("editeur");
				Livre livre = new Livre();
				livre.setAuteur(auteur);
				livre.setDescription(description);
				livre.setTitre(titre);
				livre.setEditeur(editeur);
				livre.setId(id);
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livres;
	} 
	
	
	@WebMethod	
	public Livre detailLivre(int id){
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		DaoFactory daoFactory = context.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		LivreDao livreDao = daoFactory.getLivreDao();
		Livre livre = new Livre();
		
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		int nb_exemplaire = 0;
		int nb_restant = 0;
		if(livreDao != null) {
			livre.setDescription("Le livreDao est ok");
		ResultSet result = livreDao.detailLivre(context,id);
			if(result != null) {
				livre.setAuteur("Le resultSet est ok");
		try {
			while(result.next()) {
				titre = result.getString("titre");
				description = result.getString("description");
				auteur = result.getString("auteur");
				editeur = result.getString("editeur");
				nb_exemplaire = result.getInt("nb_exemplaire");
				nb_restant = result.getInt("nb_restant");
				
				livre.setAuteur(auteur);
				livre.setDescription(description);
				livre.setEditeur(editeur);
				livre.setId(id);
				livre.setNb_exemplaire(nb_exemplaire);
				livre.setNb_restant(nb_restant);
				livre.setTitre(titre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}else{
				livre.setAuteur("le resultSet est null");
			}
		}else {
			livre.setDescription("Le livreDao est nuuulll");
		}
		return livre;
	}
	
	
	@WebMethod
	public List<Livre> allBooks(){
		List<Livre> livres = new ArrayList<Livre>();
		int id = 0;
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		DaoFactory daoFactory = context.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		ResultSet result = livreDao.allBooks(context);
		
		try {
			while (result.next()) {
				
				id = result.getInt("id");
				titre = result.getString("titre");
				description = result.getString("description");
				auteur = result.getString("auteur");
				editeur = result.getString("editeur");
				Livre livre = new Livre();
				livre.setAuteur(auteur);
				livre.setDescription(description);
				livre.setTitre(titre);
				livre.setEditeur(editeur);
				livre.setId(id);
				
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return livres;
	}
	
}

