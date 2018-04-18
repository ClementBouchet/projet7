package org.ocproject.actions;

import com.opensymphony.xwork2.ActionSupport;

public class AccueillAction extends ActionSupport{
	
	// =============== Attributs ==================
	
	private String name;
	
	// ============ Getters/Setters =============
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	// ============ Méthodes ==================
	
	   
	public String pageInscription() {
		return ActionSupport.SUCCESS;
	}

	public String execute() throws Exception {
	    if ("SECRET".equals(name)) {
	       return SUCCESS;
	    } else {
	       return ERROR;  
	    }
	}
	   
	   

}
