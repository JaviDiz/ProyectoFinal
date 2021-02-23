package com.store.dao;

import java.sql.*;
import java.util.*;

import com.store.dto.Client;

public class ClientDao {

	/*
	 * Lista todos los clientes de la base de datos.
	 * 
	 */
	public List<Client> listar() {
		String SQL_SELECT = "SELECT client_id, client_nif, client_name, client_surname, client_email, client_phone, client_balance, client_vip " + " FROM clients";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("client_id");
				String nif = rs.getString("client_nif");
				String name = rs.getString("client_name");
				String surname = rs.getString("client_surname");
				String email = rs.getString("client_email");
				String phone = rs.getString("client_phone");
				double balance = rs.getDouble("client_balance");
				boolean vip = rs.getBoolean("client_vip");

				client = new Client(id, nif, name, surname, email, phone, balance, vip);
				clients.add(client);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return clients;
	}

	/*
	 * Lista todos los clientes que tengan mas de 3000 euros de la base de datos.
	 * 
	 */
	
	public List<Client> getListClientPremium() {
		String SQL_SELECT = "SELECT client_id, client_nif, client_name, client_surname, client_email, client_phone, client_balance, client_vip " +
							" FROM clients WHERE client_balance >= 3000";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("client_id");
				String nif = rs.getString("client_nif");
				String name = rs.getString("client_name");
				String surname = rs.getString("client_surname");
				String email = rs.getString("client_email");
				String phone = rs.getString("client_phone");
				double balance = rs.getDouble("client_balance");
				/* boolean vip = rs.getBoolean("client_vip"); */

				client = new Client(id, nif, name, surname, email, phone, balance);
				clients.add(client);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return clients;
	}

	/*
	 * Recupera un cliente en la base de datos segun su ID.
	 * 
	 */
	public Client findById(Client client) {
		String SQL_SELECT_BY_ID = "SELECT client_id, client_nif, client_name, client_surname, client_email, client_phone, client_balance, client_vip "
				+ " FROM clients WHERE client_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

			stmt.setInt(1, client.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String nif = rs.getString("client_nif");
			String name = rs.getString("client_name");
			String surname = rs.getString("client_surname");
			String email = rs.getString("client_email");
			String phone = rs.getString("client_phone");
			double balance = rs.getDouble("client_balance");
			boolean vip = rs.getBoolean("client_vip");

			client.setNif(nif);
			client.setName(name);
			client.setSurname(surname);
			client.setEmail(email);
			client.setPhone(phone);
			client.setBalance(balance);
			client.setVip(vip);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return client;
	}

	/*
	 * Crea un cliente a la base de datos.
	 * 
	 */
	public int create(Client client) {
		String SQL_INSERT = "INSERT INTO clients(client_nif, client_name, client_surname, client_email, client_phone, client_balance, client_vip) "
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, client.getNif());
			stmt.setString(2, client.getName());
			stmt.setString(3, client.getSurname());
			stmt.setString(4, client.getEmail());
			stmt.setString(5, client.getPhone());
			stmt.setDouble(6, client.getBalance());
			stmt.setBoolean(7, client.isVip());
			System.out.println(client.toString());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un cliente de la base de datos.
	 * 
	 */
	public int update(Client client) {
		String SQL_UPDATE = "UPDATE clients "
				+ " SET client_nif=?, client_name=?, client_surname=?, client_email=?, client_phone=?, client_balance=?, client_vip=? WHERE client_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, client.getNif());
			stmt.setString(i++, client.getName());
			stmt.setString(i++, client.getSurname());
			stmt.setString(i++, client.getEmail());
			stmt.setString(i++, client.getPhone());
			stmt.setDouble(i++, client.getBalance());
			stmt.setBoolean(i++, client.isVip());
			stmt.setInt(i++, client.getId());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Borra un cliente de la base de datos.
	 * 
	 */
	public int delete(Client client) {
		String SQL_DELETE = "DELETE FROM clients WHERE client_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, client.getId());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

}
