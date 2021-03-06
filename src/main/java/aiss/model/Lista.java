package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	private String listaId;
	private String titulo;
	private String descripcion;
	private List<Tarea> tareas;

	public Lista() {}

	public Lista(String titulo) {
		this.titulo = titulo;
	}
	
	public String getId() {
		return listaId;
	}

	public void setId(String id) {
		this.listaId = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea getTarea(String id) {
		Tarea Tarea =null;
		
		if (tareas==null)
			return null;

		for(Tarea t: tareas)
			if (t.getId().equals(id))
			{
				Tarea=t;
				break;
			}
		return Tarea;
	}

	public void addTarea(Tarea t) {
		if (tareas==null)
			tareas = new ArrayList<Tarea>();
		tareas.add(t);
	}

	public void deleteTarea(Tarea t) {
		tareas.remove(t);
	}

	public void deleteTarea(String id) {
		Tarea t = getTarea(id);
		if (t!=null)
			tareas.remove(t);
	}
}