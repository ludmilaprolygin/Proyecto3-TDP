package Logica;

import java.util.List;

public class PocionEspecial extends ObjetoPrecioso{

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		player.setCargaViral(100);
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}
}
