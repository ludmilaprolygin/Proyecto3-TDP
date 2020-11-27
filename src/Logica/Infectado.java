package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int daño;
	
	public Infectado(int rango, int velocidad) {
		super();
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
	
	protected abstract void setDaño();
	
	public void jugar() { 
		int movimiento = entidadGrafica.getPosY() + velocidad;
		Player player = Player.instancia();
		int distancia = distancia(player.getEntidadGrafica().getPosX(), player.getEntidadGrafica().getPosY());
		entidadGrafica.setPosY(movimiento);
		if(distancia<=rango) {
			player.setCargaViral(player.getCargaViral() - daño);
			daño = 0;
		}	
		else
			setDaño();
		if(entidadGrafica.getY()>700)
			entidadGrafica.setPosY(0);
	}
	
	protected int distancia(int posXplayer, int posYplayer) {
		int toReturn;
		int dx = posXplayer - entidadGrafica.getPosX();
		int dy = posYplayer - entidadGrafica.getPosY();
		toReturn = (int) Math.sqrt(dx*dx + dy*dy);
		return toReturn;
	}
}
