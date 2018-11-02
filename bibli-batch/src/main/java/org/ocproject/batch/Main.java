package org.ocproject.batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import generated.livre.LivreManager;
import generated.livre.LivreManagerImpl;
import generated.ouvrage.Ouvrage;
import generated.ouvrage.OuvrageManager;
import generated.ouvrage.OuvrageManagerImpl;
import generated.reservation.Reservation;
import generated.reservation.ReservationManager;
import generated.reservation.ReservationManagerImpl;
import generated.user.User;
import generated.user.UserManager;
import generated.user.UserManagerImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tasks task = new Tasks();
		task.isBookAvailable();
		System.out.println("Task launched");
		/*
		OuvrageManager ouvrageMngr = new OuvrageManager();
		UserManager userMngr = new UserManager();

		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		UserManagerImpl userManager = userMngr.getUserManagerImplPort();
		
		List<Ouvrage> ouvrages = new ArrayList<Ouvrage>();
		User user = new User();
		//Gets the list of all books from the database through the webservice
		ouvrages = ouvrageManager.checkEmprunts();
		//Here we get the current date and set the variables we need later
		String dateRetour =null;
		int idUser = 0;
		int idOuvrage = 0;
		String message = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int actualYear = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int actualDay = cal.get(Calendar.DAY_OF_MONTH);
		int actualMonth = month+1;
		
		System.out.println(dateFormat.format(date));
		System.out.println(actualDay+"/"+actualMonth+"/"+actualYear);
		
		int dayDao = 3000;
		int monthDao = 3000;
		int yearDao = 3000;
		/*
		//This is just a test to see how the Calendar works
		cal.add(Calendar.DAY_OF_MONTH, 15);
		
		actualYear = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		actualDay = cal.get(Calendar.DAY_OF_MONTH);
		actualMonth = month+1;
		
		System.out.println(actualDay+"/"+actualMonth+"/"+actualYear);
		*//*
		Ouvrage ouvrage = new Ouvrage();
		//Here checks in the list if a book should be returned
		for(int i = 0; i < ouvrages.size(); i++) {
			
			
			ouvrage = ouvrages.get(i);
			if(ouvrage != null) {
				idOuvrage = ouvrage.getId();
				dateRetour = ouvrage.getDateRetour();
				idUser = ouvrage.getIdEmprunteur();
				
			}else {
				System.out.println("ouvrage null");
			}
			
			if(dateRetour != null) {
				System.out.println("=========   DEBUT   =========");
				System.out.println(dateRetour);
				System.out.println(ouvrage.getDateEmprunt());
				dayDao = Integer.parseInt(dateRetour.substring(0, 2));
				monthDao = Integer.parseInt(dateRetour.substring(3, 5));
				yearDao = Integer.parseInt(dateRetour.substring(6, 10));
				
			
				System.out.println("Date de retour : "+dayDao+"/"+monthDao+"/"+yearDao);
				System.out.println(idOuvrage);
				System.out.println(idUser);
				
				
				Calendar calDao = Calendar.getInstance();
				
				calDao.set(yearDao, monthDao-1, dayDao);
				
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				String formatted = format1.format(calDao.getTime());
				System.out.println(formatted);
				
				if(cal.after(calDao)) {
					System.out.println("current date is AFTER return date");
					user = userManager.detailUser(idUser);
					if(ouvrage != null) {
						if(ouvrage.isProlongement()) {
							message = "Bonjour "+user.getPseudo()+", vous devez rendre le livre numero "+idOuvrage+
									" depuis la date du "+formatted;
						}else {
							message = "Bonjour "+user.getPseudo()+", vous devez rendre le livre numero "+idOuvrage+
									" depuis la date du "+formatted+". Vous pouvez aussi prolonger votre emprunt de deux semaines.";
						}
						
					}
					System.out.println(message);
					//Email.sendEmail(message, "bouchetclem@gmail.com");
					//Email.sendEmail(message, user.getEmail());
				}else {
					System.out.println("current date is BEFORE return date");
				}
				System.out.println("=========    FIN    =========");
				
				
			}
		}*/
	}
}