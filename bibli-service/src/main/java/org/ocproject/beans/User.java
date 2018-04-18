package org.ocproject.beans;

import java.util.ArrayList;

public class User {
	
	int id;
	String pseudo;
	String password;
	String email;
	ArrayList<Integer> liste;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Integer> getListe() {
		return liste;
	}
	public void setListe(ArrayList<Integer> liste) {
		this.liste = liste;
	}
	
	

}
