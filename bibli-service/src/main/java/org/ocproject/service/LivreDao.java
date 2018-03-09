package org.ocproject.service;

import java.sql.ResultSet;

public interface LivreDao {
	
	public ResultSet rechercheLivre(String search);
	
	public ResultSet detailLivre(DaoFactory daoFactory, int id);
	
	public ResultSet allBooks(DaoFactory daoFactory);
	
	public void emprunter(int id, int nb_restant);

}
