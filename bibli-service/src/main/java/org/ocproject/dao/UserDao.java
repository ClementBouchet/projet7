package org.ocproject.dao;

import java.sql.ResultSet;
import org.ocproject.beans.User;
import org.springframework.context.ApplicationContext;

public interface UserDao {
	
	public void modifyUser(ApplicationContext context,User user);
	
	public void setRappelOption(ApplicationContext context,Boolean etat, int id);
	
	public ResultSet select(ApplicationContext context,int id);
	
	public ResultSet select(ApplicationContext context,String pseudo);
	
	public void createUser(ApplicationContext context,User user);
	
	public ResultSet selectAll(ApplicationContext context);

}
