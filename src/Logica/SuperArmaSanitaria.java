package Logica;

public class SuperArmaSanitaria extends ArmaSanitaria{
	
	public void setMunicion() {
		getProyectil().setMunicion(getProyectil().getMunicion() + 10);
	}
}
