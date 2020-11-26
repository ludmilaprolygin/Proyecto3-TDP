package Logica;

import java.util.List;

public class ProyectilArmaSanitaria extends Proyectil{
	
	public ProyectilArmaSanitaria() {
		super();
		velocidad = 1;
		municion = 20;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}
}
