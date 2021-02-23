package com.store.dao;

import java.sql.*;
import java.util.*;

import com.store.dto.Game;
import com.store.enums.Gender;

public class GameDao {

	/*
	 * Lista todos los juegos de la base de datos.
	 * 
	 */
	public List<Game> listar() {
		String SQL_SELECT = "SELECT game_id, game_name, game_description, game_cover, game_gender, game_balance, game_pegi, game_url " + " FROM games";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Game game = null;
		List<Game> games = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("game_id");
				String name = rs.getString("game_name");
				String description = rs.getString("game_description");
				String cover = rs.getString("game_cover");
				Gender gender = Gender.valueOf(rs.getString("game_gender"));
				double balance = rs.getDouble("game_balance");
				String pegi = rs.getString("game_pegi");
				String url = rs.getString("game_url");

				game = new Game(id, name, description, cover, gender, balance, pegi, url);
				games.add(game);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return games;
	}

	/*
	 * Lista todos los juegos de la base de datos que son gratis.
	 * 
	 */
	
	public List<Game> getListGameFree() {
		String SQL_SELECT = "SELECT game_id, game_name, game_description, game_cover, game_gender, game_balance, game_pegi, game_url " +
							" FROM games WHERE game_balance = 0";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Game game = null;
		List<Game> games = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("game_id");
				String name = rs.getString("game_name");
				String description = rs.getString("game_description");
				String cover = rs.getString("game_cover");
				Gender gender = Gender.valueOf(rs.getString("game_gender"));
				double balance = rs.getDouble("game_balance");
				String pegi = rs.getString("game_pegi");
				String url = rs.getString("game_url");

				game = new Game(id, name, description, cover, gender, balance, pegi, url);
				games.add(game);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return games;
	}

	/*
	 * Recupera un juego en la base de dades segun su ID.
	 * 
	 */
	public Game findById(Game game) {
		String SQL_SELECT_BY_ID = "SELECT game_id, game_name, game_description, game_cover, game_gender, game_balance, game_pegi, game_url "
				+ " FROM games WHERE game_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);

			stmt.setInt(1, game.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("game_name");
			String description = rs.getString("game_description");
			String cover = rs.getString("game_cover");
			Gender gender = Gender.valueOf(rs.getString("game_gender"));
			double balance = rs.getDouble("game_balance");
			String pegi = rs.getString("game_pegi");
			String url = rs.getString("game_url");

			game.setName(name);
			game.setDescription(description);
			game.setCover(cover);
			game.setGender(gender);
			game.setBalance(balance);
			game.setPegi(pegi);
			game.setUrl(url);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return game;
	}

	/*
	 * Crea un juego en la base de datos.
	 * 
	 */
	public int create(Game game) {
		String SQL_INSERT = "INSERT INTO games(game_name, game_description, game_cover, game_gender, game_balance, game_pegi) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDescription());
			stmt.setString(3, game.getCover());
			stmt.setString(4, game.getGender().toString());
			stmt.setDouble(5, game.getBalance());
			stmt.setString(6, game.getPegi());
			
			System.out.println(game.toString());
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
	 * Modifica un juego de la base de datos.
	 * 
	 */
	public int update(Game game) {
		String SQL_UPDATE = "UPDATE games "
				+ " SET game_name=?, game_description=?, game_cover=?, game_gender=?, game_balance=?, game_pegi=? WHERE game_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, game.getName());
			stmt.setString(i++, game.getDescription());
			stmt.setString(i++, game.getCover());
			stmt.setString(i++, game.getGender().toString());
			stmt.setDouble(i++, game.getBalance());
			stmt.setString(i++, game.getPegi());
			stmt.setInt(i++, game.getId());
			
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
	 * Borra un juego de la base de datos
	 * 
	 */
	public int delete(Game game) {
		String SQL_DELETE = "DELETE FROM games WHERE game_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, game.getId());
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
