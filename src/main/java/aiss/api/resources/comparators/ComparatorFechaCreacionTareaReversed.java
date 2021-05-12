package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Tarea;

public class ComparatorFechaCreacionTareaReversed implements Comparator<Tarea> {

	@Override
	public int compare(Tarea t1, Tarea t2) {
		// TODO Auto-generated method stub
		return t2.getFechaCreacion().compareTo(t1.getFechaCreacion());
	}

}
