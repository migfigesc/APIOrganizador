package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Lista;

public class ComparatorTituloListaReversed implements Comparator<Lista>{
	
	public int compare(Lista l1, Lista l2) {
		// TODO Auto-generated method stub
		return l2.getNombre().compareTo(l1.getNombre());
	}
	
	
	

}
