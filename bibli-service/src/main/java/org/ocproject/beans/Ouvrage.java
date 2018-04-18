package org.ocproject.beans;

public class Ouvrage{
	
	int id;
	String date_emprunt;
	String date_retour;
	int id_emprunteur;
	boolean prolongement;
	int id_livre;
	
	
	public int getId_livre() {
		return id_livre;
	}
	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}
	public boolean isProlongement() {
		return prolongement;
	}
	public void setProlongement(boolean prolongement) {
		this.prolongement = prolongement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(String date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public String getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(String date_retour) {
		this.date_retour = date_retour;
	}
	public int getId_emprunteur() {
		return id_emprunteur;
	}
	public void setId_emprunteur(int id_emprunteur) {
		this.id_emprunteur = id_emprunteur;
	}
	
	

}
