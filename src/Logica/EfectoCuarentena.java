package Logica;

import java.util.List;

public class EfectoCuarentena extends EfectoTemporal{
	protected Nivel nivel;
	
	public EfectoCuarentena() {
		super();
		visitor = new VisitorEfectoCuarentena(this);
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		//List<Infectado> infectados = nivel.getTanda();
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioCuarentena(this);
	}
}
