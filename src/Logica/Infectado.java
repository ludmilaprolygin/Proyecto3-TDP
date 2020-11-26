package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int daño;
	
	public Infectado(int rango, int velocidad) {
		super();
		//Juego.instancia().addEntidad(this);
		cargaViral = 100;
		this.rango = rango;
		this.velocidad = velocidad;
	}
	
	public int getRango() {
		return rango;
	} 
	
	public int getDaño() {
		return daño;
	}
	
	public abstract String getTipo();
	
	protected abstract void setDaño();
	
	public void jugar() { //Queda la responsabilidad de que se salga del JFrame para afuera
		int movimiento = entidadGrafica.getPosY() + velocidad;
		Player player = Player.instancia();
		entidadGrafica.setPosY(movimiento);
		
		if(player.getEntidadGrafica().getPosY()-rango <= entidadGrafica.getPosY()) {
			player.setCargaViral(player.getCargaViral() - daño);
			daño = 0;
		}	
		else
			setDaño();
	}
}
