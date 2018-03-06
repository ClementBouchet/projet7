package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OuvrageDaoImpl implements OuvrageDao{
	
	private DaoFactory daoFactory;
	
	OuvrageDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}
	
	public void emprunter(int id, String date_emprunt, String date_retour) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "UPDATE ouvrage SET date_emprunt = "+date_emprunt+", date_retour = "+date_retour+" WHERE id_livre = "+id+";";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void prolonger(int id) {
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "UPDATE ouvrage SET prolongement = true WHERE id = "+id+";";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet readInfoUser(int id) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "SELECT id_emprunteur, date_emprunt, date_retour, prolongement, id_livre FROM ouvrage WHERE id = "+id+";";
		
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
	
	public ResultSet readInfoLivre(int id) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "SELECT date_emprunt, date_retour, prolongement FROM ouvrage WHERE id_livre = "+id+";";
		
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
	
	public void rendre(int id) {
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "UPDATE ouvrage SET date_emprunt = null, date_retour = null WHERE id = "+id+";";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
