package GUI;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.Player;
import Logica.Proyectil;

public class ControlPlayer implements KeyListener{
	protected GUIJuego GUI;
	protected JLabel labelPlayer;
	protected final Player player = Player.instancia();
	
	public ControlPlayer(GUIJuego GUI) {
		this.GUI = GUI;
		labelPlayer = player.getEntidadGrafica();
		Juego.instancia().getEntidades().add(player);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!player.murio()) {
			int key = e.getKeyCode();
			int distancia = player.getVelocidad();
			int componente;
			Point posicion = labelPlayer.getLocation();
	
	        if (key == KeyEvent.VK_LEFT) {
	        	componente = posicion.x - distancia;
	        	if(!fueraLimite(componente)) {
	        		posicion.setLocation(componente, posicion.y);
	        		player.getEntidadGrafica().setPosX(componente);
	        	}
	        }
	        else if (key == KeyEvent.VK_RIGHT) {
	        	componente = posicion.x + distancia;
	        	if(!fueraLimite(componente)) {
	        		posicion.setLocation(componente, posicion.y);
	        		player.getEntidadGrafica().setPosX(componente);
	        	}	
	        }
	        else if (key == KeyEvent.VK_UP) {
	        	player.disparar(20);
	        	
	        	cargar(player.getArma().getProyectil());
	        	Juego.instancia().addEntidad(player.getArma().getProyectil());
	        }
	        
	        labelPlayer.setLocation(posicion);
	        GUI.actualizar("player.png", labelPlayer);
		}
	}
	
	protected void cargar(Proyectil proyectil) { 
		int posX = player.getEntidadGrafica().getPosX();
		int posY = player.getEntidadGrafica().getPosY();
		
		proyectil.getEntidadGrafica().setPosX(posX);
		proyectil.getEntidadGrafica().setPosY(posY);
		proyectil.getEntidadGrafica().setBounds(posX+labelPlayer.getWidth()/2, posY-labelPlayer.getHeight()/3, 20, 40);
		GUI.actualizar(proyectil.getEntidadGrafica().getImagenes()[0], proyectil.getEntidadGrafica());
		GUI.getPanelMapa().add(proyectil.getEntidadGrafica(), 0);
	}
	
	protected boolean fueraLimite(int posX) {
		boolean toReturn = false;
		int ancho = GUI.getPanelMapa().getWidth();
		if(posX <0 || posX + labelPlayer.getWidth() >ancho)
			toReturn = true;
		return toReturn;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
