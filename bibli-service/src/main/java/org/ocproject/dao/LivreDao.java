package org.ocproject.dao;

import java.sql.ResultSet;

import org.springframework.context.ApplicationContext;

public interface LivreDao {
	
	public ResultSet rechercheLivre(ApplicationContext context,String search);
	
	public ResultSet detailLivre(ApplicationContext context, int id);
	
	public ResultSet allBooks(ApplicationContext context);
	
	public void emprunter(ApplicationContext context,int id, int nb_restant);

}
