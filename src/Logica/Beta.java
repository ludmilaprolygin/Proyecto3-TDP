package Logica;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		setDa�o();
	}
	
	public String getTipo() {
		return "Beta";
	}
	
	protected void setDa�o() {
		da�o = 3;
	}
}
