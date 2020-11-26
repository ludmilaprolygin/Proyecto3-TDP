package Logica;

import java.util.List;

public class EfectoSuperArmaSanitaria extends EfectoTemporal{
	protected Player player;
	
	public void cambiarArma() {
		
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		Arma nuevaArma = new SuperArmaSanitaria();
		Arma armaPlayer = player.getArma();
		player.setArma(nuevaArma);
		//Thread ??? Hacer un hold del tiempo
		player.setArma(armaPlayer);
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}
}
