package Logica;

import java.util.Random;
import javax.swing.ImageIcon;

public class Alpha extends Infectado {
	
	public Alpha(int rango, int velocidad) {
		super(rango, velocidad);
		Random random = new Random();
		int valor = random.nextInt(2);
		String[] rutas1	 = {"ALPHA1Infectado.png", "ALPHA1Desinfectado.png", "ALPHA1Comun.png"};
		String[] rutas2 = {"ALPHA2Infectado.png", "ALPHA2Desinfectado.png", "ALPHA2Comun.png"};
		
		daño = 6;
		if(valor == 0) {
			entidadGrafica.setImagenes(rutas1);
			entidadGrafica.setGrafico(new ImageIcon(rutas1[0]));
		}
		else {
			entidadGrafica.setImagenes(rutas2);
			entidadGrafica.setGrafico(new ImageIcon(rutas2[0]));
		}
		visitor = new VisitorAlpha(this);
	}
	
	protected void setDaño(int d) {
		daño = d;
	}
	
	public void recibirDaño(int d) {
		super.recibirDaño(d);
		if (cargaViral<=20 && cargaViral>0)
			velocidad*=2;
		else if(cargaViral<0)
			cargaViral=0;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarEnemigoAlpha(this);
	}
}
