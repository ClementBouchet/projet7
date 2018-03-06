package org.ocproject.service;

import org.ocproject.bibli.model.User;

public interface UserManager {
	
	public void modifUser(User user);
	
	public User connectUser(String pseudo);
	
	public User detailUser(String pseudo);
	
	public boolean createUser(User user);

}
