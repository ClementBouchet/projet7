package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ocproject.beans.User;
import org.springframework.context.ApplicationContext;

public class UserDaoImpl implements UserDao{
	
	private DaoFactory daoFactory;
	/**
	UserDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}
*/
	public void modifyUser(ApplicationContext context,User user) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE utilisateur SET pseudo=?, password=?, email=?);";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setString(1, user.getPseudo());
			prepStmt.setString(2, user.getPassword());
			prepStmt.setString(3, user.getEmail());
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public void setRappelOption(ApplicationContext context,Boolean etat, int id) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "UPDATE utilisateur SET rappel=? where id=?;";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setBoolean(1, etat);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public ResultSet select(ApplicationContext context,String pseudo) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id, pseudo, password, email, rappel  FROM utilisateur WHERE pseudo = ?;";
		
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepStmt.setString(1, pseudo);
			result= prepStmt.executeQuery();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ResultSet select(ApplicationContext context,int id) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id, pseudo, password, email, rappel  FROM utilisateur WHERE id = ?;";
		
		
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
	
	public void createUser(ApplicationContext context,User user) {
		Connection connexion;
		PreparedStatement prepStmt;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "INSERT INTO utilisateur(pseudo, password, email, rappel) VALUES (?,?,?, true);";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setString(1, user.getPseudo());
			prepStmt.setString(2, user.getPassword());
			prepStmt.setString(3, user.getEmail());
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public ResultSet selectAll(ApplicationContext context) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		daoFactory = context.getBean("daoFactory", DaoFactory.class);
		String sql = "SELECT id, pseudo, password, email, rappel  FROM utilisateur;";
		
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
