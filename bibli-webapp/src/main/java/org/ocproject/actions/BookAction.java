package org.ocproject.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import generated.livre.Livre;
import generated.livre.LivreManager;
import generated.livre.LivreManagerImpl;
import generated.ouvrage.Ouvrage;
import generated.ouvrage.OuvrageManager;
import generated.ouvrage.OuvrageManagerImpl;
import generated.user.UserManager;
import generated.user.UserManagerImpl;

public class BookAction extends ActionSupport{

	// =============== Attributs ==================
	
	private List<Livre> livres;
	private Ouvrage ouvrage;
	private Livre livre;
	Integer id;
	Integer id_ouvrage;
	String search;	
	Integer id_livre;

	
	// ============ Getters/Setters =============
	
	public List<Livre> getLivres() {return livres;}
	public String getSearch() {return search;}
	public void setSearch(String search) {this.search = search;}
	public void setLivres(List<Livre> livres) {	this.livres = livres;}
	public Livre getLivre() {return livre;}
	public void setLivre(Livre livre) {	this.livre = livre;}
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public Ouvrage getOuvrage() {return ouvrage;}
	public void setOuvrage(Ouvrage ouvrage) {this.ouvrage = ouvrage;}
	public Integer getId_livre() {return id_livre;}
	public void setId_livre(Integer id_livre) {this.id_livre = id_livre;}
	public Integer getId_ouvrage() {return id_ouvrage;}
	public void setId_ouvrage(Integer id_ouvrage) {this.id_ouvrage = id_ouvrage;}
	
	// ============ Méthodes ==================
	
	//Just shows the complete list of books in the database. Just here to test Struts and SOAP in
	//the first place. Not useful anymore.
	public String doListLivre() {
		
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		livres = livreManager.allBooks();
		return ActionSupport.SUCCESS;
	}
	
	//Show the profile page of a book when click on its name.
	public String doDetailLivre() {
		
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		
		if (id == null)
			this.addActionError("No id for book");
		else {
			livre = livreManager.detailLivre(id);
		}
		if(livre == null)
			this.addActionError("No book found");
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	//Gets a list of books depending on the key words sent in the request from the client
	public String doSearchLivre() {
		
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		
		if (search == null) {
			this.addActionError("Problem");
		}else {
			livres = livreManager.afficherResultat(search);
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	public String emprunter() {
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		OuvrageManager ouvrageMngr = new OuvrageManager();
		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		String vResult = ActionSupport.ERROR;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int actualYear = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int actualDay = cal.get(Calendar.DAY_OF_MONTH);
		int actualMonth = month+1;
		
		String currentMonth = null;
		
		if(actualMonth < 10) {
			currentMonth = "0"+((Integer)actualMonth).toString();
		}else {
			currentMonth = ((Integer)actualMonth).toString();
		}
		
		String currentDay = null;
		
		if(actualDay < 10) {
			currentDay = "0"+((Integer)actualDay).toString();
		}else {
			currentDay = ((Integer)actualDay).toString();
		}
		
		String currentYear = ((Integer)actualYear).toString();
		
		String currentDate = currentDay+currentMonth+currentYear;
		
		cal.add(Calendar.DAY_OF_MONTH, 15);
		
		actualYear = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		actualDay = cal.get(Calendar.DAY_OF_MONTH);
		actualMonth = month+1;
		
		String returnYear = ((Integer)actualYear).toString();
		String returnMonth = ((Integer)actualMonth).toString();
		String returntDay = ((Integer)actualDay).toString();
		
		String returnDate = returntDay+returnMonth+returnYear;
		
		if (id_livre != null && id != null) {
			this.livre = livreManager.emprunterLivre(id_livre);
			this.ouvrage = ouvrageManager.emprunterOuvrage(id_livre, id, currentDate, returnDate);
			vResult = ActionSupport.SUCCESS;
		}else {
			this.addActionError("No book nor id");
			vResult = ActionSupport.ERROR;
		}
		return vResult;
		
	}
	
	public String doRendre() {
		OuvrageManager ouvrageMngr = new OuvrageManager();
		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		String vResult = ActionSupport.ERROR;
		
		if (id_ouvrage != null) {
			ouvrageManager.rendre(id_ouvrage, id_livre);
			vResult = ActionSupport.SUCCESS;
		}else {
			this.addActionError("No id_ouvrage");
			vResult=ActionSupport.ERROR;
		}
		
		return vResult;
	}
	
	public String doProlonger() {
		String vResult = ActionSupport.ERROR;
		OuvrageManager ouvrageMngr = new OuvrageManager();
		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		Ouvrage ouvrage = new Ouvrage();
		ouvrage = ouvrageManager.readInfoLivre(id_ouvrage);
		
		if(ouvrage != null && id_ouvrage != null && id_livre != null && id != null) {
			ouvrageManager.prolonger(id_ouvrage, id_livre, id, ouvrage.getDateEmprunt(), ouvrage.getDateRetour());
			vResult = ActionSupport.SUCCESS;
		}
		
		return vResult;
	}
	
	
	
}
