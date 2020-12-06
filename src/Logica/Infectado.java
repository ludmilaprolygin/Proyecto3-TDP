package Logica;

import java.util.Random;
import java.util.TimerTask;

import GUI.EntidadGrafica;

import java.util.Timer;

public abstract class Infectado extends Personaje{
	protected int rango;
	protected int daño;
	protected Timer timer;
	protected boolean infecto;
	
	public Infectado(int rango, int velocidad) {
		super();
		cargaViral = 100;
		this.rango = rango;
		this.velocidad = velocidad;
	}
	
	public int getRango() {
		return rango;
	} 
	
	/*
	 * Retorna cuanto daño hace el infectado.
	 */
	public int getDaño() {
		int toReturn;
		EntidadGrafica entidadGrafica = Player.instancia().getEntidadGrafica();
		int distancia = distancia(entidadGrafica.getPosX(), entidadGrafica.getPosY());
		
		if(distancia<=rango && !infecto) {
			toReturn=daño;
			infecto = true;
		}
		else
			toReturn = 0;
		
		return toReturn;
	}
	
	public void recibirDaño(int d) {
		Random rnd = new Random();
		int valor;
		Premio p;
		
		super.recibirDaño(d);
		
		if(cargaViral<=0) {
			entidadGrafica.actualizar(1);
			Timer timer = new Timer();
			TimerTask tarea = new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					entidadGrafica.actualizar(2);
				}	
			};
			
			timer.schedule(tarea,3000);
			setDaño(0);
			
			valor = rnd.nextInt(9);
			if(valor==0) {
				 p = new PocionEspecial();
				 cargar(p);
				 Juego.instancia().addEntidad(p);
			}  
			if(valor==3) {
				p = new EfectoCuarentena();
				cargar(p);
				Juego.instancia().addEntidad(p);
			}
			if(valor==6) {
				p = new EfectoSuperArmaSanitaria();
				cargar(p);
				Juego.instancia().addEntidad(p);
			}
		}
					 
	}
	
	protected abstract void setDaño(int d);
	
	public void jugar() { 
		int movimiento = entidadGrafica.getPosY() + velocidad;
		Juego juego = Juego.instancia();
		if(!juego.cuarentenaActiva()) {
			entidadGrafica.setPosY(movimiento);
	
			if(entidadGrafica.getY()>juego.getGUI().getPanelMapa().getHeight()) {
				if(cargaViral<=0) {
					juego.removeEntidad(this);
					juego.getNivel().eliminarInfectado(this);
				}
				else {
					entidadGrafica.setPosY(0);
					infecto=false;
				}
			}
		}	
	}
	
	protected int distancia(int posXplayer, int posYplayer) {
		int toReturn;
		int dx = posXplayer - entidadGrafica.getPosX();
		int dy = posYplayer - entidadGrafica.getPosY();
		toReturn = (int) Math.sqrt(dx*dx + dy*dy);
		return toReturn;
	}
	
	protected void cargar(Premio premio) { 
		int posX = getEntidadGrafica().getPosX();
		int posY = getEntidadGrafica().getPosY();
		EntidadGrafica entidadGraficaPremio = premio.getEntidadGrafica();
		
		entidadGraficaPremio.setPosX(posX);
		entidadGraficaPremio.setPosY(posY);
		entidadGraficaPremio.setBounds(posX+25, posY+85, 40, 60);
		
		Juego.instancia().getGUI().actualizar(premio.getEntidadGrafica().getImagenes()[0], premio.getEntidadGrafica());
		Juego.instancia().getGUI().getPanelMapa().add(premio.getEntidadGrafica(), 0);
	}
}
