package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Tarea;
import aiss.model.resources.ListaResource;
import aiss.model.resources.TareaResource;


/**
 * Servlet implementation class ContactNewController
 */
public class TareaNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(TareaUpdateController.class.getName());
	
    public TareaNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Request data
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		String fechaVencimiento = request.getParameter("fechaVencimiento");
		String ubicacion = request.getParameter("ubicacion");
		String listaId = request.getParameter("listaId");
		
		// Create tarea
		TareaResource tr = new TareaResource();
		Tarea tarea = tr.addTarea(new Tarea(titulo, categoria, fechaVencimiento, ubicacion));
		
		// Add Tarea to the playlist
		ListaResource plr = new ListaResource();
		plr.addTarea(listaId, tarea.getId());

		// Log
		log.log(Level.FINE, "Nueva petición de tarea. titulo=" + titulo + ", categoria= " + categoria + ", fechaVencimiento= " + fechaVencimiento + ", ubicacion= " + ubicacion +". Cambiando a la vista de lista.");

		// Forward to contact list view
		request.setAttribute("mensaje", "Tarea creada correctamente");
		request.setAttribute("listaId", listaId);
		request.getRequestDispatcher("/lista").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
