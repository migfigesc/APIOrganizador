package aiss.model;

import java.time.LocalDate;

public class Tarea {
	
	private String id;
	private String titulo;
	private String descripcion;
	private String categoria;
	private Boolean completado;
	private LocalDate fechaCreacion;
	private LocalDate fechaVencimiento;

	public Tarea() {
	}

	public Tarea(String titulo, String descripcion, String categoria, Boolean completado, LocalDate fechaVencimiento) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.completado = completado;
		this.fechaCreacion = LocalDate.now();
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public Tarea(String id, String titulo, String descripcion, String categoria, Boolean completado, LocalDate fechaVencimiento) {
		this.id=id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.completado = completado;
		this.fechaCreacion = LocalDate.now();
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
