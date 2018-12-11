package org.ocproject.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import generated.livre.Livre;
import generated.livre.LivreManager;
import generated.livre.LivreManagerImpl;
import generated.ouvrage.Ouvrage;
import generated.ouvrage.OuvrageManager;
import generated.ouvrage.OuvrageManagerImpl;
import generated.user.User;
import generated.user.UserManager;
import generated.user.UserManagerImpl;
import javassist.NotFoundException;

public class UserAction extends ActionSupport implements SessionAware{
	
	// =============== Attributs ==================
	
	String pseudo;
	String password;
	String email;
	private Map<String,Object> session;	
	Integer id;
	Boolean rappel;
	User user;
	private List<Ouvrage> ouvrages;
	List<Livre> livres;
	
//  ================== Getters/Setters ==================
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {this.session = session;}
	public Boolean getRappel() {
		return rappel;
	}
	public void setRappel(Boolean rappel) {
		this.rappel = rappel;
	}
	public Map<String, Object> getSession() {return session;}
	public String getPseudo() {return pseudo;}	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}		
	public List<Ouvrage> getOuvrages() {return ouvrages;}
	public void setOuvrages(List<Ouvrage> ouvrages) {this.ouvrages = ouvrages;}
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public void setPseudo(String pseudo) {this.pseudo = pseudo;}	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public List<Livre> getLivres() {return livres;}
	public void setLivres(List<Livre> livres) {this.livres = livres;}
	// ============ Méthodes ==================
	
	
	//Choisir d'activer ou non l'option de rappel par mail
	public String setRappelOption() {
		
		UserManager userMngr = new UserManager();
		UserManagerImpl userManager = userMngr.getUserManagerImplPort();
		
		int retourWs = 0;
		retourWs = userManager.setRappelOption(rappel, id);
		
		if (retourWs == 0) {
			this.addActionError("Erreur changement option");
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	//Creates a new user with a username, a password and an email address
	public String createUser() {
		
		UserManager userMngr = new UserManager();
		UserManagerImpl userManager = userMngr.getUserManagerImplPort();
		
		if( this.user.getPseudo() != null && this.user.getEmail() != null && this.user.getPassword() != null) {
				
				int ide = userManager.createUser(this.user.getPseudo(), this.user.getPassword(), this.user.getEmail()).getId();
				this.user.setId(ide);

		}else if(this.user.getPseudo().equals("") || this.user.getEmail().equals("") || this.user.getPassword().equals(""))
			this.addActionError("Mauvaise saisie d'un des champs");
		else if(this.user.getPseudo() == null || this.user.getEmail() == null || this.user.getPassword() == null)
			this.addActionError("Mauvaise saisie d'un des champs");
		
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	//Verify the username and the password. If ok, create a  user session.
	public String connexionUser() {
		
		UserManager userMngr = new UserManager();
		UserManagerImpl userManager = userMngr.getUserManagerImplPort();
		
		if( this.user.getPseudo() != null && this.user.getPassword() != null
				&& !this.user.getPseudo().equals("") && !this.user.getPassword().equals("")) {
				
				User vUser = userManager.connectUser(this.user.getPseudo(), this.user.getPassword());
				this.user.setId(vUser.getId());
				this.session.put("user", vUser);
				if(vUser.getPassword().equals("Wrong password")) {
					this.addActionError("Wrong password");
				}else if (vUser.getPseudo().equals("User not found")) {
					this.addActionError("Wrong user name");
				}
			
		}else if(this.user.getPseudo().equals("") || this.user.getPassword().equals(""))
			this.addActionError("Mauvaise saisie d'un des champs");
		else if(this.user.getPseudo() == null || this.user.getPassword() == null)
			this.addActionError("Mauvaise saisie d'un des champs");
		
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	//Delete the user session
	public String logout() {
		this.session.remove("user");
		return ActionSupport.SUCCESS;
	}
	
	//Method that gets all info of the user to show his profile page.
	public String detailUser() {
		UserManager userMngr = new UserManager();
		UserManagerImpl userManager = userMngr.getUserManagerImplPort();
		OuvrageManager ouvrageMngr = new OuvrageManager();
		OuvrageManagerImpl ouvrageManager = ouvrageMngr.getOuvrageManagerImplPort();
		LivreManager livreMngr = new LivreManager();
		LivreManagerImpl livreManager = livreMngr.getLivreManagerImplPort();
		
			if(id == null) {
				this.addActionError("No id nor user");
			}else {
				this.user = userManager.detailUser(id);
				this.ouvrages = ouvrageManager.checkEmprunts();
				this.livres = new ArrayList<>();
				for(Ouvrage ouvrage : ouvrages) {
					if(this.user.getId() == ouvrage.getIdEmprunteur())
						this.livres.add(livreManager.detailLivre(ouvrage.getIdLivre()));
				}
				
				if(user == null || ouvrages == null) {
					this.addActionError("user or ouvrage is null");
				}
			}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
