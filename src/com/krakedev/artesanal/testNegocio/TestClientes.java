package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {
	public static void main(String[] args) {
    	NegocioMejorado negocio = new NegocioMejorado();

        System.out.println("Intentando registrar cliente...");

        negocio.registrarCliente("Dilan Solorzano", "1723456789");
    }
}