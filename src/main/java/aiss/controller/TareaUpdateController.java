package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Tarea;
import aiss.model.resources.TareaResource;


/**
 * Servlet implementation class DeleteContactController
 */
public class TareaUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(TareaUpdateController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TareaUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Request data
		String tareaId = request.getParameter("tareaId");
		String listaId = request.getParameter("listaId");
		String operation = request.getParameter("operation");
		
		// Tarea resource
		TareaResource sr = new TareaResource();

		// Load tarea being updated
		Tarea tarea = sr.getTarea(tareaId);

		// Display update form with tarea data on it
		if (operation == null) {

			// Log
			log.log(Level.FINE, "Petición actualizada por contacto a id " + tareaId + " (nombre=" + tarea.getTitulo() + "). Cambiando a editar la vista.");

			// Forward to edit view
			RequestDispatcher rd = request.getRequestDispatcher("/tareaEditView.jsp?playlistId=" + listaId);
			request.setAttribute("tarea", tarea);
			rd.forward(request, response);

		} else {			
			
			// Update tarea
			String id = request.getParameter("id");
			String titulo = request.getParameter("titulo");
			String descripcion = request.getParameter("descripcion");
			String categoria = request.getParameter("categoria");
			String completado = request.getParameter("completado");
			String fechaVencimiento = request.getParameter("fechaVencimiento");
			
			tarea.setId(id);
			tarea.setTitulo(titulo);
			tarea.setDescripcion(descripcion);
			tarea.setCategoria(categoria);
			tarea.setCompletado(Boolean.valueOf(completado));
			tarea.setFechaVencimiento(fechaVencimiento);
			
			sr.updateTarea(tarea);
			
			// Log
			log.log(Level.FINE, "Update request. Id=" + tarea.getId() + ", Titulo= " + tarea.getTitulo() + ", Descripcion= " + tarea.getDescripcion() + ", Categoria= " + tarea.getCategoria() 
			+", Completado"+ tarea.getCompletado() + ", FechaVencimiento" + tarea.getFechaVencimiento() + ". Forwarding to contact list view.");

			// Forward to tarea list view
			request.setAttribute("message", "la tarea se ha actualizado con éxito");
			request.getRequestDispatcher("/lista").forward(request, response);
				
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
