package Logica;

public abstract class Personaje extends Entidad{
	protected int cargaViral;
	protected float velocidad;
	
	//Getters
	public int getCargaViral() {
		return cargaViral;
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}
	
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
}
