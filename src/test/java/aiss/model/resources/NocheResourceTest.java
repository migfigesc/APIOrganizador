package aiss.model.resources;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.api.resources.NochesResource;
import aiss.model.Calidad;
import aiss.model.Animo;
import aiss.model.Noche;
import aiss.model.Tipo_sueno;

public class NocheResourceTest {

	static Noche noche1, noche2, noche3;
	static NochesResource sr = new NochesResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		// Test noche 1
		noche1 = sr.addNoche(new Noche("n14","03/11/2020","PROFUNDO","BUENA","FELIZ",1,6));
		
		// Test noche 2
		noche2 = sr.addNoche(new Noche("n15","04/11/2020","PROFUNDO","BUENA","FELIZ",1,8));
	
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteNoche(noche1.getId());
		sr.deleteNoche(noche2.getId());
	}
	
	@Test

	public void testGetAll() {
		Collection<Noche> noches = sr.getAll();
		
		assertNotNull("La colección de noches es nula.", noches);
		
		// Show result
		System.out.println("Lista de todas las noches:");
		int i=1;
		for (Noche n : noches) {
			System.out.println("Noche " + i++ + " : " + n.getFechaSuenyo() + " (ID=" + n.getId() + ")");
		}
	}

	@Test
	public void testGetNoche() {
		Noche n = sr.getNoche(noche1.getId());
		
		
		assertEquals("Los id de las noches no coinciden", noche1.getId(), n.getId());
		assertEquals("La fecha de las noches no coinciden", noche1.getCalidadSuenyo(), n.getCalidadSuenyo());
		
		// Show result
		System.out.println("Noche id: " +  n.getId());
		System.out.println("Noche fecha: " +  n.getFechaSuenyo());	
		}

	@Test
	public void testAddNoche() {
		
		Noche noche4 = new Noche("n16","03/11/2020","PROFUNDO","BUENA","FELIZ",1,6);

		Noche added = sr.addNoche(noche4);
		
		assertNotNull("Error añadiendo la noche", noche4);
		assertEquals("La fecha de la noche no se ha asignado correctamente.", added.getFechaSuenyo(), noche4.getFechaSuenyo());
		assertEquals("La calidad del sueño de la noche no se ha asignado correctamente.", added.getCalidadSuenyo(), noche4.getCalidadSuenyo());
		assertEquals("El estado de ánimo no se ha asignado correctamente.", added.getEstadoAnimo(), noche4.getEstadoAnimo());
		assertEquals("La hora de inicio no se ha asignado correctamente.", added.getHoraIn(), noche4.getHoraIn());
		assertEquals("La hora de fin no se ha asignado correctamente.", added.getHoraFin(), noche4.getHoraFin());
		assertEquals("El tipo de sueño no se ha asignado correctamente.", added.getTipoSuenyo(), noche4.getTipoSuenyo());
	}

	@Test
	public void testUpdateNoche() {
		
		String fechaSuenyo = "13/12/2020";
		Tipo_sueno tipoSuenyo = Tipo_sueno.MEDIO;
		Calidad calidadSuenyo = Calidad.MALA;
		Animo estadoAnimo = Animo.CANSADO;
		Integer hora_in = 3;
		Integer hora_fin = 4;
		
		// Update noche
		noche1.setFechaSuenyo("09/10/2019");
		noche1.setTipoSuenyo("MEDIO");
		noche1.setCalidadSuenyo("MUYMALA");
		noche1.setEstadoAnimo("ENFADADO");
		noche1.setHoraIn(2);
		noche1.setHoraFin(8);
		
		boolean success = sr.updateNoche(noche1);
		
		assertTrue("Error actualizando la noche", success);
		
		Noche noche = sr.getNoche(noche1.getId());
		
		assertEquals("La fecha de la noche no se ha actualizado correctamente.", fechaSuenyo, noche.getFechaSuenyo());
		assertEquals("La calidad del sueño de la noche no se ha actualizado correctamente.", calidadSuenyo, noche.getCalidadSuenyo());
		assertEquals("El estado de ánimo no se ha actualizado correctamente.", estadoAnimo, noche.getEstadoAnimo());
		assertEquals("La hora de inicio no se ha actualizado correctamente.", hora_in, noche.getHoraIn());
		assertEquals("La hora de fin no se ha actualizado correctamente.", hora_fin, noche.getHoraFin());
		assertEquals("El tipo de sueño no se ha actualizado correctamente.", tipoSuenyo, noche.getTipoSuenyo());
	}

	@Test(expected = ResourceException.class)
	public void testDeleteNoche() {
		
		// Delete songs
		boolean success = sr.deleteNoche(noche2.getId());
		
		assertTrue("Error eliminando la noche", success);
		
		Noche noche = sr.getNoche(noche2.getId());
		assertNull("La noche no se ha añadido correctamente", noche);
	}

}
