package Logica;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		setDaño();
	}

	public String getTipo() {
		return "Alpha";
	}
	
	protected void setDaño() {
		daño = 6;
	}
}
