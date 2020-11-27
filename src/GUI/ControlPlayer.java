package GUI;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import Logica.Player;
import Logica.Proyectil;

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
        	if(!fueraLimite(componente)) {
        		posicion.setLocation(componente, posicion.y);
        		Player.instancia().getEntidadGrafica().setPosX(componente);
        	}
        }
        else if (key == KeyEvent.VK_RIGHT) {
        	componente = posicion.x + distancia;
        	if(!fueraLimite(componente)) {
        		posicion.setLocation(componente, posicion.y);
        		Player.instancia().getEntidadGrafica().setPosX(componente);
        	}	
        }
        else if (key == KeyEvent.VK_UP) {
        	Player player = Player.instancia();
        	player.disparar();
        	cargar(player.getArma().getProyectil());
        }
        
        labelPlayer.setLocation(posicion);
        gui.actualizar("player.png", labelPlayer);
	}
	
	protected void cargar(Proyectil proyectil) { 
		EntidadGrafica label = proyectil.getEntidadGrafica();
		int posX = Player.instancia().getEntidadGrafica().getPosX();
		int posY = Player.instancia().getEntidadGrafica().getPosY();
		label.setPosX(posX);
		label.setPosY(posY);
		label.setBounds(posX+61, posY-38, 20, 40);
		gui.actualizar(label.getImagenes()[0], label);
		gui.getPanelMapa().add(label, 0);
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
