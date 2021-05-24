package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.protos.cloud.sql.Client;

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
			System.err.println("Error when retrieving the collections of intervals: " + cr.getResponse().getStatus());
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
			System.err.println("Error when retrieving the playlist: " + cr.getResponse().getStatus());
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
			System.err.println("Error when adding the interval: " + cr.getResponse().getStatus());
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
			System.err.println("Error when updating the playlist: " + cr.getResponse().getStatus());
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
			System.err.println("Error when deleting the interval: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addSong(String intervaloId, String nocheId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ intervaloId+"/"+nocheId);
		cr.post(" ");
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when adding song to the playlist: " );
	}
			
		
		return result;
		
	}
	
	public boolean removeSong(String intervaloId, String nocheId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ intervaloId+"/"+nocheId);
		cr.delete();
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when removing song to the playlist: " + re.getStatus());
	}
		
		return result;
	}
}
