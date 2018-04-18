package org.ocproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.ocproject.beans.User;
import org.ocproject.dao.DaoFactory;
import org.ocproject.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebService(serviceName = "UserManager")
public class UserManagerImpl extends AbstractManager {
	

	public String modifUser(String pseudo, String password) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		User utilisateur = new User();
		utilisateur.setPseudo(pseudo);
		utilisateur.setPassword(password);
		getDaoFactory().getUserDao().modifyUser(context,utilisateur);
		return pseudo;
	}
	
	public User connectUser(String pseudo, String password) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		User utilisateur = new User();
		int id = 0;
		DaoFactory.getDaoDriver();
		ResultSet result = getDaoFactory().getUserDao().select(context,pseudo);
		
		try {
			if (result.first()) {
				String passwordResponse = result.getString("password");
				if (password.equals(passwordResponse)) {
					utilisateur.setPseudo(pseudo);
					utilisateur.setPassword(password);
					utilisateur.setId(result.getInt("id"));
				}else {
					utilisateur.setPassword("Wrong password");
				}
			}else {
				utilisateur.setPseudo("User not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return utilisateur;
	}
	
	public User detailUser(int id) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory.getDaoDriver();
		String pseudo = null;
		String password = null;
		String email = null;
		User utilisateur = new User();
	
		ResultSet result = getDaoFactory().getUserDao().select(context,id);
		
		try {
			if (result.first()) {
				pseudo = result.getString("pseudo");
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
	
	@WebMethod
	public User createUser(String pseudo, String password, String email) {
		ApplicationContext context
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		DaoFactory daoFactory = context.getBean("daoFactory", DaoFactory.class);
		DaoFactory.getDaoDriver();
		User user = new User();
		boolean userExists = false; 
		UserDao userDao = daoFactory.getUserDao();
		ResultSet result = userDao.select(context,pseudo);
		user.setPseudo(pseudo);
		user.setEmail(email);
		user.setPassword(password);
		try {
			if (result.first()) {
				user = null;
			} else {
				getDaoFactory().getUserDao().createUser(context,user);
				userExists = false;
				result = userDao.select(context,pseudo);
				if(result.next())
					user.setId(result.getInt("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
