package Logica;

import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		Random random = new Random();
		int valor = random.nextInt(2);
		String[] rutas1	 = {"ALPHA1Infectado.png", "ALPHA1Desinfectado.png", "ALPHA1Comun.png"};
		String[] rutas2 = {"ALPHA2Infectado.png", "ALPHA2Desinfectado.png", "ALPHA2Comun.png"};
		if(valor == 0) {
			entidadGrafica.setImagenes(rutas1);
			entidadGrafica.setGrafico(new ImageIcon(rutas1[0]));
		}
		else {
			entidadGrafica.setImagenes(rutas2);
			entidadGrafica.setGrafico(new ImageIcon(rutas2[0]));
		}
		visitor = new VisitorAlpha(this);
		setDaño();
	}

	public String getTipo() {
		return "Alpha";
	}
	
	protected void setDaño() {
		daño = 6;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarEnemigoAlpha(this);
	}
}
