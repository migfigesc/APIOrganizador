package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Intervalo {

	private String id;
	private String name;
	private String description;
	private List<Noche> songs;
	
	public Intervalo() {}
	
	public Intervalo(String name) {
		this.name = name;
	}
	
	public Intervalo(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	protected void setSongs(List<Noche> s) {
		songs = s;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Noche> getSongs() {
		return songs;
	}
	
	public Noche getSong(String id) {
		
		if (songs==null)
			return null;
		
		Noche song =null;
		for(Noche s: songs)
			if (s.getId().equals(id))
			{
				song=s;
				break;
			}
		
		return song;
	}
	
	public void addSong(Noche s) {
		if (songs==null)
			songs = new ArrayList<Noche>();
		songs.add(s);
	}
	
	public void deleteSong(Noche s) {
		songs.remove(s);
	}
	
	public void deleteSong(String id) {
		Noche s = getSong(id);
		if (s!=null)
			songs.remove(s);
	}

}
