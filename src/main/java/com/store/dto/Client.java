package com.store.dto;

import java.io.Serializable;

public class Client implements Serializable{   
	
    private int id;
    private String nif;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private double balance;
    private boolean vip;

    public Client() {
    }

	public Client(int id) {
		this.id = id;
	}
	
	public Client(String nif, String name, String surname, String email, String phone, double balance) {
		super();
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
	}

	public Client(int id, String nif, String name, String surname, String email, String phone, double balance) {
		this.id = id;
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
	}
	
	public Client(int id, String nif, String name, String surname, String email, String phone, double balance, boolean vip) {
		this.id = id;
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.vip = vip;
	}

	public Client(String nif, String name, String surname, String email, String phone, double balance, boolean vip) {
		super();
		this.nif = nif;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.vip = vip;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nif=" + nif + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", phone=" + phone + ", balance=" + balance + ", vip=" + vip + "]";
	}

	


}
