package aiss.model.resources;

import static org.junit.Assert.*;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.CalidadSuenyo;
import aiss.model.EstadoAnimo;
import aiss.model.Noche;
import aiss.model.TipoSuenyo;
import aiss.api.resources.NochesResource;

public class NocheResourceTest {

	static Noche noche1, noche2, noche3;
	static NochesResource sr = new NochesResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		// Test noche 1
		noche1 = sr.addNoche(new Noche("n12","03/11/2020",TipoSuenyo.PROFUNDO, CalidadSuenyo.BUENA, EstadoAnimo.FELIZ,22,6));
		
		// Test noche 2
		noche2 = sr.addNoche(new Noche("n13","04/11/2020",TipoSuenyo.PROFUNDO, CalidadSuenyo.BUENA, EstadoAnimo.FELIZ,00,8));
	
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteNoche(noche1.getId());
		sr.deleteNoche(noche3.getId());
	}
	
	@Test
	public void testGetAll() {
		Collection<Noche> noches = sr.getAll();
		
		assertNotNull("La colección de noches es nula.", noches);
		
		// Show result
		System.out.println("Lista de todas las noches:");
		int i=1;
		for (Noche n : noches) {
			System.out.println("Noche " + i++ + " : " + n.getFecha_suenyo() + " (ID=" + n.getId() + ")");
		}
	}

	@Test
	public void testGetNoche() {
		Noche n = sr.getNoche(noche1.getId());
		
		assertEquals("Los id de las noches no coinciden", noche1.getId(), n.getId());
		assertEquals("La fecha de las noches no coinciden", noche1.getCalidadsuenyo(), n.getCalidadsuenyo());
		
		// Show result
		System.out.println("Noche id: " +  n.getId());
		System.out.println("Noche fecha: " +  n.getFecha_suenyo());	
		}

	@Test
	public void testAddNoche() {
		
		Noche noche4 = new Noche("n15","03/11/2020",TipoSuenyo.PROFUNDO, CalidadSuenyo.BUENA, EstadoAnimo.FELIZ,22,6);

		Noche added = sr.addNoche(noche4);
		
		assertNotNull("Error añadiendo la noche", noche4);
		assertEquals("La fecha de la noche no se ha asignado correctamente.", added.getFecha_suenyo(), noche4.getFecha_suenyo());
		assertEquals("La calidad del sueño de la noche no se ha asignado correctamente.", added.getCalidadsuenyo(), noche4.getCalidadsuenyo());
		assertEquals("El estado de ánimo no se ha asignado correctamente.", added.getEstado_animo(), noche4.getEstado_animo());
		assertEquals("La hora de inicio no se ha asignado correctamente.", added.getHora_in(), noche4.getHora_in());
		assertEquals("La hora de fin no se ha asignado correctamente.", added.getHora_fin(), noche4.getHora_fin());
		assertEquals("El tipo de sueño no se ha asignado correctamente.", added.getTipo_suenyo(), noche4.getTipo_suenyo());
	}

	@Test
	public void testUpdateNoche() {
		
		String fechaSuenyo = "13/12/2020";
		TipoSuenyo tipoSuenyo = TipoSuenyo.MEDIO;
		CalidadSuenyo calidadSuenyo = CalidadSuenyo.MALA;
		EstadoAnimo estadoAnimo = EstadoAnimo.CANSADO;
		Integer hora_in = 3;
		Integer hora_fin = 4;
		
		// Update noche
		noche1.setFecha_suenyo("09/10/2019");
		noche1.setTipo_suenyo(TipoSuenyo.MEDIO);
		noche1.setCalidadsuenyo(CalidadSuenyo.MUYMALA);
		noche1.setEstado_animo(EstadoAnimo.ENFADADO);
		noche1.setHora_in(2);
		noche1.setHora_fin(8);
		
		boolean success = sr.updateNoche(noche1);
		
		assertTrue("Error actualizando la noche", success);
		
		Noche noche = sr.getNoche(noche1.getId());
		
		assertEquals("La fecha de la noche no se ha actualizado correctamente.", fechaSuenyo, noche.getFecha_suenyo());
		assertEquals("La calidad del sueño de la noche no se ha actualizado correctamente.", calidadSuenyo, noche.getCalidadsuenyo());
		assertEquals("El estado de ánimo no se ha actualizado correctamente.", estadoAnimo, noche.getEstado_animo());
		assertEquals("La hora de inicio no se ha actualizado correctamente.", hora_in, noche.getHora_in());
		assertEquals("La hora de fin no se ha actualizado correctamente.", hora_fin, noche.getHora_fin());
		assertEquals("El tipo de sueño no se ha actualizado correctamente.", tipoSuenyo, noche.getTipo_suenyo());
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
