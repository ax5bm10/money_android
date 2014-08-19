package com.example.clases;

public class Gasto {
	private int id;
	private int monto;
	private String fecha;
	private String info;
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMonto() {
		return monto;
	}
	
	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString(){
		return monto + " " + fecha + " " + info;
	}

}
