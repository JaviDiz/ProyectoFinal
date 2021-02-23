package com.store.dto;

import java.io.Serializable;


import com.store.enums.Gender;

public class Game implements Serializable{   
	
    private int id;
    private String name;
    private String description;
    private String cover;
    private Gender gender;
    private double balance;
    private String pegi;
    private String url;
    
    
    
	public Game() {
		super();
	}



	public Game(int id) {
		super();
		this.id = id;
	}
	
	


	public Game(String name) {
		super();
		this.name = name;
	}



	public Game(String name, String description, String cover, Gender gender, double balance, String pegi) {
		super();
		this.name = name;
		this.description = description;
		this.cover = cover;
		this.gender = gender;
		this.balance = balance;
		this.pegi = pegi;
	}


	public Game(int id, String name, String description, String cover, Gender gender, double balance, String pegi) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cover = cover;
		this.gender = gender;
		this.balance = balance;
		this.pegi = pegi;
	}
	
	
	public Game(int id, String name, String description, String cover, Gender gender, double balance, String pegi,
			String url) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cover = cover;
		this.gender = gender;
		this.balance = balance;
		this.pegi = pegi;
		this.url = url;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCover() {
		return cover;
	}



	public void setCover(String cover) {
		this.cover = cover;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public String getPegi() {
		return pegi;
	}



	public void setPegi(String pegi) {
		this.pegi = pegi;
	}

	
	
	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", cover=" + cover + ", gender="
				+ gender + ", balance=" + balance + ", pegi=" + pegi + "]";
	}
    

}
