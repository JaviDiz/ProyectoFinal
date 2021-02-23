package com.store.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.store.dao.GameDao;
import com.store.dto.Game;
import com.store.enums.Gender;

@WebServlet("/game")
public class GameController extends HttpServlet {
	
private static final long serialVersionUID = -7558166539389234332L;
	
// GameController.jsp - Es para el administrador.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.editGame(request, response);
				break;
			case "listFree":
				this.showListGameFree(request, response);
				break;
			default:
				this.showListGame(request, response);
			}
		} else {
			this.showListGame(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				this.deleteGame(request, response);
				break;
			case "insert":
				this.insertGame(request, response);
				break;
			case "update":
				this.updateGame(request, response);
				break;
			default:
				this.showListGame(request, response);
			}
		} else {
			this.showListGame(request, response);
		}
	}

	private void showListGameFree(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Game> games = new GameDao().getListGameFree();

		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("games", games);
		session.setAttribute("totalGames", games.size());
		session.setAttribute("saldoTotal", this.calcularSaldoTotal(games));

		response.sendRedirect("frmGame.jsp");
	}

	private void showListGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Game> games = new GameDao().listar();

		System.out.println("games = " + games);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("games", games);
		session.setAttribute("totalGames", games.size());
		session.setAttribute("saldoTotal", this.calcularSaldoTotal(games));

		// request.getRequestDispatcher("frmGame.jsp").forward(request, response);
		response.sendRedirect("frmGame.jsp");
	}

	private void editGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idGame
		int idGame = Integer.parseInt(request.getParameter("idGame"));
		Game game = new GameDao().findById(new Game(idGame));
		request.setAttribute("game", game);
		String jspEditar = "/editGame.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}

	private void insertGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarGame
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String cover = request.getParameter("cover");
		Gender gender = Gender.valueOf(request.getParameter("gender"));
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}
		String pegi = request.getParameter("pegi");

		// Creamos el objeto de game (modelo)
		Game game = new Game(name, description, cover, gender, saldo, pegi);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new GameDao().create(game);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListGame(request, response);
	}

	private void updateGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar game");
		
		// Recuperam els valors del formulari editGame
		int idGame = Integer.parseInt(request.getParameter("idGame"));
		String name = request.getParameter("name");
		System.out.println("Nombree:" + name);
		
		String description = request.getParameter("description");
		String cover = request.getParameter("cover");
		Gender gender = Gender.valueOf(request.getParameter("gender"));
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}
		String pegi = request.getParameter("pegi");
		
		System.out.println(gender);
		
		// Creamos el objeto de game (modelo)
		Game game = new Game(idGame, name, description, cover, gender, saldo, pegi);
		
		System.out.println(game);

		// Modificar el objeto en la base de datos
		int registrosModificados = new GameDao().update(game);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListGame(request, response);
	}

	private void deleteGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarGame
		int idGame = Integer.parseInt(request.getParameter("idGame"));

		// Creamos el objeto de game (modelo)
		Game game = new Game(idGame);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new GameDao().delete(game);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListGame(request, response);
	}
	
	private double calcularSaldoTotal(List<Game> games) {
		double saldoTotal = 0;
		for (Game game : games) {
			saldoTotal += game.getBalance();
		}
		return saldoTotal;
	}

}
