package Logica;

public class ArmaSanitaria extends Arma{
	@Override
	public void disparar(int p) {
		// TODO Auto-generated method stub
		proyectil = new ProyectilArmaSanitaria(p);
	}
}
