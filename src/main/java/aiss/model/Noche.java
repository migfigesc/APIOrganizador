package aiss.model;

public class Noche {
	private String id;
	private String fecha_suenyo;
	private Tipo_sueno tipo_sueno;
	private Calidad calidad_suenyo;
	private Animo estado_animo;
	private Integer hora_in;
	private Integer hora_fin;
	private Integer duracion;
	
	public Noche() {}
	
	public Noche(String fecha, Tipo_sueno t_suen, Calidad calidad, Animo animo, Integer HIn, Integer HFin) {
		this.fecha_suenyo=fecha;
		this.tipo_sueno=t_suen;
		this.calidad_suenyo=calidad;
		this.estado_animo=animo;
		this.hora_in=HIn;
		this.hora_fin=HFin;
		 this.duracion=this.getDuracion();

	}
	
	public Noche(String id,String fecha, Tipo_sueno t_suen, Calidad calidad, Animo animo, Integer HIn, Integer HFin) {
		this.id=id;
		this.fecha_suenyo=fecha;
		this.tipo_sueno=t_suen;
		this.calidad_suenyo=calidad;
		this.estado_animo=animo;
		this.hora_in=HIn;
		this.hora_fin=HFin;
		 this.duracion=this.getDuracion();
		
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

	public Tipo_sueno getTipo_suenyo() {
		return tipo_sueno;
	}

	public void setTipo_suenyo(Tipo_sueno tipo_suenyo) {
		this.tipo_sueno = tipo_suenyo;
	}
	
	

	public Calidad getCalidad_suenyo() {
		return calidad_suenyo;
	}

	public void setCalidad_suenyo(Calidad calidad_suenyo) {
		this.calidad_suenyo = calidad_suenyo;
	}

	public Animo getEstado_animo() {
		return estado_animo;
	}

	public void setEstado_animo(Animo estado_animo) {
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
	
public Integer getDuracion() {
	if (getHora_in()==null || getHora_fin()==null) {
		throw new NullPointerException("No puede existir una noche con hora inicial o final nulas");
	}
	Integer res=null;
	if(getHora_in()>getHora_fin()) {
		res=24-getHora_in() + getHora_fin();
	}else {
		res=getHora_fin()-getHora_in();
	}
	return res;
		
	}

}