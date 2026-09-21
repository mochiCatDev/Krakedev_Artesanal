package com.krakedev.artesanal.testNegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class NegocioMejoradoTest {

	@Test
	public void testGenerarCodigo() {
		NegocioMejorado negocio = new NegocioMejorado();
		String codigo = negocio.generarCodigo();

		// Verifica que no sea nulo y que comience con el prefijo "M-"
		assertNotNull(codigo);
		assertTrue(codigo.startsWith("M-"));	
	}

	@Test
	public void testAgregarMaquina() {
		NegocioMejorado negocio = new NegocioMejorado();
        
		negocio.agregarMaquina("IPA", "Cerveza artesanal IPA", 0.05);
        
		assertEquals(1, negocio.getMaquinas().size());
        
		Maquina guardada = negocio.getMaquinas().get(0);
		assertNotNull(guardada);
		assertEquals("IPA", guardada.getNombreCerveza());
		assertTrue(guardada.getCodigo().startsWith("M-"));
	}
	
	@Test
	public void testCargarMaquinas() {
		NegocioMejorado negocio = new NegocioMejorado();

		// 1. Agregamos una máquina (inicialmente la cantidadActual nace en 0)
		negocio.agregarMaquina("Stout", "Cerveza negra", 0.06);

		// 2. Ejecutamos el método del Paso 5
		negocio.cargarMaquinas();

		// 3. Verificamos que la máquina ya no esté vacía
		Maquina m = negocio.getMaquinas().get(0);
		assertTrue(m.getCantidadActual() > 0);
	}
}