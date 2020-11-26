package Logica;

import java.util.List;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		visitor = new VisitorAlpha(this);
		setDaño();
	}

	public String getTipo() {
		return "Alpha";
	}
	
	protected void setDaño() {
		daño = 6;
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
