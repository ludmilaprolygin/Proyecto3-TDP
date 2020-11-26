package Logica;

import java.util.List;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		visitor = new VisitorAlpha(this);
		setDa�o();
	}

	public String getTipo() {
		return "Alpha";
	}
	
	protected void setDa�o() {
		da�o = 6;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarEnemigoAlpha(this);
	}
}
