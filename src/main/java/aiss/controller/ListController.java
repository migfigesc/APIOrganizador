package aiss.controller;

import java.io.IOException;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.Lista;
import aiss.model.Tarea;
import aiss.model.resources.ListaResource;
import aiss.model.resources.TareaResource;



public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(ListController.class.getName());
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Load all Lista
		TareaResource tr = new TareaResource();
		Collection<Tarea> tareas = tr.getAll();
		
		
		// Load all Listas
		ListaResource lr = new ListaResource();
		Collection<Lista> listas = lr.getAll();
			
		// Get selected Lista
		String id = request.getParameter("ListaId");
		log.log(Level.FINE, "Id=" + id);
		
		Lista Lista=null;
		if (id!=null)	// Load the Lista with the id received as a parameter
			Lista = lr.getLista(id);
		else if (id==null && !listas.isEmpty())	{// No Lista selected, show the first one
			Lista = (Lista) listas.toArray()[0];
			id=Lista.getId();
		}
		
		if (Lista==null) {
			request.setAttribute("mensaje", "Lista no encontrada");
			log.log(Level.FINE, "Lista no encontrada");	
		} else
			log.log(Level.FINE, "Lista con id " + id + " cargada.");
		
		// Forward to lista view
		request.setAttribute("tareas", tareas);
		request.setAttribute("ltareas", Lista.getTareas());
		request.setAttribute("listas", listas);
		request.setAttribute("listaId", id);	// id of the selected Lista
		request.getRequestDispatcher("/listaView.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
