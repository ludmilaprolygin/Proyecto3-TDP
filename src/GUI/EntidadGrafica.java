package GUI;

import javax.swing.ImageIcon;

public class EntidadGrafica {
	protected ImageIcon grafico;
	protected String[] imagenes; //Arreglo porque pueden ser infectadosBeta comunes, infectados, desinfectados

	public EntidadGrafica() {
		grafico = new ImageIcon();
		imagenes = new String[] {};
	}

	public ImageIcon getGrafico() {
		return grafico;
	}

	public void setGrafico(ImageIcon grafico) {
		this.grafico = grafico;
	}

	public String[] getImagenes() {
		return imagenes;
	}

	public void setImagenes(String[] imagenes) {
		this.imagenes = imagenes;
	}
	
	public void actualizar(int indice) { //NUEVO
		if (indice < imagenes.length) {
			ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.imagenes[indice]));
			grafico.setImage(imageIcon.getImage());
		}
	}
}
