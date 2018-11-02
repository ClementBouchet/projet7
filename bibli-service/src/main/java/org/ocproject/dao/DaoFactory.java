package org.ocproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoFactory {
	
	public UserDao userDao;
	public LivreDao livreDao;
	public OuvrageDao ouvrageDao;
	public ReservationDao reservationDao;
	/**
	static ResourceBundle bundle = ResourceBundle.getBundle("sql.properties");
	
	private static String DRIVER = bundle.getString("sqdb.driver");
	private static String URL = bundle.getString("sgdb.url");
	private static String USERNAME = bundle.getString("sgdb.login");
	private static String PASSWORD = bundle.getString("sgdb.password");
	*/
	private String url;
	private String username;
	private String password;
	private static String driver;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		DaoFactory.driver = driver;
	}

	DaoFactory(){}
	
	DaoFactory(String url, String username, String password, String driver){
		this.url = url;
		this.username = username;
		this.password = password;
		this.driver = driver;
	}
	
	public static void getDaoDriver() {
		try {
			Class.forName(driver);
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
	
	public ReservationDao getReservationDao() {
		return reservationDao;
	}
	
	public void setReservationDao(ReservationDao rReservationDao ) {
		this.reservationDao = rReservationDao;
	}

}
