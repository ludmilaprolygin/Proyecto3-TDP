package GUI;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import Logica.Player;

public class ControlPlayer implements KeyListener{
	protected GUIJuego gui;
	protected JLabel labelPlayer;
	
	public ControlPlayer(GUIJuego gui) {
		this.gui = gui;
		labelPlayer = gui.getLabelPlayer();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int distancia = Player.instancia().getVelocidad();
		int componente;
		Point posicion = labelPlayer.getLocation();

        if (key == KeyEvent.VK_LEFT) {
        	componente = posicion.x - distancia;
        	if(!fueraLimite(componente))
        		posicion.setLocation(componente, posicion.y);
        }
        else if (key == KeyEvent.VK_RIGHT) {
        	componente = posicion.x + distancia;
        	if(!fueraLimite(componente))
        		posicion.setLocation(componente, posicion.y);
        }
        else if (key == KeyEvent.VK_UP) {
        	Player player = Player.instancia();
        	player.disparar();
        }
        
        labelPlayer.setLocation(posicion);
        gui.actualizar("player.png", labelPlayer);
	}
	
	protected boolean fueraLimite(int posX) {
		boolean toReturn = false;
		int ancho = gui.getPanelMapa().getWidth();
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
