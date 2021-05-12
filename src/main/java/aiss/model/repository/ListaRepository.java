package aiss.model.repository;

import java.util.Collection;

import aiss.model.Lista;
import aiss.model.Tarea;

public interface ListaRepository {
	
	
	// Tareas
	public void addTarea(Tarea s);
	public Collection<Tarea> getAllTareas();
	public Tarea getTarea(String tareaId);
	public void updateTarea(Tarea t);
	public void deleteTarea(String tareaId);
	
	// Listas
	public void addLista(Lista p);
	public Collection<Lista> getAllListas();
	public Lista getLista(String listaId);
	public void updateLista(Lista l);
	public void deleteLista(String listaId);
	public Collection<Tarea> getAll(String listaId);
	public void addTarea(String listaId, String tareaId);
	public void removeTarea(String listaId, String tareaId); 

	
	
	
	

}
