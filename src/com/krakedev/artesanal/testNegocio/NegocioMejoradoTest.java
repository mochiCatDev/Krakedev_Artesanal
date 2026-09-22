package com.krakedev.artesanal.testNegocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
	
	@Test
	public void testRecuperarMaquina() {
		NegocioMejorado negocio = new NegocioMejorado();

		// Agregamos una máquina previa para probar la búsqueda
		negocio.agregarMaquina("Pilsen", "Cerveza rubia", 0.03);
		String codigoGenerado = negocio.getMaquinas().get(0).getCodigo();

		// 1. Caso éxito: Debe retornar la máquina existente
		Maquina encontrada = negocio.recuperarMaquina(codigoGenerado);
		assertNotNull(encontrada);
		assertEquals("Pilsen", encontrada.getNombreCerveza());

		// 2. Caso fallo: Código no existente debe retornar null
		Maquina noExistente = negocio.recuperarMaquina("M-999");
		assertNull(noExistente);
	}
	
	@Test
	public void testAgregarMaquinaUnica() {
		NegocioMejorado negocio = new NegocioMejorado();

		// 1. Agregamos una máquina por primera vez (debe devolver true)
		boolean resultado = negocio.agregarMaquina("Pilsener", "Cerveza rubia", 2.50);

		// Validamos la aserción con JUnit
		assertTrue(resultado);
		assertEquals(1, negocio.getMaquinas().size());
	}

	@Test
	public void testAgregarMaquinaDuplicada() {
		NegocioMejorado negocio = new NegocioMejorado();

		// 1. Agregamos la primera cerveza
		negocio.agregarMaquina("Pilsener", "Cerveza rubia", 2.50);

		// 2. Intentamos agregar la MISMA cerveza (debe devolver false por duplicado)
		boolean resultadoDuplicado = negocio.agregarMaquina("Pilsener", "Otra descripción", 3.00);
		
		// Validamos la aserción con JUnit: esperamos un 'false'
		assertFalse(resultadoDuplicado);

		// Verificamos que la lista siga teniendo solo 1 elemento
		assertEquals(1, negocio.getMaquinas().size());
	}
}