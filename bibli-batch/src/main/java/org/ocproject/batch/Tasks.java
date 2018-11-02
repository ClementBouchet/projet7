package org.ocproject.batch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import generated.reservation.Reservation;
import generated.reservation.ReservationManager;
import generated.reservation.ReservationManagerImpl;

public class Tasks {

	public void isBookAvailable() {
		Boolean isAvailable = false;
		ReservationManager reservationManager = new ReservationManager();
		ReservationManagerImpl reservationManagerImpl = reservationManager.getReservationManagerImplPort();
		List<Reservation> reservations = reservationManagerImpl.selectAll();
		for(Reservation item : reservations) {
			String dateDispo = item.getDateDispo();
			System.out.println( "date de disponibilite : " + dateDispo);
			if(dateDispo != null) {
				int dayDao = Integer.parseInt(dateDispo.substring(0, 2));
				int monthDao = Integer.parseInt(dateDispo.substring(3, 5));
				int yearDao = Integer.parseInt(dateDispo.substring(6, 10));
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				Calendar calDao = Calendar.getInstance();				
				calDao.set(yearDao, monthDao-1, dayDao);
				String formatted = format1.format(calDao.getTime());
				System.out.println( "date de disponibilite 2: " + formatted);
				Date date = new Date();
				if((calDao.getTime().before(date) || calDao.getTime().equals(date)) ) {
					//TODO send mail and manageCurrentDate ----> check if over 48h?
					Calendar calDao48h = calDao;
					calDao48h.add(Calendar.DAY_OF_MONTH,2);
					formatted = format1.format(calDao48h.getTime());
					System.out.println( "date de disponibilite 3: " + formatted);
					if(calDao48h.getTime().after(date)) {
						//Send mail
						System.out.println("The Book n° "+item.getIdLivre()+" is now available");
					}else if(calDao48h.getTime().before(date)) {
						System.out.println("Sorry, too late for the Book n° "+item.getIdLivre());
						//Send mail and anullerReservation et managecurrentdate
						reservationManagerImpl.annulerReservation(item.getId(), item.getIdUser());
						int ordre = 0;
						List<Reservation> resas =  reservationManagerImpl.selectByIdLivre(item.getIdLivre());
						for(Reservation resa : resas) {
							if(resa.getOrdre() == 1) {
								reservationManagerImpl.manageCurrentDate(resa.getId());
								//send mail
							}
						}
						
					}
				}
			}
		}
	}

}
