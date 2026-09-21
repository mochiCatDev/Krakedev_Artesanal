package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public String generarCodigo() {
		int numeroAleatorio = (int) (Math.random() * 100) + 1;
		return "M-" + numeroAleatorio;
	}

	public void agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
    	String codigoGenerado = generarCodigo();
        Maquina nuevaMaquina = new Maquina(codigoGenerado, nombreCerveza, descripcion, precioPorMl);
        maquinas.add(nuevaMaquina);
    }
	
	public void cargarMaquinas() {
    	for (int i = 0; i < maquinas.size(); i++) {
    		Maquina m = maquinas.get(i);
    		if (m != null) {
    			m.llenarMaquina();
    		}
    	}
    }
}