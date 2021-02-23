package com.store.dao;

import java.util.HashMap;
import com.store.dto.*;

public class UserDao {

	
	HashMap<String, User> dadesUsuaris = new HashMap<>();
	
	/* Creo los 2 usuarios que utilizare en mi página */
	
	public UserDao() {
		dadesUsuaris.put("Admin", new User("Admin", "pass1", "Admin", true));
		dadesUsuaris.put("Client", new User("Client", "pass2", "Client", false));
	}
	
	public User getUsuari (String userId) {
		return dadesUsuaris.get(userId);
	
	}
	public boolean existUsuari (String userId) {
		return dadesUsuaris.containsKey(userId);
	
	}
	public boolean validUser (String userId, String userPass ) {
		
		if (dadesUsuaris.containsKey(userId)) {
			User usuari = dadesUsuaris.get(userId);
			String pass = usuari.getUserPassword();
			return (pass.equals(userPass));
		}else{
			return false;
		}
		
	
	}
	
}
