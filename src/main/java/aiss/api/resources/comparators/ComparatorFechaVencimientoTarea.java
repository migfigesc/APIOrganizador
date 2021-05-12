package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Tarea;

public class ComparatorFechaVencimientoTarea implements Comparator<Tarea> {
	
	
	public int compare(Tarea t1, Tarea t2) {
		// TODO Auto-generated method stub
		return t1.getFechaVencimiento().compareTo(t2.getFechaVencimiento());
	}

}
