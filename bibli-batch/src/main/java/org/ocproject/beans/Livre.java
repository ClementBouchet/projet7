package org.ocproject.beans;

public class Livre {
	
	int id;
	String titre;
	String description;
	String auteur;
	String editeur;
	int nb_exemplaire;
	
	public int getNb_exemplaire() {
		return nb_exemplaire;
	}
	public void setNb_exemplaire(int nb_exemplaire) {
		this.nb_exemplaire = nb_exemplaire;
	}
	public int getNb_restant() {
		return nb_restant;
	}
	public void setNb_restant(int nb_restant) {
		this.nb_restant = nb_restant;
	}
	int nb_restant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
	

}
