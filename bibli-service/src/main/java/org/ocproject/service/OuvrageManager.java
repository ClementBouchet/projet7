package org.ocproject.service;

import org.ocproject.bibli.model.Ouvrage;

public interface OuvrageManager {
	
	public void prolonger(int id);
	
	public Ouvrage readInfoUser(int id);
	
	public Ouvrage readInfoLivre(int id);
	
	public void rendre(int id);

}
