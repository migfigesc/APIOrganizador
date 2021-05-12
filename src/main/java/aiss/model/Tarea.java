package aiss.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarea {
	
	private String id;
	private String titulo;
	private String descripcion;
	private String categoria;
	private Boolean completado;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaVencimiento;

	public Tarea() {
	}

	public Tarea(String titulo, String categoria, String fechaVencimiento) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.completado = false;
		this.fechaCreacion = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime vencimientoFormat = LocalDateTime.parse(fechaVencimiento, formatter);
		this.fechaVencimiento = vencimientoFormat;
	}
	
	public Tarea(String id, String titulo, String categoria, String fechaVencimiento) {
		this.id=id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.completado = false;
		this.fechaCreacion = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime vencimientoFormat = LocalDateTime.parse(fechaVencimiento, formatter);
		this.fechaVencimiento = vencimientoFormat;
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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
