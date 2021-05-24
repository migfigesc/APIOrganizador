package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Intervalo {

	private String id;
	private String fecha_in;
	private String fecha_fin;
	private List<Noche> noches;
	
	public Intervalo() {}
	
	public Intervalo(String fecha_in, String fecha_fin) {
		this.fecha_in = fecha_in;
		this.fecha_fin = fecha_fin;
	}
	
	protected void setnoches(List<Noche> s) {
		noches = s;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfecha_in() {
		return fecha_in;
	}

	public void setfecha_in(String fecha_in) {
		this.fecha_in = fecha_in;
	}

	public String getfecha_fin() {
		return fecha_fin;
	}

	public void setfecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public List<Noche> getnoches() {
		return noches;
	}
	
	public Noche getSong(String id) {
		
		if (noches==null)
			return null;
		
		Noche noche =null;
		for(Noche n: noches)
			if (n.getId().equals(id))
			{
				noche=n;
				break;
			}
		
		return noche;
	}
	
	public void addSong(Noche n) {
		if (noches==null)
			noches = new ArrayList<Noche>();
		noches.add(n);
	}
	
	public void deleteSong(Noche n) {
		noches.remove(n);
	}
	
	public void deleteSong(String id) {
		Noche n = getSong(id);
		if (n!=null)
			noches.remove(n);
	}

}
