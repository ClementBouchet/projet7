package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

//import org.ocproject.dao.DaoFactory;
//import org.ocproject.bibli.model.Livre;
import org.ocproject.service.Livre;
import org.ocproject.service.LivreDao;
//import org.ocproject.dao.LivreDao;
//import org.ocproject.dao.OuvrageDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName = "LivreManager")
public class LivreManagerImpl extends AbstractManager{
	
		
	//private LivreDao livreDao = getDaoFactory().getLivreDao();
	//private OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();

	
	/**
	public void emprunter(int id, String date_emprunt, String date_retour) {
		ouvrageDao.emprunter(id, date_emprunt, date_retour);
		Livre livre = this.detailLivre(id);
		int nb_restant = livre.getNb_restant();
		if(nb_restant > 0) {
			nb_restant = nb_restant - 1;
		}
		livreDao.emprunter(id, nb_restant);
		
	}
	
	public List<Livre> afficherResultat(String search){
		
		ResultSet result = livreDao.rechercheLivre(search);
	
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
				
				livres.add(livre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livres;
	} */
	@WebMethod	
	public Livre detailLivre(int id){
		ApplicationContext vApplicationContext
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		DaoFactory daoFactory = vApplicationContext.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		Livre livre = new Livre();
		
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		int nb_exemplaire = 0;
		int nb_restant = 0;
		if(livreDao != null) {
			livre.setDescription("Le livreDao est ok");
		ResultSet result = livreDao.detailLivre(getDaoFactory(),id);
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

	public List<Livre> allBooks(){
		List<Livre> livres = new ArrayList<Livre>();
		int id = 0;
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		ApplicationContext vApplicationContext
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		DaoFactory daoFactory = vApplicationContext.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		ResultSet result = livreDao.allBooks(getDaoFactory());
		
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

