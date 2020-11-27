package Logica;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int da�o;
	
	public Infectado(int rango, int velocidad) {
		super();
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
	
	protected abstract void setDa�o();
	
	public void jugar() { 
		int movimiento = entidadGrafica.getPosY() + velocidad;
		Player player = Player.instancia();
		int distancia = distancia(player.getEntidadGrafica().getPosX(), player.getEntidadGrafica().getPosY());
		entidadGrafica.setPosY(movimiento);
		if(distancia<=rango) {
			player.setCargaViral(player.getCargaViral() - da�o);
			da�o = 0;
		}	
		else
			setDa�o();
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
