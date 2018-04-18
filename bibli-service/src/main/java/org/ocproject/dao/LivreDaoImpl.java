package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LivreDaoImpl implements LivreDao{
	
	private DaoFactory daoFactory;
	
	
/**
	LivreDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}
	*/
	public void emprunter(ApplicationContext context,int id, int nb_restant) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);

		String sql = "UPDATE livre SET nb_restant = ? WHERE id = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, nb_restant);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet rechercheLivre(ApplicationContext context,String search) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
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
	
	public ResultSet detailLivre(ApplicationContext context,int id) {
		ResultSet result =null;
		
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
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
	 
	public ResultSet allBooks(ApplicationContext context){
	
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
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
