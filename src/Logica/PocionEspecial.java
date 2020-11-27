package Logica;

import java.util.List;

public class PocionEspecial extends ObjetoPrecioso{

	public PocionEspecial() {
		super();
		visitor = new VisitorPocion(this);
	}
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		Player.instancia().setCargaViral(100);
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioPocion(this);
	}
}
