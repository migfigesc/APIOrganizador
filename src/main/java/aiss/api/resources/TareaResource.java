package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.api.resources.comparators.ComparatorAlbumSong;
import aiss.api.resources.comparators.ComparatorNamePlayList;
import aiss.api.resources.comparators.ComparatorNamePlayListReversed;
import aiss.api.resources.comparators.ComparatorNameSong;
import aiss.api.resources.comparators.ComparatorYearSong;
import aiss.model.Lista;
import aiss.model.Tarea;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



@Path("/songs")
public class TareaResource {

	public static TareaResource _instance=null;
	PlaylistRepository repository;
	
	private TareaResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static TareaResource getInstance()
	{
		if(_instance==null)
			_instance=new TareaResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Tarea> getAll(@QueryParam("order") String order,@QueryParam("isEmpty") Boolean isEmpty,
			@QueryParam("q") String q,@QueryParam("limit") Integer limit,@QueryParam("offset") Integer offset )
	{
		
		List<Tarea> result= new ArrayList<Tarea>();
		
		if(offset==(null) || offset>repository.getAllSongs().size()) {
			offset=0;
		}
		if(limit==(null) || limit>repository.getAllSongs().size()) {
			limit=repository.getAllSongs().size();
		}

		
		int i=0;
		int j=0;
		for(Song song : repository.getAllSongs()) {
			
			if(j>=offset && i<limit) {
				
			
			
				if( q == null || song.getTitle().contains(q)||
						song.getArtist().contains(q)||
						song.getAlbum().contains(q)) {
					
					i++;
					
						result.add(song);
				
			}
				}
			
			j++;
		}
		
		if(order!=null) {
			if(order.equals("name")) {
				Collections.sort(result, new ComparatorNameSong());
			}else if(order.equals("album")) {
				Collections.sort(result, new ComparatorAlbumSong());
			}else if(order.equals("year")) {
				
				Collections.sort(result, new ComparatorYearSong());

				

			}else {
				throw new BadRequestException("The order parameter must be a 'name' or 'year' or 'album'");
			}
			
		
		
		}
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Song get(@PathParam("id") String songId)
	{
		
		Song list = repository.getSong(songId);
		
		if (list == null) {
			throw new NotFoundException("The song with id="+ songId +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Song song) {
		if (song.getTitle() == null || "".equals(song.getTitle()))
			throw new BadRequestException("The name of the song must not be null");
		
	

		repository.addSong(song);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(song.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(song);			
		return resp.build();
	}


	

	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Song song) {
		Song oldSong = repository.getSong(song.getId());
		if (oldSong == null) {
			throw new NotFoundException("The song with id="+ song.getId() +" was not found");			
		}
		
		
		
		// Update title
		if (song.getTitle()!=null)
			oldSong.setTitle(song.getTitle());
		
		// Update Artist
		if (song.getArtist()!=null)
			oldSong.setArtist(song.getArtist());
		
		//Update Year
		if (song.getYear()!=null)
			oldSong.setYear(song.getYear());
		
		//Update Album
			if (song.getAlbum()!=null)
				oldSong.setAlbum(song.getAlbum());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String songId) {
		
		Song toberemoved=repository.getSong(songId);
		if (toberemoved == null)
			throw new NotFoundException("The song with id="+ songId +" was not found");
		else
			repository.deleteSong(songId);
		
		return Response.noContent().build();
	}
	
}
