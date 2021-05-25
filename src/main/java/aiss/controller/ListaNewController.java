package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Lista;
import aiss.model.resources.ListaResource;

/**
 * Servlet implementation class PlaylistNewController
 */
public class ListaNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ListaNewController.class.getName());
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String name = request.getParameter("name");

		// Add playlist
		ListaResource lr = new ListaResource();
		Lista lista = lr.addLista(new Lista(name));

		// Log
		log.log(Level.FINE, "Nueva solicitud de lista. Nombre=" + name + ". Reenvío a la vista de listas.");

		// Forward to contact list view
		request.setAttribute("mensaje", "Lista creada correctamente");
		request.getRequestDispatcher("/lista/" + lista.getId()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
