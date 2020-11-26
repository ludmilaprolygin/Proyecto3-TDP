package Logica;

import java.util.List;

//import java.util.ArrayList;

public class EfectoCuarentena extends EfectoTemporal{
	protected Nivel nivel;

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
}
