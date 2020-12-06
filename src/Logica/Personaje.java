package Logica;

public abstract class Personaje extends Entidad{
	protected int cargaViral;
	protected int velocidad;
	
	public Personaje() {
		super();
	}
	
	public int getCargaViral() {
		return cargaViral;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public void setCargaViral(int cargaViral) {
		this.cargaViral = cargaViral;
	}
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void recibirDaño(int d) {
		cargaViral -= d;
	}
}
