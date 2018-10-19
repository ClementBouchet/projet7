package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.ocproject.beans.Reservation;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.ReservationDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName = "ReservationManager")
public class ReservationManagerImpl extends AbstractManager{


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

	public void reserver(int idUser, int idLivre) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		ReservationDao reservationDao = getDaoFactory().getReservationDao();
		List<Reservation> liste = selectByIdLivre(idLivre);
		/* TODO Effectuer le contrôle de règle de gestion
		 * -----Il n’est pas possible pour un usager de réserver un ouvrage qu’il a déjà en cours d’emprunt
		 * -----La liste de réservation ne peut comporter qu’un maximum de personnes correspondant à 2x le nombre d’exemplaires de l’ouvrage
		 */
		int ordre = 0;
		for(Reservation item : liste) {
			Integer i = item.getOrdre();
			if(i != null && i > ordre) {
				ordre = i;
			}
		}
		ordre++;
		reservationDao.reserverLivre(context, idUser, idLivre, ordre);
	}
	
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
