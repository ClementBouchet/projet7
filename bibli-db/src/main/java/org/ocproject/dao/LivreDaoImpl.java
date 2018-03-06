package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivreDaoImpl implements LivreDao{
	
	private DaoFactory daoFactory;
	
	LivreDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}
	
	public void emprunter(int id, int nb_restant) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "UPDATE livre SET nb_restant = "+nb_restant+" WHERE id = "+id+";";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet rechercheLivre(String search) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		
		String sql = "SELECT id, titre, description, auteur, editeur  FROM livre WHERE titre LIKE '%"+search+"%'"
				+ "OR description LIKE '%"+search+"%' OR auteur LIKE '%"+search+"%' OR editeur LIKE '%"+search+"%';";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result= prepStmt.executeQuery();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet detailLivre(int id) {
		ResultSet result =null;
		
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "SELECT id, titre, description, auteur, editeur, nb_exemplaire, nb_restant FROM livre WHERE id = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, id);
			result= prepStmt.executeQuery();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	 
	public ResultSet allBooks(){
	
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		
		String sql = "SELECT id, titre, description, auteur, editeur  FROM livre;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result= prepStmt.executeQuery();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


}
