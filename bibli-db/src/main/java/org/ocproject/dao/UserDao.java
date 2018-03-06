package org.ocproject.dao;

import java.sql.ResultSet;
import org.ocproject.bibli.model.User;

public interface UserDao {
	
	public void modifyUser(User user);
	
	public ResultSet select(String pseudo);
	
	public void createUser(User user);
	

}
