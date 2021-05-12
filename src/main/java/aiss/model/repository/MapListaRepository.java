package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Lista;
import aiss.model.Tarea;
import aiss.model.repository.*;


public class MapListaRepository implements ListaRepository{

	Map<String, Lista> listaMap;
	Map<String, Tarea> tareaMap;
	private static MapListaRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapListaRepository getInstance() {
		
		if (instance==null) {
			instance = new MapListaRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		listaMap = new HashMap<String,Lista>();
		tareaMap = new HashMap<String,Tarea>();
		
		//para crear Lista y Tarea
		
	}
	
	// Playlist related operations
	@Override
	public void addLista(Lista p) {
		String id = "p" + index++;	
		p.setId(id);
		listaMap.put(id,p);
	}
	
	@Override
	public Collection<Lista> getAllListas() {
			return listaMap.values();
	}

	@Override
	public Lista getLista(String id) {
		return listaMap.get(id);
	}
	
	@Override
	public void updateLista(Lista p) {
		listaMap.put(p.getId(),p);
	}

	@Override
	public void deleteLista(String id) {	
		listaMap.remove(id);
	}
	

	@Override
	public void addTarea(String listaId, String tareaId) {
		Lista lista = getLista(listaId);
		lista.addSong(tareaMap.get(tareaId));
	}

	@Override
	public Collection<Tarea> getAll(String listaId) {
		return getLista(listaId).getTareas();
	}

	@Override
	public void removeTarea(String listaId, String tareaId) {
		getLista(listaId).deleteSong(tareaId);
	}

	
	// Song related operations
	
	@Override
	public void addTarea(Tarea s) {
		String id = "s" + index++;
		s.setId(id);
		tareaMap.put(id, s);
	}
	
	@Override
	public Collection<Tarea> getAllTareas() {
			return tareaMap.values();
	}

	@Override
	public Tarea getTarea(String tareaId) {
		return tareaMap.get(tareaId);
	}

	@Override
	public void updateTarea(Tarea s) {
		Tarea tarea = tareaMap.get(s.getId());
		//song.setTitle(s.getTitle());
		//song.setAlbum(s.getAlbum());
		//song.setArtist(s.getArtist());
		//song.setYear(s.getYear());
	}

	@Override
	public void deleteTarea(String tareaId) {
		tareaMap.remove(tareaId);
	}
	
}
