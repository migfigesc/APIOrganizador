package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import aiss.api.resources.IntervaloResource;
import aiss.model.Intervalo;
import aiss.model.Noche;
import aiss.api.resources.NochesResource;

public class IntervaloResourceTest {

	static Intervalo intervalo, intervalo2, intervalo3, intervalo4;
	static Noche noche;
	static IntervaloResource ivr = new IntervaloResource();
	static NochesResource nr = new NochesResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		intervalo = ivr.addIntervalo(new Intervalo("27/05/2021","28/05/2021"));
		intervalo2 = ivr.addIntervalo(new Intervalo("25/05/2021","26/05/2021"));
		intervalo3 = ivr.addIntervalo(new Intervalo("29/05/2021","30/05/2021"));
		
		
	
		noche = nr.addNoche(new Noche());
		if(noche!=null)
			ivr.addIntervalo(new Intervalo());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		ivr.deleteIntervalo(intervalo.getId());
		ivr.deleteIntervalo(intervalo3.getId());
		ivr.deleteIntervalo(intervalo4.getId());
		if(noche!=null)
			nr.deleteNoche(noche.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Intervalo> intervalos = ivr.getAll(); 
		
		assertNotNull("The collection of playlists is null", intervalos);
		
		// Show result
		System.out.println("Listing all intervalos:");
		int i=1;
		for (Intervalo iv : intervalos) {
			System.out.println("Intervalo " + i++ + " : " + " (ID=" + iv.getId() + ")");
		}
		
	}

	@Test
	public void testGetIntervalo() {
		Intervalo i = ivr.getIntervalo(intervalo.getId());
		
		assertEquals("El Id de los intervalos no coincide", intervalo.getId(), i.getId());
		assertEquals("Las fechas de inicio no coinciden", intervalo.getfecha_in(), i.getfecha_in());
		
		// Show result
		System.out.println("Id del Intervalo: " +  i.getId());
		System.out.println("Fecha de Inicio: " +  i.getfecha_in());

	}

	@Test
	public void testAddIntervalo() {
		String fechaIn = "25/05/2021";
		String fechaFin = "26/05/2021";
		
		intervalo4 = ivr.addIntervalo(new Intervalo(fechaIn,fechaFin));
		
		assertNotNull("Error al añadir el intervalo.", intervalo4);
		assertEquals("La fecha de inicio no se ha introducido correctamente.", fechaIn, intervalo4.getfecha_in());
		assertEquals("La fecha final no se ha introducido correctamente.", fechaFin, intervalo4.getfecha_fin());
	}

	@Test
	public void testUpdateIntervalo() {
		String fechaIn = "24/05/2021";
		String fechaFin = "28/05/2021";
		
		//fecha fin, fecha inicio, id, noches

		// Update playlist
		intervalo.setfecha_in(fechaIn);
		intervalo.setfecha_fin(fechaFin);

		boolean success = ivr.updateIntervalo(intervalo);
		
		assertTrue("Error when updating the playlist", success);
		
		Intervalo iv  = ivr.getIntervalo(intervalo.getId());
		assertEquals("La fecha de inicio no se ha actualizado correctamente", fechaIn, iv.getfecha_in());
		assertEquals("La fecha final no se ha actualizado correctamente", fechaFin, iv.getfecha_fin());

	}

	@Test
	public void testDeleteIntervalo() {
		boolean success = ivr.deleteIntervalo(intervalo2.getId());
		assertTrue("Error al eliminar el intervalo", success);
		
		Intervalo iv = ivr.getIntervalo(intervalo2.getId());
		assertNull("El intervalo no se ha eliminado correctamente", iv);
	}

	@Test
	public void testAddNoche() {
		if(noche!=null) {
			boolean success = ivr.addNoche(intervalo3.getId(), noche.getId());
			assertTrue("Error al añadir una noche", success);
		}
	}

	@Test
	public void testDeleteNoche() {
		//TODO
	}

}
