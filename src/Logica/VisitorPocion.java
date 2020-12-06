package Logica;

public class VisitorPocion extends Visitor{

	protected PocionEspecial pocion;
	
	public VisitorPocion(PocionEspecial pocion) {
		this.pocion = pocion;
	}
	
	@Override
	public void visitarPlayer(Player player) {
		// TODO Auto-generated method stub
		if (intersects(pocion.getEntidadGrafica(), player.getEntidadGrafica()) ) {
			pocion.aplicarEfecto();
			pocion.getEntidadGrafica().setVisible(false);
			Juego.instancia().removeEntidad(pocion);
		}
	}

	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {}

	@Override
	public void visitarEnemigoBeta(Beta beta) {}

	@Override
	public void visitarProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {}

	@Override
	public void visitarPremioPocion(PocionEspecial premio) {}

	@Override
	public void visitarPremioCuarentena(EfectoCuarentena efecto) {}

	@Override
	public void visitarPremioSuperArma(EfectoSuperArmaSanitaria efecto) {}
}
