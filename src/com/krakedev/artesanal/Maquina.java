package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;
	
	// === GETTERS ===
	
	public String getNombreCerveza() {
		return nombreCerveza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecioPorMl() {
		return precioPorMl;
	}
	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public double getCantidadActual() {
		return cantidadActual;
	}
	
	// === SETTERS ===
	
	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}
}
