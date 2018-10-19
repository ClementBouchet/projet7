package org.ocproject.beans;


public class Reservation {

	public int id;
	public int idUser;
	public int idLivre;
	public int ordre;
	public String dateDispo;
	public String dateRetourPrevu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int id_user) {
		this.idUser = id_user;
	}
	public int getIdLivre() {
		return idLivre;
	}
	public void setIdLivre(int id_livre) {
		this.idLivre = id_livre;
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
