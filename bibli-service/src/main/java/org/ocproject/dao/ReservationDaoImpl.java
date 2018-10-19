package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;

public class ReservationDaoImpl implements ReservationDao{

	private DaoFactory daoFactory;
	
	@Override
	public void reserverLivre(ApplicationContext context,int idUser, int idLivre) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//TODO prepStmt.setInt(1, idUser); ...
			prepStmt.executeUpdate();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet selectByIdLivre(ApplicationContext context,int idLivre) {
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//TODO Logique ici
			result = prepStmt.executeQuery();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet selectByIdUser(ApplicationContext context,int idUser) {
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//TODO Logique ici
			result = prepStmt.executeQuery();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResultSet selectAll(ApplicationContext context) {
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//TODO Logique ici
			result = prepStmt.executeQuery();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
