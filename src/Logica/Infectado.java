package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int da�o;
	
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
	
	public int getDa�o() {
		return da�o;
	}
	
	public abstract String getTipo();
	
	protected abstract void setDa�o();
	
	public void jugar() { //Queda la responsabilidad de que se salga del JFrame para afuera
		int movimiento = entidadGrafica.getPosY() + velocidad;
		Player player = Player.instancia();
		entidadGrafica.setPosY(movimiento);
		
		if(player.getEntidadGrafica().getPosY()-rango <= entidadGrafica.getPosY()) {
			player.setCargaViral(player.getCargaViral() - da�o);
			da�o = 0;
		}	
		else
			setDa�o();
	}
}
