package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Noche;

public class NochesResource {

	private String uri = "https://good-night-2021.ew.r.appspot.com/api/v1/noches";

	
	public Collection<Noche> getAll() {
		ClientResource cr = null;
		Noche [] noches = null;
		try {
			cr = new ClientResource(uri);
			noches = cr.get(Noche[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all noches: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(noches);
	}
	

	public Noche getNoche(String nocheId) {
		ClientResource cr = null;
		Noche noche = null;
		try {
			cr = new ClientResource(uri + "/" + nocheId);
			noche = cr.get(Noche.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al recuperar la noche: " + cr.getResponse().getStatus());
		}
		return noche;
	}
	

	public Noche addNoche(Noche noche) {
		ClientResource cr = null;
		Noche resultadoNoche = null;
		try {
			cr = new ClientResource(uri);
			resultadoNoche = cr.post(noche,Noche.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al añadir la noche: " + cr.getResponse().getStatus());
		}
		return resultadoNoche;

	}
	
	public boolean updateNoche(Noche noche) {
		boolean result = false;
		ClientResource cr = null;
		try {
			cr= new ClientResource(uri);
			cr.put(noche);
			result= true;
	
		}catch(ResourceException re) {
			System.err.println("Error al actualizar la noche: " + cr.getResponse().getStatus());

		}
		return result;
	}
	

	public boolean deleteNoche(String nocheId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + nocheId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error al eluminar la ncohe: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}
