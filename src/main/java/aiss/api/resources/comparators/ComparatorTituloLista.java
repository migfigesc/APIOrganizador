package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Lista;

public class ComparatorTituloLista implements Comparator<Lista>{
	
	public int compare(Lista l1, Lista l2) {
		// TODO Auto-generated method stub
		return l1.getNombre().compareTo(l2.getNombre());
	}
	
	
	

}
