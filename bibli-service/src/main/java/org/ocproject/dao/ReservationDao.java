package org.ocproject.dao;

import java.sql.ResultSet;

import org.springframework.context.ApplicationContext;

public interface ReservationDao {
	
	public void reserverLivre(ApplicationContext context,int idUser, int idLivre);
	
	public ResultSet selectByIdLivre(ApplicationContext context,int idLivre);
	
	public ResultSet selectByIdUser(ApplicationContext context,int idUser);
	
	public ResultSet selectAll(ApplicationContext context);
}
