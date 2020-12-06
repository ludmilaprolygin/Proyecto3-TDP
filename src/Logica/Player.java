package Logica;

import java.util.Timer;
import java.util.TimerTask;

public final class Player extends Personaje{
	protected Arma arma;
	protected static Player player;
	protected boolean efectoActivado;
	
	private Player() {
		super();
		visitor = new VisitorPlayer(this);
		cargaViral = 0;
		velocidad = 7;
		arma = new ArmaSanitaria();
	}
	
	public static Player instancia() {
		if(player == null) {
			player = new Player();
		}
		return player;
	}
	
	public Arma getArma() {
		return arma;
	}
		
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void disparar(int p) {
		if(!efectoActivado)
			arma.disparar(p);
		else
			arma.disparar(p*2);
	}
	
	public boolean efectoActivado() {
		return efectoActivado;
	}
	
	public void setEfectoActivado(boolean v) {
		efectoActivado=v;
	}
	
	public void recibirDaño(int d) {
		int daño = -d;
		
		super.recibirDaño(daño);
		if(d!=0) {
			entidadGrafica.actualizar(1);
			Timer timer = new Timer();
			TimerTask tarea = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					entidadGrafica.actualizar(0);
				}	
			};
			timer.schedule(tarea, 4000);
		}
	}
	
	public boolean murio() { 
		return cargaViral>=100;
	}

	@Override
	public void jugar() {}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPlayer(this);
	}
}
