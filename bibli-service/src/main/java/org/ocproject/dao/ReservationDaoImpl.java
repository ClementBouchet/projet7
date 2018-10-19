package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.ocproject.beans.Reservation;
import org.ocproject.service.ReservationManagerImpl;
import org.springframework.context.ApplicationContext;

public class ReservationDaoImpl implements ReservationDao{

	private DaoFactory daoFactory;
	
	@Override
	public void reserverLivre(ApplicationContext context,int idUser, int idLivre, int ordre) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "INSERT INTO reservation (id_user, id_livre, ordre) VALUES(?,?,?);";

		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, idUser);
			prepStmt.setInt(2, idLivre);
			prepStmt.setInt(3, ordre);
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
		
		String req = "SELECT * FROM reservation WHERE id_livre=?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1,idLivre);
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
		
		String req = "SELECT * FROM reservation where id_user=?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, idUser);
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
		
		String req = "SELECT * FROM reservation";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			result = prepStmt.executeQuery();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void annulerReservation(ApplicationContext context, int id, int ordre) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		
		String req = "DELETE FROM reservation WHERE id =?;";
		String req2 = "UPDATE reservation SET ordre = ordre+1 WHERE ordre > ?";
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(req, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, id);
			prepStmt.setInt(1, ordre);
			prepStmt.executeUpdate();
			prepStmt = connexion.prepareStatement(req2, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setInt(1, ordre);
			prepStmt.executeUpdate();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
