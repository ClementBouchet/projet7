package org.ocproject.actions;

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
	
	
	public String doListLivre() {
		
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		livres = livreManager.allBooks();
		return ActionSupport.SUCCESS;
	}
	
	
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
		
		if (id_livre != null && id != null) {
			this.livre = livreManager.emprunterLivre(id_livre);
			this.ouvrage = ouvrageManager.emprunterOuvrage(id_livre, id, "13042018", "20042018");
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
	
	
	
}
