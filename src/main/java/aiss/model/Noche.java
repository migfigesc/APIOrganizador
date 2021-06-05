package aiss.model;

public class Noche {

	private String id;
	private String fecha_suenyo;
	private TipoSuenyo tipo_suenyo;
	private CalidadSuenyo calidadsuenyo;
	private EstadoAnimo estado_animo;
	private Integer hora_in;
	private Integer hora_fin;

	public Noche() {
	}



	public Noche(String id, String fecha_suenyo, TipoSuenyo tipo_suenyo, CalidadSuenyo calidadsuenyo,
			EstadoAnimo estado_animo, Integer hora_in, Integer hora_fin) {
		super();
		this.id = id;
		this.fecha_suenyo = fecha_suenyo;
		this.tipo_suenyo = tipo_suenyo;
		this.calidadsuenyo = calidadsuenyo;
		this.estado_animo = estado_animo;
		this.hora_in = hora_in;
		this.hora_fin = hora_fin;
	}



	public Noche( String fecha_suenyo, TipoSuenyo tipo_suenyo, CalidadSuenyo calidadsuenyo,
			EstadoAnimo estado_animo, Integer hora_in, Integer hora_fin) {
		super();

		this.fecha_suenyo = fecha_suenyo;
		this.tipo_suenyo = tipo_suenyo;
		this.calidadsuenyo = calidadsuenyo;
		this.estado_animo = estado_animo;
		this.hora_in = hora_in;
		this.hora_fin = hora_fin;
	}






	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFecha_suenyo() {
		return fecha_suenyo;
	}



	public void setFecha_suenyo(String fecha_suenyo) {
		this.fecha_suenyo = fecha_suenyo;
	}



	public TipoSuenyo getTipo_suenyo() {
		return tipo_suenyo;
	}



	public void setTipo_suenyo(TipoSuenyo tipo_suenyo) {
		this.tipo_suenyo = tipo_suenyo;
	}



	public CalidadSuenyo getCalidadsuenyo() {
		return calidadsuenyo;
	}



	public void setCalidadsuenyo(CalidadSuenyo calidadsuenyo) {
		this.calidadsuenyo = calidadsuenyo;
	}



	public EstadoAnimo getEstado_animo() {
		return estado_animo;
	}



	public void setEstado_animo(EstadoAnimo estado_animo) {
		this.estado_animo = estado_animo;
	}



	public Integer getHora_in() {
		return hora_in;
	}



	public void setHora_in(Integer hora_in) {
		this.hora_in = hora_in;
	}



	public Integer getHora_fin() {
		return hora_fin;
	}



	public void setHora_fin(Integer hora_fin) {
		this.hora_fin = hora_fin;
	}
	
}