package aiss.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lista {

	private String id;
	private String nombre;
	private String descripcion;
	private Boolean completado;
	private LocalDate fechaCreacion;
	private List<Tarea> tareas;

	public Lista() {}

	public Lista(String nombre) {
		this.nombre = nombre;
		this.completado = false;
		this.fechaCreacion = LocalDate.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getCompletado() {
		return completado;
	}

	public void setCompletado(Boolean completado) {
		this.completado = completado;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	public Tarea getTarea(String id) {
		if (tareas==null)
			return null;
		
		Tarea Tarea =null;
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
		Tarea s = getTarea(id);
		if (s!=null)
			tareas.remove(s);
	}
	
}
