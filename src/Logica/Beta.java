package Logica;

import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Beta extends Infectado{
	
	public Beta(int rango, int velocidad) {
		super(rango, velocidad);
		Random random = new Random();
		int valor = random.nextInt(2);
		String[] rutas1	= {"BETA1Infectado.png", "BETA1Desinfectado.png", "BETA1Comun.png"};
		String[] rutas2 = {"BETA2Infectado.png", "BETA2Desinfectado.png", "BETA2Comun.png"};
		if(valor == 0) {
			entidadGrafica.setImagenes(rutas1);
			entidadGrafica.setGrafico(new ImageIcon(rutas1[0]));
		}
		else {
			entidadGrafica.setImagenes(rutas2);
			entidadGrafica.setGrafico(new ImageIcon(rutas2[0]));
		}
		visitor = new VisitorBeta(this);
		setDa�o();
	}
	
	protected void setDa�o() {
		da�o = 3;
	}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarEnemigoBeta(this);
	}
}
