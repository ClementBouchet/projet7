package org.ocproject.dao;

import java.sql.ResultSet;

import org.ocproject.beans.Ouvrage;
import org.springframework.context.ApplicationContext;

public interface OuvrageDao {
	
	//public void emprunter(ApplicationContext context,int id, String date_emprunt, String date_retour);
	
	public void prolonger(ApplicationContext context, int id, String date_retour);
	
	public ResultSet readInfoUser(ApplicationContext context,int id);

	public ResultSet readInfoLivre(ApplicationContext context,int id);
	
	public ResultSet checkEmprunts(ApplicationContext context);
	
	public ResultSet checkEmpruntsByUserId(ApplicationContext context, int userId);
	
	public void rendre(ApplicationContext context,int id);
	
	public ResultSet select(ApplicationContext context,int id);
	
	public Ouvrage emprunter(ApplicationContext context, int id, int ide, String date_emprunt, String date_retour);

}
