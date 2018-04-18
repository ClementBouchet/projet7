package org.ocproject.service;

import java.util.List;

import org.ocproject.beans.Ouvrage;

public interface OuvrageManager {
	
	public void prolonger(int id);
	
	public Ouvrage readInfoUser(int id);
	
	public Ouvrage readInfoLivre(int id);
	
	public List<Ouvrage> checkEmprunts();
	
	public void rendre(int id_ouvrage, int id_livre);

}
