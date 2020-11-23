package Logica;

public abstract class Personaje extends Entidad{
	protected int cargaViral;
	protected int velocidad;
	
	//Getters
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
}
