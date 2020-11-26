package Logica;

public abstract class Premio extends Entidad{
	protected float velocidad;
	
	public Premio() {
		super();
		visitor = new VisitorPremio(this);
		//Juego.instancia().addEntidad(this);
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremio(this);
	}
}
