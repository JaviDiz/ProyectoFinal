package com.store.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.store.dao.SkinDao;
import com.store.dto.Skin;
import com.store.enums.Gender;

@WebServlet("/skin")
public class SkinController extends HttpServlet {
	
private static final long serialVersionUID = -7558166539389234332L;
	
//SkinController.jsp - Es para el administrador.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.editSkin(request, response);
				break;
			default:
				this.showListSkin(request, response);
			}
		} else {
			this.showListSkin(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				this.deleteSkin(request, response);
				break;
			case "insert":
				this.insertSkin(request, response);
				break;
			case "update":
				this.updateSkin(request, response);
				break;
			default:
				this.showListSkin(request, response);
			}
		} else {
			this.showListSkin(request, response);
		}
	}

	private void showListSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Skin> skins = new SkinDao().listar();

		System.out.println("skins = " + skins);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("skins", skins);
		session.setAttribute("totalSkins", skins.size());
		session.setAttribute("saldoTotal", this.calcularSaldoTotal(skins));

		// request.getRequestDispatcher("frmSkin.jsp").forward(request, response);
		response.sendRedirect("frmSkin.jsp");
	}

	private void editSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idSkin
		int idSkin = Integer.parseInt(request.getParameter("idSkin"));
		Skin skin = new SkinDao().findById(new Skin(idSkin));
		request.setAttribute("skin", skin);
		String jspEditar = "/editSkin.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}


	private void insertSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarSkin
		String name = request.getParameter("name");
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		String cover = request.getParameter("cover");
		
		int gameId = Integer.parseInt(request.getParameter("gameId"));
;
		// Creamos el objeto de skin (modelo)
		Skin skin = new Skin(name, saldo, stock, cover, gameId);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new SkinDao().create(skin);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListSkin(request, response);
	}


	private void updateSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar skin");
		
		// Recuperam els valors del formulari editSkin
		int idSkin = Integer.parseInt(request.getParameter("idSkin"));
		String name = request.getParameter("name");
		System.out.println("Nombre:" + name);
		
		double saldo = 0;
		String saldoString = request.getParameter("saldo");
		if (saldoString != null && !"".equals(saldoString)) {
			saldo = Double.parseDouble(saldoString);
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		String cover = request.getParameter("cover");
		int gameId = Integer.parseInt(request.getParameter("gameId"));
		
		
		// Creamos el objeto de skin (modelo)
		Skin skin = new Skin(idSkin, name, saldo, stock, cover, gameId);

		// Modificar el objeto en la base de datos
		int registrosModificados = new SkinDao().update(skin);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListSkin(request, response);
	}

	private void deleteSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarSkin
		int idSkin = Integer.parseInt(request.getParameter("idSkin"));

		// Creamos el objeto de skin (modelo)
		Skin skin = new Skin(idSkin);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new SkinDao().delete(skin);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListSkin(request, response);
	}
	
	private double calcularSaldoTotal(List<Skin> skins) {
		double saldoTotal = 0;
		for (Skin skin : skins) {
			saldoTotal += skin.getPrice();
		}
		return saldoTotal;
	}

}
