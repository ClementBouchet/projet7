package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.ocproject.beans.Livre;
import org.ocproject.beans.Ouvrage;
import org.ocproject.beans.Reservation;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.ReservationDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName = "ReservationManager")
public class ReservationManagerImpl extends AbstractManager{

	@WebMethod
	public List<Reservation> selectByIdLivre(int idLivre) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		ResultSet result = reservationDao.selectByIdLivre(context, idLivre);
		List<Reservation> retour= new ArrayList<>();
		int id = 0;
		int idUser = 0;
		String dateDispo = null;
		String dateRetour = null;
		try {
			while(result.next()) {
				Reservation reservation = new Reservation();
				id = result.getInt("id");
				idUser = result.getInt("id_user");
				dateDispo = result.getString("date_dispo");
				dateRetour = result.getString("date_retour");
				reservation.setId(id);
				reservation.setIdLivre(idLivre);
				reservation.setIdUser(idUser);
				reservation.setDateDispo(dateDispo);
				reservation.setDateRetourPrevu(dateRetour);
				
				retour.add(reservation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retour;
	}

	@WebMethod
	public List<Reservation> selectByIdUser(int idUser) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		ResultSet result = reservationDao.selectByIdUser(context, idUser);
		List<Reservation> retour= new ArrayList<>();
		int id = 0;
		int idLivre = 0;
		String dateDispo = null;
		String dateRetour = null;
		try {
			while(result.next()) {
				Reservation reservation = new Reservation();
				id = result.getInt("id");
				idLivre = result.getInt("id_livre");
				dateDispo = result.getString("date_dispo");
				dateRetour = result.getString("date_retour");
				reservation.setId(id);
				reservation.setIdLivre(idLivre);
				reservation.setIdUser(idUser);
				reservation.setDateDispo(dateDispo);
				reservation.setDateRetourPrevu(dateRetour);
				
				retour.add(reservation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retour;
	}

	@WebMethod
	public List<Reservation> selectAll() {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		ResultSet result = reservationDao.selectAll(context);
		List<Reservation> retour= new ArrayList<>();
		int id = 0;
		int idLivre = 0;
		int idUser = 0;
		String dateDispo = null;
		String dateRetour = null;
		try {
			while(result.next()) {
				Reservation reservation = new Reservation();
				id = result.getInt("id");
				idLivre = result.getInt("id_livre");
				dateDispo = result.getString("date_dispo");
				dateRetour = result.getString("date_retour");
				reservation.setId(id);
				reservation.setIdLivre(idLivre);
				reservation.setIdUser(idUser);
				reservation.setDateDispo(dateDispo);
				reservation.setDateRetourPrevu(dateRetour);
				
				retour.add(reservation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retour;
	}

	@WebMethod
	public void reserver(int idUser, int idLivre) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		List<Reservation> liste = selectByIdLivre(idLivre);
		//Boolean pour savoir si l'utilisateur qui demande la réservation à déja le livre en cours d'emprunt
		Boolean isReserved = false;
		//Boolean pour savoir le nombre de personne sur la liste de réservation n'exede pas 2x le nombre d'exemplaire
		Boolean isFull = false;
		
		//RG : Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt
		OuvrageManagerImpl ouvrageManager = new OuvrageManagerImpl();
		LivreManagerImpl livreManager = new LivreManagerImpl();
		List<Ouvrage> listeOuvrage = ouvrageManager.checkEmprunts();
		for(Ouvrage item : listeOuvrage) {
			if(item.getId_emprunteur()==idUser && item.getId_livre()==idLivre) {
				 isReserved = true;
				 break;
			}
		}
		//RG : La liste de réservation ne peut comporter qu’un maximum de personnes correspondant à 2x le nombre d’exemplaires de l’ouvrage
		//On compte le nombre de reservation de ce livre et on en profite pour déterminer l'ordre sur la liste d'attente
		if(!isReserved) {
			int ordre = 0;
			int nb_resa = 0;
			Livre livre = livreManager.detailLivre(idLivre);
			for(Reservation item : liste) {
				Integer i = item.getOrdre();
				if(item.getIdLivre()==idLivre) {
					nb_resa++;
				}
				if(i != null && i > ordre) {
					ordre = i;
				}
			}
			if(livre.getNb_exemplaire()<= nb_resa*2) {
				isFull = true;
			}
			if(!isFull) {
				ordre++;
				reservationDao.reserverLivre(context, idUser, idLivre, ordre);
			}
		}
	}
	
	@WebMethod
	public void annulerReservation(int id, int idUser) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		List<Reservation> liste = selectByIdUser(idUser);
		int ordre = 0;
		for(Reservation item : liste) {
			if(idUser == item.getIdUser()) {
				ordre = item.getOrdre();
			}
		}
		reservationDao.annulerReservation(context, idUser, ordre);
	}
}
