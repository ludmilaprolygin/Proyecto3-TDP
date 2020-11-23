package Logica;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		daño = 20;
	}

	public String getTipo() {
		return "Alpha";
	}
}
