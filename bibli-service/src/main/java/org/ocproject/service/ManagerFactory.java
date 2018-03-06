package org.ocproject.service;

public class ManagerFactory {
	
	public UserManager userManager;
	public LivreManager livreManager;
	public OuvrageManager ouvrageManager;
	
	
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public LivreManager getLivreManager() {
		return livreManager;
	}
	public void setLivreManager(LivreManager livreManager) {
		this.livreManager = livreManager;
	}
	public OuvrageManager getOuvrageManager() {
		return ouvrageManager;
	}
	public void setOuvrageManager(OuvrageManager ouvrageManager) {
		this.ouvrageManager = ouvrageManager;
	}
	
	

}
