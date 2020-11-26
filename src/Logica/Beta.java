package Logica;

import java.util.List;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		visitor = new VisitorBeta(this);
		setDa�o();
	}
	
	public String getTipo() {
		return "Beta";
	}
	
	protected void setDa�o() {
		da�o = 3;
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
