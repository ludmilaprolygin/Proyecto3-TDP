package Logica;

public class ProyectilArmaSanitaria extends Proyectil{
	
	public ProyectilArmaSanitaria(int p) {
		super();
		velocidad = 50;
		poder = p;
		visitor = new VisitorProyectilArmaSanitaria(this);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectilArmaSanitaria(this);
	}
}
