package Logica;

public class SuperArmaSanitaria extends ArmaSanitaria{
	
	public void setMunicion() {
		getProyectil().setPoder(getProyectil().getPoder() + 10);
	}
}
