package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Lista;
import aiss.model.Playlist;
import aiss.model.Song;
import aiss.model.Tarea;


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
		Tarea estudiar=new Tarea();
		estudiar.setTitulo("Estudiar");
		estudiar.setDescripcion("Estudiar examenes de la universidad");
		estudiar.setCategoria("Estudios");
		estudiar.setCompletado(false);
//		estudiar.setFechaVencimiento("10-10-2021 19:00");
		addTarea(estudiar);
		
		
					// Create playlists
				
					
					
					
					
					Tarea tarea=new Tarea();
					tarea.setTitulo("Smell Like Teen Spirit");
//					tarea.setFechaVencimiento("17-05-2020 08:30");
				
					addTarea(tarea);
		

	}
	
	// Lista related operations
	@Override
	public void addLista(Lista l) {
		String id = "l" + index++;	
		l.setId(id);
		listaMap.put(id,l);
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
		lista.addTarea(tareaMap.get(tareaId));
	}

	@Override
	public Collection<Tarea> getAll(String listaId) {
		return getLista(listaId).getTareas();
	}

	@Override
	public void removeTarea(String listaId, String tareaId) {
		getLista(listaId).deleteTarea(tareaId);
	}

	
	// Song related operations
	
	@Override
	public void addTarea(Tarea t) {
		String id = "t" + index++;
		t.setId(id);
		tareaMap.put(id, t);
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
		tarea.setTitulo(s.getTitulo());
		tarea.setDescripcion(s.getDescripcion());
		tarea.setCategoria(s.getCategoria());
		tarea.setCompletado(s.getCompletado());
		tarea.setFechaVencimiento(s.getFechaVencimiento().toString());
	}

	@Override
	public void deleteTarea(String tareaId) {
		tareaMap.remove(tareaId);
	}
	
	
	

	
}
