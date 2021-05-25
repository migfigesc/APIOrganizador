package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Intervalo;

public class IntervaloResource {

	private String uri = "https://good-night-2021.ew.r.appspot.com/api/v1/intervalos";
	//private String uri = "http://localhost:8095/api/lists";
	

	public Collection<Intervalo> getAll() {
		
		ClientResource cr = null;
		Intervalo [] intervals = null;
		try {
			cr = new ClientResource(uri);
			intervals = cr.get(Intervalo[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error recuperando las colecciones de intervalos: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(intervals);
	}
	
	
	public Intervalo getIntervalo(String intervaloId) {
		
		ClientResource cr = null;
		Intervalo intervalo = null;
		try {
			cr = new ClientResource(uri + "/" + intervaloId);
			intervalo = cr.get(Intervalo.class);
			
		} catch (ResourceException re) {
			System.err.println("Error recibiendo el intervalo: " + cr.getResponse().getStatus());
		}
		
		return intervalo;

	}
	

	public Intervalo addIntervalo(Intervalo intervalo) {
		
		ClientResource cr = null;
		Intervalo resultIntervalo = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultIntervalo = cr.post(intervalo,Intervalo.class);
			
		} catch (ResourceException re) {
			System.err.println("Error añadiendo el intervalo: " + cr.getResponse().getStatus());
		}
		
		return resultIntervalo;
	}
	

	public boolean updateIntervalo(Intervalo intervalo) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(intervalo);
			
		} catch (ResourceException re) {
			System.err.println("Error actualizando el intervalo: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}	
	
	public boolean deleteIntervalo(String intervaloId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + intervaloId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error eliminando el intervalo: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addNoche(String intervaloId, String nocheId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ intervaloId+"/"+nocheId);
		cr.post(" ");
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error añadiendo la noche al intervalo: " );
	}
			
		
		return result;
		
	}
	
	public boolean removeNoche(String intervaloId, String nocheId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ intervaloId+"/"+nocheId);
		cr.delete();
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error eliminando la noche del intervalo: " + re.getStatus());
	}
		
		return result;
	}
}
