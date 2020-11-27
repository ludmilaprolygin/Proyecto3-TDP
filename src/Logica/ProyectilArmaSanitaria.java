package Logica;

import java.util.List;

public class ProyectilArmaSanitaria extends Proyectil{
	
	public ProyectilArmaSanitaria() {
		super();
		visitor = new VisitorProyectilArmaSanitaria(this);
		velocidad = 50;
		poder = 20;
	}
	
	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectilArmaSanitaria(this);
	}
}
