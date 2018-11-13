package org.ocproject.dao;

import java.sql.ResultSet;


public interface UserDao {
	
	public void modifyUser(User user);
	
	public ResultSet select(String pseudo);
	
	public void createUser(User user);
	

}
