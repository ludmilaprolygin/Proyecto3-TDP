package GUI;

import java.util.LinkedList;
import java.util.List;
import javax.swing.SwingUtilities;

import Logica.*;

public class ControlEntidades implements Runnable{
	protected List<Entidad> entidades;
	protected GUIJuego GUI;
	private List<Entidad> entidadesAux;
	
	public ControlEntidades(GUIJuego GUI) {
		this.GUI = GUI;
	}
	
	@Override
	public void run() {
		//TODO Auto-generated method stub
		do {
			entidades = Juego.instancia().getEntidades();
			clonarLista(entidades);
			
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            for(Entidad entidad : entidadesAux) { //Este for hace que todas las entidades jueguen
	            SwingUtilities.invokeLater(() -> {
	                int i=0;
	                Entidad entidadAux;
	                entidad.jugar();
	                while(i<entidades.size()) { //Este hace que vcada entidad interactúe con todas las otras
	                	entidadAux = entidades.get(i);
	                	if(!entidad.equals(entidadAux)) 
	                		entidad.aceptar(entidadAux.getVisitor());
	                	i++;
	                }
	            });
            }
  
            Nivel nivel = Juego.instancia().getNivel();
            GUI.actualizarCargaViral(Player.instancia().getCargaViral());
            GUI.getPanelMapa().moveToFront(Player.instancia().getEntidadGrafica());
            
            if(Player.instancia().murio())
        		GUI.perder();
            else {
            	if(!nivel.tieneInfectados()) {
	            	if(nivel.getNumeroTanda() == 1) {
	            		nivel.subirTanda();
	            		GUI.mostrarTandaSubida();
	            		GUI.cargarInfectados();
	            	}
	            	else {
	            		if(nivel.getNivel()<3) {
	            			nivel.subirNivel();
	            			GUI.mostrarNivelSubido();
	            			GUI.cargarInfectados();
	            		}
	            		else 
	            			GUI.ganar();
	            	}
            	}
            }
        } while (true);
	}
	
	private void clonarLista(List<Entidad> lista) {
		entidadesAux = new LinkedList<Entidad>();
		for(int i=0; i< lista.size();i++) {
			entidadesAux.add(i, lista.get(i));
		}
	}
}
