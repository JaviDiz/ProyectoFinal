package com.store.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.store.dao.SkinDao;
import com.store.dto.Skin;
import com.store.enums.Gender;

@WebServlet("/skinClient")
public class SkinControllerClient extends HttpServlet {
	
private static final long serialVersionUID = -7558166539389234332L;

//SkinControllerClient.jsp - Es para el cliente.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "buy":
				this.buySkin(request, response);
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
			case "updateStock":
				this.updateStockSkin(request, response);
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

		// request.getRequestDispatcher("frmSkin.jsp").forward(request, response);
		response.sendRedirect("frmSkinClient.jsp");
	}

	private void buySkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idSkin
		int idSkin = Integer.parseInt(request.getParameter("idSkin"));
		Skin skin = new SkinDao().findById(new Skin(idSkin));
		request.setAttribute("skin", skin);
		String jspEditar = "/buySkin.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}
	
	// Aqui cambiamos el valor del stock.
	private void updateStockSkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Comprar skin");
		
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int idSkin = Integer.parseInt(request.getParameter("idSkin"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int total = stock - cantidad;
		System.out.println(stock);
		
		// Creamos el objeto de skin (modelo)
		Skin skin = new Skin(idSkin, total);
		System.out.println(skin);
		// Modificar el objeto en la base de datos
		int registrosModificados = new SkinDao().buy(skin);
		System.out.println("Registres modificats:" + registrosModificados);

		HttpSession session = request.getSession();
	    session.setAttribute("success", true);
	    /*session.setMaxInactiveInterval(5);*/
		
		/*Cookie cookie = new Cookie ("success","patata");
		response.addCookie(cookie);*/
		
		
		
		// Redirigimos hacia accion por default
		this.showListSkin(request, response);
	}

	

}
