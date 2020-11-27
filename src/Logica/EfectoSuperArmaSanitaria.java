package Logica;

import java.util.List;

public class EfectoSuperArmaSanitaria extends EfectoTemporal{
	
	public EfectoSuperArmaSanitaria() {
		visitor = new VisitorEfectoSuperArma(this);
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		Player player = Player.instancia();
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

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioSuperArma(this);
	}
}
