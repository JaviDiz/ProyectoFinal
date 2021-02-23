package com.store.dto;

import java.io.Serializable;

public class Skin implements Serializable{   
	
	private int id;
	private String name;
	private double price;
	private int stock;
	private String cover;
	private int idGame;
    private Game game;
    
    
    
	public Skin() {
		super();
	}

	public Skin(int id) {
		super();
		this.id = id;
	}
	
	

	public Skin(int id, int stock) {
		super();
		this.id = id;
		this.stock = stock;
	}

	public Skin(int id, String name, double price, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cover = cover;
	}
	
	

	public Skin(int id, String name, double price, int stock, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.cover = cover;
		
	}

	public Skin(String name, double price, int stock, String cover, int idGame) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.cover = cover;
		this.idGame = idGame;
	}
	


	public Skin(int id, String name, double price, String cover, int idGame) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cover = cover;
		this.idGame = idGame;
	}

	public Skin(int id, String name, double price, String cover, Game game) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cover = cover;
		this.game = game;
	}

	
	public Skin(int id, String name, double price,  int stock, String cover, int idGame) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.cover = cover;
		this.idGame = idGame;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Skin [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", cover=" + cover
				+ ", idGame=" + idGame + "]";
	}

	

	

	
	
    
    
	

	


}
