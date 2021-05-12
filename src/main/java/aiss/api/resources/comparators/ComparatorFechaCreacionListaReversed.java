package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Lista;

public class ComparatorFechaCreacionListaReversed implements Comparator<Lista>{
	
	@Override
	public int compare(Lista l1, Lista l2) {
		// TODO Auto-generated method stub
		return l2.getFechaCreacion().compareTo(l1.getFechaCreacion());
	}

}
