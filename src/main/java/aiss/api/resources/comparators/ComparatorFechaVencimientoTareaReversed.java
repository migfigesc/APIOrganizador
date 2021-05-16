package aiss.api.resources.comparators;

import java.util.Comparator;

import com.google.appengine.repackaged.org.joda.time.DateTime;

import aiss.model.Tarea;


public class ComparatorFechaVencimientoTareaReversed implements Comparator<Tarea> {
	
	
	public int compare(Tarea t1, Tarea t2) {
		// TODO Auto-generated method stub
		DateTime dt1=DateTime.parse(t1.getFechaVencimiento());
		DateTime dt2=DateTime.parse(t2.getFechaVencimiento());

		
		return dt2.compareTo(dt1);
	}


}
