package org.ocproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoFactory {
	
	public UserDao userDao;
	public LivreDao livreDao;
	public OuvrageDao ouvrageDao;
	
	static ResourceBundle bundle = ResourceBundle.getBundle("sql.properties");
	
	private static String DRIVER = bundle.getString("sqdb.driver");
	private static String URL = bundle.getString("sgdb.url");
	private static String USERNAME = bundle.getString("sgdb.login");
	private static String PASSWORD = bundle.getString("sgdb.password");
	
	private String url;
	private String username;
	private String password;
	
	DaoFactory(String url, String username, String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static void getDriver() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//DaoFactory instance = new DaoFactory(
			//	URL,USERNAME,PASSWORD);
		//return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao uUserDao ) {
		this.userDao = uUserDao;
	}
	
	public LivreDao getLivreDao() {
		return livreDao;
	}
	
	public void setLivreDao(LivreDao lLivreDao ) {
		this.livreDao = lLivreDao;
	}
	
	public OuvrageDao getOuvrageDao() {
		return ouvrageDao;
	}
	
	public void setOuvrageDao(OuvrageDao oOuvrageDao ) {
		this.ouvrageDao = oOuvrageDao;
	}

}
