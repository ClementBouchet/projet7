package org.ocproject.dao;

import java.sql.ResultSet;

public interface OuvrageDao {
	
	public void emprunter(int id, String date_emprunt, String date_retour);
	
	public void prolonger(int id);
	
	public ResultSet readInfoUser(int id);

	public ResultSet readInfoLivre(int id);
	
	public void rendre(int id);

}
