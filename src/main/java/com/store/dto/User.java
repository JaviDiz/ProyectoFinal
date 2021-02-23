package com.store.dto;

public class User {

	private String userName;
	private String userPassword;
	private String nom;
	private boolean admin;
	
	
	public User(String userName, String userPassword, String nom) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.nom = nom;
	}
	
	


	public User(String userName, String userPassword, String nom, boolean admin) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.nom = nom;
		this.admin = admin;
	}




	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}




	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", nom=" + nom + "]";
	}
	
	
	
	
}
