package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.protos.cloud.sql.Client;

import aiss.model.Lista;

public class ListaResource {

	private String uri = "https://organizador-restapi.ew.r.appspot.com/";
	//private String uri = "http://localhost:8095/api/lists";
	

	public Collection<Lista> getAll() {
		
		ClientResource cr = null;
		Lista [] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Lista[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of Listas: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	
	public Lista getLista(String ListaId) {
		
		ClientResource cr = null;
		Lista list = null;
		try {
			cr = new ClientResource(uri + "/" + ListaId);
			list = cr.get(Lista.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the Lista: " + cr.getResponse().getStatus());
		}
		
		return list;

	}
	

	public Lista addLista(Lista pl) {
		
		ClientResource cr = null;
		Lista resultLista = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultLista = cr.post(pl,Lista.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the Lista: " + cr.getResponse().getStatus());
		}
		
		return resultLista;
	}
	

	public boolean updateLista(Lista pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the Lista: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	public boolean deleteLista(String ListaId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + ListaId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Lista: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addTarea(String ListaId, String TareaId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ ListaId+"/"+TareaId);
		cr.post(" ");
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when adding Tarea to the Lista: " );
	}
			
		
		return result;
		
	}
	
	public boolean removeTarea(String ListaId, String TareaId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ ListaId+"/"+TareaId);
		cr.delete();
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when removing Tarea to the Lista: " + re.getStatus());
	}
		
		return result;
	}
}
