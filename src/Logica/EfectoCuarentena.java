package Logica;

import java.util.Timer;
import java.util.TimerTask;

public class EfectoCuarentena extends EfectoTemporal{
	protected Nivel nivel;
	protected final int tiempo = 10000;
	
	public EfectoCuarentena() {
		super();
		visitor = new VisitorEfectoCuarentena(this);
	}
	
	public void aplicarEfecto() {
		super.aplicarEfecto();
		Juego.instancia().setCuarentenaActiva(true);
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Juego.instancia().setCuarentenaActiva(false);
			}	
		};
		timer.schedule(tarea, tiempo);
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public String toString() {
		return "Efecto Cuarentena";
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioCuarentena(this);
	}
}
