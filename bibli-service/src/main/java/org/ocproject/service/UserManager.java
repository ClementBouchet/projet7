package org.ocproject.service;

import org.ocproject.beans.User;

public interface UserManager {
	
	public void modifUser(User user);
	
	public int setRappelOption(Boolean rappel, int id);
	
	public User connectUser(String pseudo);
	
	public User detailUser(String pseudo);
	
	public User createUser(String pseudo, String password, String email);

}
