package org.ocproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ocproject.bibli.model.User;

public class UserDaoImpl implements UserDao{
	
	private DaoFactory daoFactory;
	
	UserDaoImpl(DaoFactory daoFactory){
		daoFactory=this.daoFactory;
	}

	public void modifyUser(User user) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "UPDATE utilisateur SET pseudo=?, password=?, email=?);";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setString(1, user.getPseudo());
			prepStmt.setString(1, user.getPassword());
			prepStmt.setString(1, user.getEmail());
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ResultSet select(String pseudo) {
		
		Connection connexion;
		PreparedStatement prepStmt;
		ResultSet result = null;
		
		String sql = "SELECT id, pseudo, password, email  FROM utilisateur WHERE pseudo = ?;";
		
		
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
	
	public void createUser(User user) {
		Connection connexion;
		PreparedStatement prepStmt;
		
		String sql = "INSERT INTO utilisateur(pseudo, password, email) VALUES (?,?,?);";
		
		try {
			connexion = daoFactory.getConnection();
			prepStmt = connexion.prepareStatement(sql);
			prepStmt.setString(1, user.getPseudo());
			prepStmt.setString(1, user.getPassword());
			prepStmt.setString(1, user.getEmail());
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
