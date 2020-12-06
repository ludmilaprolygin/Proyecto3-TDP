package Logica;

import java.util.Timer;
import java.util.TimerTask;

public class EfectoSuperArmaSanitaria extends EfectoTemporal{

	public EfectoSuperArmaSanitaria() {
		super();
		visitor = new VisitorEfectoSuperArma(this);
	}

	public void aplicarEfecto() {
		super.aplicarEfecto();
		Player.instancia().setEfectoActivado(true);
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Player.instancia().setEfectoActivado(false);
			}	
		};
		timer.schedule(tarea, 10000);
	}
	
	public String toString() {
		return "Super Arma Sanitaria";
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioSuperArma(this);
	}
}
