package aiss.api.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resources.comparators.ComparatorFechaCreacionLista;
import aiss.api.resources.comparators.ComparatorFechaCreacionListaReversed;
import aiss.api.resources.comparators.ComparatorNamePlayList;
import aiss.api.resources.comparators.ComparatorNamePlayListReversed;
import aiss.api.resources.comparators.ComparatorNombreLista;
import aiss.model.Lista;
import aiss.model.Playlist;
import aiss.model.Song;
import aiss.model.Tarea;
import aiss.model.repository.ListaRepository;
import aiss.model.repository.MapListaRepository;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;


@Path("/lists")
public class ListaResource {
	
	/* Singleton */
	private static ListaResource _instance=null;
	ListaRepository repository;
	
	private ListaResource() {
		repository=MapListaRepository.getInstance();

	}
	
	public static ListaResource getInstance()
	{
		if(_instance==null)
				_instance=new ListaResource();
		return _instance;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Lista> getAll(@QueryParam("order") String order,@QueryParam("isEmpty") Boolean isEmpty,
			@QueryParam("name") String name, @QueryParam("q") String q,@QueryParam("limit") Integer limit,@QueryParam("offset") Integer offset){
		
		List<Lista> result= new ArrayList<Lista>();
		
		if(offset==(null) || offset>repository.getAllListas().size()) {
			offset=0;
		}
		if(limit==(null) || limit>repository.getAllListas().size()) {
			limit=repository.getAllListas().size();
		}
		
		int i=0;
		int j=0;
		
		for(Lista lista : repository.getAllListas()) {
			if(j>=offset && i<limit) {
				if( q == null || lista.getNombre().contains(q) || lista.getDescripcion().contains(q) ){
					i++;
					result.add(lista);
				}
			}
			j++;
		}
		
		for(Lista lista: repository.getAllListas()) {
			if(name == null || lista.getNombre().equals(name)) {
				if(isEmpty== null
					|| (isEmpty && (lista.getTareas() == null || lista.getTareas().size() == 0))
					|| (!isEmpty && (lista.getTareas() != null || lista.getTareas().size() > 0))){
					result.add(lista);
				}
			}
		}

		if(order!=null) {
			if(order.equals("nombre")) {
				Collections.sort(result, new ComparatorNombreLista());
			}else if(order.equals("fc")) {
				Collections.sort(result, new ComparatorFechaCreacionLista());
			}else if(order.equals("-fc")) {
				Collections.sort(result, new ComparatorFechaCreacionListaReversed());
			}
			else {
				throw new BadRequestException("El parámetro para ordenar debe ser 'nombre' o 'fc'.");
			}
		}	
		return result;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Playlist get(@PathParam("id") String id)
	{
		Playlist list = repository.getPlaylist(id);
		
		if (list == null) {
			throw new NotFoundException("The playlist with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addPlaylist(@Context UriInfo uriInfo, Playlist playlist) {
		if (playlist.getName() == null || "".equals(playlist.getName()))
			throw new BadRequestException("The name of the playlist must not be null");
		
		if (playlist.getSongs()!=null)
			throw new BadRequestException("The songs property is not editable.");

		repository.addPlaylist(playlist);

		// Builds the response. Returns the playlist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(playlist.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(playlist);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updatePlaylist(Playlist playlist) {
		Playlist oldplaylist = repository.getPlaylist(playlist.getId());
		if (oldplaylist == null) {
			throw new NotFoundException("The playlist with id="+ playlist.getId() +" was not found");			
		}
		
		if (playlist.getSongs()!=null)
			throw new BadRequestException("The songs property is not editable.");
		
		// Update name
		if (playlist.getName()!=null)
			oldplaylist.setName(playlist.getName());
		
		// Update description
		if (playlist.getDescription()!=null)
			oldplaylist.setDescription(playlist.getDescription());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeLista(@PathParam("id") String id) {
		Lista toberemoved=repository.getLista(id);
		if (toberemoved == null)
			throw new NotFoundException("La lista con id="+ id +" no se encuentra");
		else
			repository.deleteLista(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{listaid}/{tareaid}")
	@Consumes("text/plain")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo,@PathParam("listaid") String listaid, @PathParam("tareaid") String tareaid)
	{				
		
		Lista lista = repository.getLista(listaid);
		Tarea tarea = repository.getTarea(tareaid);
		
		if (lista==null)
			throw new NotFoundException("La lista con id=" + listaid + " no se encuentra");
		
		if (tarea == null)
			throw new NotFoundException("La tarea con id=" + tareaid + " no se encuentra");
		
		if (lista.getTarea(tareaid)!=null)
			throw new BadRequestException("La tarea ya está incluida en la lista");
			
		repository.addTarea(listaid, tareaid);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(listaid);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(lista);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{lista}/{tarea}")
	public Response removeSong(@PathParam("listaid") String listaid, @PathParam("tareaid") String tareaid) {
		Lista lista = repository.getLista(listaid);
		Tarea tarea = repository.getTarea(tareaid);
		
		if (lista==null)
			throw new NotFoundException("La lista con id =" + listaid + " no se encuentra");
		
		if (tarea == null)
			throw new NotFoundException("La tarea con id =" + tareaid + " no se encuentra");
		
		
		repository.removeTarea(listaid, tareaid);		
		
		return Response.noContent().build();
	}
}