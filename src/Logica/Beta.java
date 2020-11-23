package Logica;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		daño = 10;
	}
	
	public String getTipo() {
		return "Beta";
	}
}
