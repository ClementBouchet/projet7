package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;

import org.ocproject.beans.Ouvrage;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.LivreDao;
import org.ocproject.dao.OuvrageDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName ="OuvrageManager")
public class OuvrageManagerImpl extends AbstractManager {
	
	@WebMethod
	public String prolonger(int id) {
		
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		ouvrageDao.prolonger(context, id);
		String resultat = null;
		
		ResultSet result = ouvrageDao.select(context, id);
		try {
			while(result.next()) {
				resultat = result.getString("date_retour");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultat;
		
	}
	@WebMethod
	public Ouvrage emprunterOuvrage(int id_livre, int ide, String date_emprunt, String date_retour) {
			
			ApplicationContext context
	        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
			DaoFactory.getDaoDriver();
			OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
			Ouvrage ouvrage = ouvrageDao.emprunter(context, id_livre, ide, date_emprunt, date_retour);
		
			return ouvrage;
			
		}
	
	public Ouvrage readInfoUser(int id) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		Ouvrage ouvrage = new Ouvrage();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		ResultSet result = ouvrageDao.readInfoUser(context, id);
		
		try {
			while(result.next()) {
				ouvrage.setId(id);
				ouvrage.setDate_emprunt(result.getString("date_emprunt"));
				ouvrage.setDate_retour(result.getString("date_retour"));
				ouvrage.setId_emprunteur(result.getInt("id_emprunteur"));
				ouvrage.setProlongement(result.getBoolean("prolongement"));
				ouvrage.setId_livre(result.getInt("id_livre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ouvrage;		
	}
	
	@WebMethod
	public List<Ouvrage> checkEmprunts() {
		List<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
		String dateEmprunt = null;
		String dateRetour = null;
		Boolean prolong = false;
		int id = 0;
		int id_emprunteur = 0;
		int id_livre = 0;
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		ResultSet result = ouvrageDao.checkEmprunts(context);
		
		try {
			while(result.next()) {
				id = result.getInt("id");
				dateEmprunt = result.getString("date_emprunt");
				dateRetour = result.getString("date_retour");
				id_emprunteur = result.getInt("id_emprunteur");
				prolong = result.getBoolean("prolongement");
				id_livre = result.getInt("id_livre");
				Ouvrage ouvrage = new Ouvrage();
				ouvrage.setId(id);
				ouvrage.setDate_emprunt(dateEmprunt);
				ouvrage.setDate_retour(dateRetour);
				ouvrage.setId_emprunteur(id_emprunteur);
				ouvrage.setProlongement(prolong);
				ouvrage.setId_livre(id_livre);
				
				ouvrages.add(ouvrage);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ouvrages;		
	}
	
	//Seems useless for now
	public Ouvrage readInfoLivre(int id) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		Ouvrage ouvrage = new Ouvrage();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		ResultSet result = ouvrageDao.readInfoLivre(context,id);
		
		try {
			while(result.next()) {
				ouvrage.setDate_emprunt(result.getString("date_emprunt"));
				ouvrage.setDate_retour(result.getString("date_retour"));
				ouvrage.setProlongement(result.getBoolean("prolongement"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ouvrage;
	}
	
	@WebMethod
	public int rendre(int id_ouvrage, int id_livre) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		LivreDao livreDao = getDaoFactory().getLivreDao();
		ouvrageDao.rendre(context,id_ouvrage);
		ResultSet result = livreDao.detailLivre(context,id_livre);
		int nb_restant = 0;
		try {
			while(result.next()) {
				nb_restant = result.getInt("nb_restant");
				nb_restant = nb_restant + 1;
				livreDao.emprunter(context,id_livre, nb_restant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb_restant;
	}
	
}
