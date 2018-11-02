package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebService;
import javax.jws.WebMethod;

import org.ocproject.beans.Ouvrage;
import org.ocproject.beans.Reservation;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.LivreDao;
import org.ocproject.dao.OuvrageDao;
import org.ocproject.dao.ReservationDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName ="OuvrageManager")
public class OuvrageManagerImpl extends AbstractManager {
	
	@WebMethod
	public String prolonger(int id, int id_livre, int ide, String date_emprunt, String date_retour) {
		
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
		
		String dateRetour = null;
		int dayDao = 0;
		int monthDao = 0;
		int yearDao = 0;
		
				dayDao = Integer.parseInt(date_retour.substring(0, 2));
				monthDao = Integer.parseInt(date_retour.substring(2, 4));
				yearDao = Integer.parseInt(date_retour.substring(4, 8));
				Calendar calDao = Calendar.getInstance();
				calDao.set(yearDao, monthDao-1, dayDao);
				calDao.add(Calendar.DAY_OF_MONTH, 15);
				int newYear = calDao.get(Calendar.YEAR);
				int month = calDao.get(Calendar.MONTH);
				int newDay = calDao.get(Calendar.DAY_OF_MONTH);
				int newMonth = month+1;
				
				String sMonth = null;String sDay = null;String sYear = null;
				 
				if(newMonth < 10) {
					sMonth= "0"+((Integer)newMonth).toString();
				}else {
					sMonth= ((Integer)newMonth).toString();
				}
				
				if(newDay < 10) {
					sDay= "0"+((Integer)newDay).toString();
				}else {
					sDay= ((Integer)newDay).toString();
				}
				
				sYear= ((Integer)newYear).toString();
				
				dateRetour = sDay+sMonth+sYear;
		
		ouvrageDao.prolonger(context, id, dateRetour);
		//ouvrageDao.emprunter(context, id_livre, ide, date_emprunt, dateRetour);
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
			ReservationManagerImpl reservationManager = new ReservationManagerImpl();
			OuvrageDao ouvrageDao = getDaoFactory().getOuvrageDao();
			Ouvrage ouvrage = ouvrageDao.emprunter(context, id_livre, ide, date_emprunt, date_retour);
			List<Reservation> reservations = reservationManager.selectByIdLivre(id_livre);
			int id = 0;
			for(Reservation item : reservations) {
				if(item != null && item.getIdLivre()==id_livre && item.getIdUser()==ide) {
					id = item.getId();
				}
			}
			reservationManager.annulerReservation(id, ide);
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
		int dayDao = 0;
		int monthDao = 0;
		int yearDao = 0;
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
				if(dateEmprunt!= null) {
					dayDao = Integer.parseInt(dateEmprunt.substring(0, 2));
					monthDao = Integer.parseInt(dateEmprunt.substring(2, 4));
					yearDao = Integer.parseInt(dateEmprunt.substring(4, 8));
					
					String sMonth = null;String sDay = null;String sYear = null;
					 
					if(monthDao < 10) {
						sMonth= "0"+((Integer)monthDao).toString();
					}else {
						sMonth= ((Integer)monthDao).toString();
					}
					
					if(dayDao < 10) {
						sDay= "0"+((Integer)dayDao).toString();
					}else {
						sDay= ((Integer)dayDao).toString();
					}
					
					sYear= ((Integer)yearDao).toString();
					
					dateEmprunt = sDay+"/"+sMonth+"/"+sYear;
					
					//dateEmprunt = ((Integer)dayDao).toString()+"/"+((Integer)monthDao).toString()+"/"+((Integer)yearDao).toString();
				}
				dateRetour = result.getString("date_retour");
				if( dateRetour != null) {
					dayDao = Integer.parseInt(dateRetour.substring(0, 2));
					monthDao = Integer.parseInt(dateRetour.substring(2, 4));
					yearDao = Integer.parseInt(dateRetour.substring(4, 8));
					
					String sMonth = null;String sDay = null;String sYear = null;
					 
					if(monthDao < 10) {
						sMonth= "0"+((Integer)monthDao).toString();
					}else {
						sMonth= ((Integer)monthDao).toString();
					}
					
					if(dayDao < 10) {
						sDay= "0"+((Integer)dayDao).toString();
					}else {
						sDay= ((Integer)dayDao).toString();
					}
					
					sYear= ((Integer)yearDao).toString();
					
					dateRetour = sDay+"/"+sMonth+"/"+sYear;
					
					//dateRetour = ((Integer)dayDao).toString()+"/"+((Integer)monthDao).toString()+"/"+((Integer)yearDao).toString();
				}
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
