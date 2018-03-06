package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ocproject.bibli.model.Livre;
import org.ocproject.dao.LivreDao;
import org.ocproject.dao.OuvrageDao;

public class LivreManagerImpl extends AbstractManager implements LivreManager{
	
		
	private LivreDao livreDao = getDaoFactory().getLivreDao();
	private OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();

	
	
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
	}
		
	public Livre detailLivre(int id) {
		Livre livre = new Livre();
		
		String titre = null;
		String description = null;
		String auteur = null;
		String editeur = null;
		int nb_exemplaire = 0;
		int nb_restant = 0;
		
		ResultSet result = livreDao.detailLivre(id);
		
		try {
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
			livre.setTitre(titre);
			livre.setNb_exemplaire(nb_exemplaire);
			livre.setNb_restant(nb_restant);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		ResultSet result = livreDao.allBooks();
		
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

