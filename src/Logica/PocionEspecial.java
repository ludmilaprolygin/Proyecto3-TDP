package Logica;

public class PocionEspecial extends ObjetoPrecioso{

	public PocionEspecial() {
		super();
		visitor = new VisitorPocion(this);
	}

	public void aplicarEfecto() {
		Player player = Player.instancia();
		
		super.aplicarEfecto();
		
		int cargaViral = player.getCargaViral();
		cargaViral -= cargaViral/3;
		
		if(cargaViral<0)
			cargaViral=0;
		
		player.setCargaViral(cargaViral);
		Juego.instancia().getGUI().getBarraProgreso().setValue(player.getCargaViral());
	}
	
	public String toString() {
		return "Pocion Especial";
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPremioPocion(this);
	}
}
