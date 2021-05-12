package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Song;
import aiss.model.Tarea;

public class ComparatorFechaCreacionTarea implements Comparator<Tarea>{
	@Override
	public int compare(Tarea t1, Tarea t2) {
		// TODO Auto-generated method stub
		return t1.getFechaCreacion().compareTo(t2.getFechaCreacion());
	}
}
