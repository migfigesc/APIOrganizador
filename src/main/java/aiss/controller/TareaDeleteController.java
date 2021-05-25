package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Playlist;
import aiss.model.resources.ListaResource;
import aiss.model.resources.PlaylistResource;

/**
 * Servlet implementation class ContactDeleteController
 */
public class TareaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(TareaUpdateController.class.getName());
	
    public TareaDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Request data
		String tareaId = request.getParameter("tareaId");
		String listaId = request.getParameter("listaId");
		
		// Validate data
		if (tareaId==null) {
			log.log(Level.SEVERE, "Error deleting Tarea. Null id ");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			return;
		}
		
		// Log
		log.log(Level.FINE, "Deleting Tarea with id " + tareaId);
		
		// Delete Tarea
		ListaResource plr = new ListaResource();
		plr.removeTarea(listaId, tareaId);
		
		// Forward to contact list view
		request.setAttribute("message", "Tarea deleted successfully");
		request.getRequestDispatcher("/list").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
