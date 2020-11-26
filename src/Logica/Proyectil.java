package Logica;

public abstract class Proyectil extends Entidad{
	protected int municion;
	protected int velocidad;
	
	public Proyectil() {
		super();
		//visitor = new VisitorProyectil(this); Pasar a ProyectilArmaSanitaria
		Player player = Player.instancia();
		entidadGrafica.setPosX(player.getEntidadGrafica().getPosX());
		entidadGrafica.setPosY(player.getEntidadGrafica().getPosY());
	}
	
	//Getters
	public int getMunicion() {
		return municion;
	}
	public int getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setMunicion(int municion) {
		this.municion = municion;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		//Relación con el Visitor!!! --> Como eliminarlo de la lista de entidades
		int posInicial = entidadGrafica.getPosY();
		entidadGrafica.setPosY(posInicial - velocidad);
		//if(entidadGrafica.getPosY()==0) 
			//Juego.instancia().removeEntidad(this);
	}
	
	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarProyectil(this);
	}
}