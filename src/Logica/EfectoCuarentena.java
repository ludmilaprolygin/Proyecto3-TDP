package Logica;

//import java.util.ArrayList;

public class EfectoCuarentena extends EfectoTemporal{
	protected Nivel nivel;
	
	public EfectoCuarentena(Nivel nivel) {
		super();
		/*
		ArrayList<Infectado> infectados;
		this.nivel = nivel;
		infectados = nivel.getInfectados().getInfectados();
		/*
		for(Infectado infectado : infectados) //Parte gráfica
			infectado.desplazar(false);
		*/	
		//Thread ??? Hacer un hold del tiempo y dsp atr vuelve
	}
}
