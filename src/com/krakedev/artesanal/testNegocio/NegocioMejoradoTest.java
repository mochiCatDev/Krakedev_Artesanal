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
}