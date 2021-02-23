package com.store.dao;

import java.sql.*;
import java.util.*;

import com.store.dto.Game;
import com.store.dto.Skin;
import com.store.enums.Gender;

public class SkinDao {

	/*
	 * Lista todas las skins de la base de datos
	 * 
	 */
	public List<Skin> listar() {
		String SQL_SELECT = "SELECT skin_id, skin_name, skin_price, skin_stock, skin_cover, game_name " + " FROM skins, games" + " WHERE game_id = skin_game_id";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Skin skin = null;
		List<Skin> skins = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("skin_id");
				String name = rs.getString("skin_name");
				double price = rs.getDouble("skin_price");
				int stock = rs.getInt("skin_stock");
				String cover = rs.getString("skin_cover");
				
				
				String gameName = rs.getString("game_name");
				
				Game game = new Game(gameName);
				
				

				skin = new Skin(id, name, price, stock, cover);
				skin.setGame(game);
				skins.add(skin);
				
				System.out.println(skins);
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return skins;
	}
	
	/*
	 * Recupera un skin en la base de dades segun su ID.
	 * 
	 */
	
	public Skin findById(Skin skin) {
		String SQL_SELECT_BY_ID = "SELECT skin_id, skin_name, skin_price, skin_stock, skin_cover, skin_game_id "
				+ " FROM skins WHERE skin_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

			stmt.setInt(1, skin.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("skin_name");
			double price = rs.getDouble("skin_price");
			int stock = rs.getInt("skin_stock");
			String cover = rs.getString("skin_cover");
			int idGame = rs.getInt("skin_game_id");
			
			

			skin.setName(name);
			skin.setPrice(price);
			skin.setStock(stock);
			skin.setCover(cover);
			skin.setIdGame(idGame);
			
			

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return skin;
	}
	
	/*
	 * Crea un skin en la base de datos.
	 * 
	 */
	
	public int create(Skin skin) {
		String SQL_INSERT = "INSERT INTO skins(skin_name, skin_price, skin_stock, skin_cover, skin_game_id) "
				+ " VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, skin.getName());
			stmt.setDouble(2, skin.getPrice());
			stmt.setInt(3, skin.getStock());
			stmt.setString(4, skin.getCover());
			stmt.setInt(5, skin.getIdGame());
			
			System.out.println(skin.toString());
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
	 * Modifica un skin de la base de datos.
	 * 
	 */
	public int update(Skin skin) {
		String SQL_UPDATE = "UPDATE skins "
				+ " SET skin_name=?, skin_price=?, skin_stock=?, skin_cover=?, skin_game_id=? WHERE skin_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, skin.getName());
			stmt.setDouble(i++, skin.getPrice());
			stmt.setInt(i++, skin.getStock());
			stmt.setString(i++, skin.getCover());
			stmt.setInt(i++, skin.getIdGame());
			stmt.setInt(i++, skin.getId());
			
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
	 * Modifica el stock de un skin.
	 * 
	 */
	
	public int buy(Skin skin) {
		String SQL_UPDATE = "UPDATE skins "
				+ " SET skin_stock=? WHERE skin_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setInt(i++, skin.getStock());
			stmt.setInt(i++, skin.getId());
			
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
	 * Borra un skin de la base de datos.
	 * 
	 */
	
	public int delete(Skin skin) {
		String SQL_DELETE = "DELETE FROM skins WHERE skin_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, skin.getId());
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
