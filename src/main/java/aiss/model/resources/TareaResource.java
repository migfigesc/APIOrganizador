package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import javax.validation.constraints.AssertFalse;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Tarea;

public class TareaResource {

	private String uri = "http://organizador-restapi.ew.r.appspot.com/api/Tareas";
	//private String uri = "http://localhost:8095/api/Tareas";
//
	
	public Collection<Tarea> getAll() {
		ClientResource cr = null;
		Tarea [] Tareas = null;
		try {
			cr = new ClientResource(uri);
			Tareas = cr.get(Tarea[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all Tareas: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(Tareas);
	}
	

	public Tarea getTarea(String TareaId) {
		ClientResource cr = null;
		Tarea Tarea = null;
		try {
			cr = new ClientResource(uri + "/" + TareaId);
			Tarea = cr.get(Tarea.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlist: " + cr.getResponse().getStatus());
		}
		return Tarea;
	}
	

	public Tarea addTarea(Tarea Tarea) {
		ClientResource cr = null;
		Tarea resultTarea = null;
		try {
			cr = new ClientResource(uri);
			resultTarea = cr.post(Tarea,Tarea.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the Tarea: " + cr.getResponse().getStatus());
		}
		return resultTarea;

	}
	
	public boolean updateTarea(Tarea Tarea) {
		boolean result = false;
		ClientResource cr = null;
		try {
			cr= new ClientResource(uri);
			cr.put(Tarea);
			result= true;
	
		}catch(ResourceException re) {
			System.err.println("Error when updating the Tarea: " + cr.getResponse().getStatus());

		}
		return result;
	}
	

	public boolean deleteTarea(String TareaId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + TareaId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Tarea: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}
