package Logica;

public abstract class Proyectil extends Entidad{
	protected int municion;
	protected int velocidad;
	
	public Proyectil() {
		super();
		Player player = Player.instancia();
		entidadGrafica.setPosX(player.getEntidadGrafica().getPosX());
		entidadGrafica.setPosY(player.getEntidadGrafica().getPosY());
	}
	
	//Getters
	public int getMunicion() {
		return municion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setMunicion(int municion) {
		this.municion = municion;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
}
