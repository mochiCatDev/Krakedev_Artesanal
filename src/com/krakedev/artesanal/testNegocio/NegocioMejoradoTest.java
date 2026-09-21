package com.krakedev.artesanal.testNegocio;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
}