package Logica;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		setDa�o();
	}

	public String getTipo() {
		return "Alpha";
	}
	
	protected void setDa�o() {
		da�o = 6;
	}
}
