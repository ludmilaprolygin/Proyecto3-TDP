package Logica;

public abstract class Proyectil extends Entidad{
	protected int municion;
	protected float velocidad;
	
	//Getters
	public int getMunicion() {
		return municion;
	}
	public float getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setMunicion(int municion) {
		this.municion = municion;
	}
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
}
