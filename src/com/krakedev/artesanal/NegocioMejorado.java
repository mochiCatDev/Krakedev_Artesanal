package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int ultimoCodigo = 100;

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

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		for (Maquina c : maquinas) {
			if (c != null && c.getNombreCerveza().equals(nombreCerveza)) {
				return false;
			}
		}

		String codigoGenerado = generarCodigo();
        Maquina nuevaMaquina = new Maquina(codigoGenerado, nombreCerveza, descripcion, precioPorMl);
        maquinas.add(nuevaMaquina);
        
        return true;
    }
	
	public void cargarMaquinas() {
    	for (int i = 0; i < maquinas.size(); i++) {
    		Maquina m = maquinas.get(i);
    		if (m != null) {
    			m.llenarMaquina();
    		}
    	}
    }

	public Maquina recuperarMaquina(String codigo) {
		if (codigo == null) {
			return null;
		}
		for (Maquina m : maquinas) {
			if (m != null && codigo.equals(m.getCodigo())) {
				return m;
			}
		}
		return null;
	}
	
	public void registrarCliente(String nombre, String cedula) {
		String codigo = ultimoCodigo + "";
		Cliente nuevoCliente = new Cliente(nombre, cedula);
		nuevoCliente.setCodigo(codigo);
		ultimoCodigo++;
		clientes.add(nuevoCliente);
	}
	
	public Cliente buscarClientePorCedula(String cedula) {
		if(cedula == null) {
			return null;
		}
		for (Cliente c : clientes) {
			if (c != null && cedula.equals(c.getCedula())) {
				return c;
			}
		}
		return null;
	}
	
	public Cliente buscarClientePorCodigo(String codigo) {
		if(codigo == null) {
			return null;
		}
		for (Cliente c : clientes) {
			if (c != null && codigo.equals(c.getCodigo())) {
				return c;
			}
		}
		return null;
	}
}