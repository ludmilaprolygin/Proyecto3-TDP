package Logica;

import javax.swing.ImageIcon;

public abstract class Proyectil extends Entidad{
	protected int poder;
	protected int velocidad;
	
	public Proyectil() {
		super();
		//Player player = Player.instancia();
		String[] ruta = {"Bala.png"};
		entidadGrafica.setImagenes(ruta);
		entidadGrafica.setGrafico(new ImageIcon(ruta[0]));
		//entidadGrafica.setPosX(player.getEntidadGrafica().getPosX());
		//entidadGrafica.setPosY(player.getEntidadGrafica().getPosY());
	}
	
	//Getters
	public int getPoder() {
		return poder;
	}
	public int getVelocidad() {
		return velocidad;
	}
	
	//Setters
	public void setPoder(int poder) {
		this.poder = poder;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		int posInicial = entidadGrafica.getPosY();
		entidadGrafica.setPosY(posInicial - velocidad);
		if(entidadGrafica.getPosY()<=0) 
			Juego.instancia().removeEntidad(this);
	}
}