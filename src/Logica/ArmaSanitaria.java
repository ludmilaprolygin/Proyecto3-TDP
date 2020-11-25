package Logica;

public class ArmaSanitaria extends Arma{

	@Override
	public void disparar() {
		// TODO Auto-generated method stub
		proyectil = new ProyectilArmaSanitaria();
	}
}
