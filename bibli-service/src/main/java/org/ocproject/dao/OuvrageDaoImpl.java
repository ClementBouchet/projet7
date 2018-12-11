package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ocproject.beans.Ouvrage;
import org.springframework.context.ApplicationContext;

public class OuvrageDaoImpl implements OuvrageDao{
	
	private DaoFactory daoFactory;
	/**
	OuvrageDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}
	
	public void emprunter(ApplicationContext context,int id, String date_emprunt, String date_retour) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE ouvrage SET date_emprunt = "+date_emprunt+", date_retour = "+date_retour+" WHERE id_livre = "+id+";";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public ResultSet select(ApplicationContext context,int id) {
			
			Connection connexion;
			PreparedStatement prepStmt;
			ResultSet result = null;
			daoFactory = context.getBean("daoFactory", DaoFactory.class);
			String sql = "SELECT * FROM ouvrage WHERE id = ?;";
			
			
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
	
	public void prolonger(ApplicationContext context,int id, String date_retour) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE ouvrage SET prolongement = true, date_retour = ? WHERE id = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setString(1, date_retour);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet readInfoUser(ApplicationContext context,int id) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id_emprunteur, date_emprunt, date_retour, prolongement, id_livre FROM ouvrage WHERE id = ?;";
		
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
	
	@Override
	public ResultSet checkEmprunts(ApplicationContext context) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id, id_emprunteur, date_emprunt, date_retour, prolongement, id_livre FROM ouvrage;";
		
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
	
	@Override
	public ResultSet checkEmpruntsByUserId(ApplicationContext context, int userId) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id, id_emprunteur, date_emprunt, date_retour, prolongement, id_livre FROM ouvrage WHERE id_emprunteur=?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, userId);
			result= prepStmt.executeQuery();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet readInfoLivre(ApplicationContext context,int id) {
		ResultSet result = null;
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT date_emprunt, date_retour, prolongement FROM ouvrage WHERE id = ?;";
		
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
	
	public void rendre(ApplicationContext context,int id) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE ouvrage SET date_emprunt = null, date_retour = null, id_emprunteur = null, prolongement = false WHERE id = ?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Ouvrage emprunter(ApplicationContext context, int id_livre, int ide, String date_emprunt, String date_retour) {

		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE ouvrage SET date_emprunt = ?, date_retour = ?, id_emprunteur = ? WHERE id IN (SELECT max(id) FROM ouvrage WHERE id_livre = ? AND date_emprunt IS NULL) ;";
		String sql2 = "SELECT * FROM ouvrage WHERE id_livre = ?;";
		String date = "";
		Ouvrage ouvrage = new Ouvrage();
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql2);
			prepStmt.setInt(1, id_livre);
			result = prepStmt.executeQuery();
			
			while(result.next()) {
				date = result.getString("date_retour");
				ouvrage.setId(id_livre);
				ouvrage.setId_livre(result.getInt("id_livre"));
			}
			if(date == null) {
				prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepStmt.setString(1, date_emprunt);
				prepStmt.setString(2, date_retour);
				prepStmt.setInt(3, ide);
				prepStmt.setInt(4, id_livre);
				prepStmt.executeUpdate();
				date = date_retour;
				ouvrage.setDate_emprunt(date_emprunt);
				ouvrage.setDate_retour(date_retour);
				ouvrage.setId_emprunteur(ide);
				ouvrage.setProlongement(false);
			}else {
				ouvrage.setDate_emprunt("Non disponible");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ouvrage;
	}

}
