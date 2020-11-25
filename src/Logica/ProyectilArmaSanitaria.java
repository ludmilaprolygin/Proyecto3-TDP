package Logica;

public class ProyectilArmaSanitaria extends Proyectil{
	
	public ProyectilArmaSanitaria() {
		super();
		velocidad = 1;
		municion = 20;
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
		//Relación con el Visitor!!!
		int posInicial = entidadGrafica.getPosY();
		entidadGrafica.setPosY(posInicial - velocidad);
		//if(entidadGrafica.getPosY()==0) 
			//Juego.instancia().removeEntidad(this);
	}
}
