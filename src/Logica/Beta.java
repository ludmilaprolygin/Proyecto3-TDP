package Logica;

import java.util.List;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		visitor = new VisitorBeta(this);
		setDaño();
	}
	
	public String getTipo() {
		return "Beta";
	}
	
	protected void setDaño() {
		daño = 3;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarEnemigoBeta(this);
	}
}
