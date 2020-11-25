package Logica;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		setDaño();
	}
	
	public String getTipo() {
		return "Beta";
	}
	
	protected void setDaño() {
		daño = 3;
	}
}
