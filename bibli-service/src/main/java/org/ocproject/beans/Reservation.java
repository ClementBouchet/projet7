package org.ocproject.beans;


public class Reservation {

	int id;
	int idUser;
	int idLivre;
	int ordre;
	String dateDispo;
	String dateRetourPrevu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public String getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(String dateDispo) {
		this.dateDispo = dateDispo;
	}
	public String getDateRetourPrevu() {
		return dateRetourPrevu;
	}
	public void setDateRetourPrevu(String dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}
		
}
