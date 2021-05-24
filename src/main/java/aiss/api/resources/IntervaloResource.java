package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.protos.cloud.sql.Client;

import aiss.model.Intervalo;

public class IntervaloResource {

	private String uri = "https://lab7-313306.ew.r.appspot.com/api/lists";
	//private String uri = "http://localhost:8095/api/lists";
	

	public Collection<Intervalo> getAll() {
		
		ClientResource cr = null;
		Intervalo [] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Intervalo[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of playlists: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	
	public Intervalo getPlaylist(String playlistId) {
		
		ClientResource cr = null;
		Intervalo list = null;
		try {
			cr = new ClientResource(uri + "/" + playlistId);
			list = cr.get(Intervalo.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the playlist: " + cr.getResponse().getStatus());
		}
		
		return list;

	}
	

	public Intervalo addPlaylist(Intervalo pl) {
		
		ClientResource cr = null;
		Intervalo resultPlaylist = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultPlaylist = cr.post(pl,Intervalo.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the playlist: " + cr.getResponse().getStatus());
		}
		
		return resultPlaylist;
	}
	

	public boolean updatePlaylist(Intervalo pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the playlist: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	public boolean deletePlaylist(String playlistId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + playlistId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the playlist: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addSong(String playlistId, String songId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ playlistId+"/"+songId);
		cr.post(" ");
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when adding song to the playlist: " );
	}
			
		
		return result;
		
	}
	
	public boolean removeSong(String playlistId, String songId) {
		ClientResource cr= null;
		Boolean result= false;
	try {
		cr= new ClientResource(uri + "/"+ playlistId+"/"+songId);
		cr.delete();
		result= true;
	} catch (ResourceException re) {
		System.err.println("Error when removing song to the playlist: " + re.getStatus());
	}
		
		return result;
	}
}
