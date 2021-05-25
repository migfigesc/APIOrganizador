package aiss.controller;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.api.resources.ListaResource;


/**
 * Servlet implementation class ListaAddTareaController
 */
public class ListaAddTareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ListaAddTareaController.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaAddTareaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String tareaId = request.getParameter("tareaId");
		String listaId = request.getParameter("listaId");
				
		// Add song to playlist
		ListaResource lr = new ListaResource();
		boolean success =lr.addTarea(null, listaId, tareaId);
		
		if (success) {
			request.setAttribute("message", "Song added successfully");
			log.log(Level.FINE, "Song with id=" + songId + " added to playlist with id=" + playlistId + ". Forwarding to playlist list view.");
		}
		else {
			request.setAttribute("message", "The song could not be added");
			log.log(Level.FINE, "The song with id=" + songId + " could not be added to the playlist with id=" + playlistId + ". Perhaps it is duplicated. Forwarding to playlist list view.");
		}
		
		// Forward to contact list view
		request.getRequestDispatcher("/list?playlistId=" + playlistId).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
