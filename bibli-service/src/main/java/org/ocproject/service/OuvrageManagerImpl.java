package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ocproject.bibli.model.Ouvrage;
import org.ocproject.dao.LivreDao;
import org.ocproject.dao.OuvrageDao;

public class OuvrageManagerImpl extends AbstractManager implements OuvrageManager{
	
	
	private LivreDao livreDao = getDaoFactory().getLivreDao();
	private OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();	
	
	public void prolonger(int id) {
		ouvrageDao.prolonger(id);
	}
	
	public Ouvrage readInfoUser(int id) {
		Ouvrage ouvrage = new Ouvrage();
		ResultSet result = ouvrageDao.readInfoUser(id);
		
		try {
			ouvrage.setDate_emprunt(result.getString("date_emprunt"));
			ouvrage.setDate_retour(result.getString("date_retour"));
			ouvrage.setId_emprunteur(result.getInt("id_emprunteur"));
			ouvrage.setProlongement(result.getBoolean("prolongement"));
			ouvrage.setId_livre(result.getInt("id_livre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ouvrage;		
	}
	
	public Ouvrage readInfoLivre(int id) {
		Ouvrage ouvrage = new Ouvrage();
		ResultSet result = ouvrageDao.readInfoLivre(id);
		
		try {
			ouvrage.setDate_emprunt(result.getString("date_emprunt"));
			ouvrage.setDate_retour(result.getString("date_retour"));
			ouvrage.setProlongement(result.getBoolean("prolongement"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ouvrage;
	}
	
	public void rendre(int id) {
		ouvrageDao.rendre(id);
		ResultSet result = livreDao.detailLivre(id);
		int nb_restant;
		try {
			nb_restant = result.getInt("nb_restant");
			nb_restant = nb_restant + 1;
			livreDao.emprunter(id, nb_restant);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
