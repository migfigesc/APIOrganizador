package aiss.model.repository;

import java.util.Collection;

import aiss.model.Lista;
import aiss.model.Tarea;

public interface ListaRepository {
	
	
	// Songs
	public void addTarea(Tarea s);
	public Collection<Tarea> getAllTareas();
	public Tarea getTarea(String tareaId);
	public void updateTarea(Tarea s);
	public void deleteTarea(String tareaId);
	
	// Playlists
	public void addLista(Lista p);
	public Collection<Lista> getAllListas();
	public Lista getLista(String listaId);
	public void updateLista(Lista p);
	public void deleteLista(String listaId);
	public Collection<Tarea> getAll(String listaId);
	public void addTarea(String listaId, String tareaId);
	public void removeTarea(String listaId, String tareaId); 

	
	
	
	

}
