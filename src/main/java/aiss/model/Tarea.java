package aiss.model;

public class Tarea {
	
	private String tareaId;
	private String titulo;
	private String descripcion;
	private String categoria;
	private Boolean completado;
	private String fechaVencimiento;
	private String ubicacion;

	public Tarea() {
	}

	public Tarea(String titulo, String categoria, String fechaVencimiento, String ubicacion) {
		this.titulo = titulo;
		this.categoria = categoria;
		this.completado = false;
      
		this.fechaVencimiento = fechaVencimiento;
		this.ubicacion=ubicacion;
	}
	
	public Tarea(String id, String titulo, String categoria, String fechaVencimiento, String ubicacion) {
		this.tareaId=id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.completado = false;

     
		this.fechaVencimiento = fechaVencimiento;
		this.ubicacion=ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getId() {
		return tareaId;
	}

	public void setId(String id) {
		this.tareaId = id;
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

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
	
		this.fechaVencimiento = fechaVencimiento;
	}

}
