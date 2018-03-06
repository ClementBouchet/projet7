package org.ocproject.dao;

import java.sql.ResultSet;

public interface LivreDao {
	
	public ResultSet rechercheLivre(String search);
	
	public ResultSet detailLivre(int id);
	
	public ResultSet allBooks();
	
	public void emprunter(int id, int nb_restant);

}
