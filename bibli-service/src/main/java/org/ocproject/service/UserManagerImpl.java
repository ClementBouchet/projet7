package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.ocproject.bibli.model.User;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.UserDao;

public class UserManagerImpl extends AbstractManager implements UserManager{
	

	public void modifUser(User user) {
		getDaoFactory().getUserDao().modifyUser(user);
	}
	
	public User connectUser(String pseudo) {
		String password = null;
		User utilisateur = new User();
	
		ResultSet result = getDaoFactory().getUserDao().select(pseudo);
		
		try {
			if (result.first()) {
				password = result.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		utilisateur.setPseudo(pseudo);
		utilisateur.setPassword(password);
		
		return utilisateur;
	}
	
	public User detailUser(String pseudo) {
		int id = 0;
		String password = null;
		String email = null;
		User utilisateur = new User();
	
		ResultSet result = getDaoFactory().getUserDao().select(pseudo);
		
		try {
			if (result.first()) {
				password = result.getString("password");
				email = result.getString("email");
				id = result.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		utilisateur.setPseudo(pseudo);
		utilisateur.setPassword(password);
		utilisateur.setEmail(email);
		utilisateur.setId(id);
		
		return utilisateur;
	}
	
	public boolean createUser(User user) {
		
		String pseudo = user.getPseudo();
		boolean userExists = false; 
		ResultSet result = getDaoFactory().getUserDao().select(pseudo);
		
		try {
			if (result.first()) {
				userExists = true;
			} else {
				getDaoFactory().getUserDao().createUser(user);
				userExists = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userExists;
	}

}
