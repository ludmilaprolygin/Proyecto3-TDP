package GUI;

import javax.swing.ImageIcon;

public class EntidadGrafica {
	protected ImageIcon grafico;
	protected String[] imagenes; //Arreglo porque pueden ser infectadosBeta comunes, infectados, desinfectados
	protected int posX, posY;
	
	public EntidadGrafica() {
		grafico = new ImageIcon();
		imagenes = new String[] {};
	}

	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}
	
	public ImageIcon getGrafico() {
		return grafico;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
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
