package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected float velocidad;
	protected int da�o;
	
	public Infectado(int rango, float velocidad) {
		super();
		cargaViral = 100;
		this.rango = rango;
		this.velocidad = velocidad;
	}
	
	//Getters 
	public int getRango() {
		return rango;
	} 
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public int getDa�o() {
		return da�o;
	}
	
	//Setters 
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
}
