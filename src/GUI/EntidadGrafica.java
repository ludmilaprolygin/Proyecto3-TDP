package GUI;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon grafico;
	protected String[] imagenes; //Arreglo porque pueden ser infectadosBeta comunes, infectados, desinfectados
	protected Point punto;
	
	public EntidadGrafica() {
		grafico = new ImageIcon();
		imagenes = new String[] {};
	}
	
	public EntidadGrafica(int posX, int posY) {
		this();
		getLocation().x = posX;
		getLocation().y = posY;
	}

	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
		setIcon(grafico);
		setBounds(getPosX(), getPosY(), 90, 100);
	}
	
	public void setPosX(int posX) {
		punto = getLocation();
		punto.setLocation(posX, punto.y);
		setLocation(punto);
	}
	
	public void setPosY(int posY) {
		punto = getLocation();
		punto.setLocation(punto.x, posY);

		setLocation(punto);
	}
	
	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}
	
	public ImageIcon getGrafico() {
		return grafico;
	}
	
	public int getPosX() {
		punto = getLocation();
		return punto.x;
	}
	
	public int getPosY() {
		punto = getLocation();
		return punto.y;
	}

	public String[] getImagenes() {
		return imagenes;
	}
	
	public void actualizar(int indice) { 
		if (indice < imagenes.length) {
			ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
			grafico.setImage(imageIcon.getImage());
		}
	}
}
