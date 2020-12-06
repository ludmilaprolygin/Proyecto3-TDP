package Logica;

import java.util.LinkedList;
import java.util.List;

import GUI.GUIJuego;

public class Juego{
	protected GUIJuego GUI;
	protected Nivel nivel;
	protected List<Entidad> entidades;
	protected static Juego juego;
	protected boolean cuarentenaActivada = false;
	
	private Juego() {
		entidades = new LinkedList<Entidad>();
	}
	
	public static Juego instancia() {
		if(juego==null)
			juego = new Juego();
		return juego;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public GUIJuego getGUI() {
		return GUI;
	}
	
	public boolean cuarentenaActiva() {
		return cuarentenaActivada;
	}
	
	public void setCuarentenaActiva(boolean v) {
		cuarentenaActivada = v;
	}
	
	public void setGUI(GUIJuego GUI) {
		this.GUI = GUI;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public void addEntidad(Entidad entidad) {
		entidades.add(entidad);
	}
	
	public void removeEntidad(Entidad entidad) {
		entidades.remove(entidad);
	}
}