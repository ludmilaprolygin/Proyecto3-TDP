package Logica;

public class VisitorEfectoSuperArma extends Visitor{
	
	protected EfectoSuperArmaSanitaria efecto;

	public VisitorEfectoSuperArma(EfectoSuperArmaSanitaria efecto) {
		this.efecto = efecto;
	}
	
	@Override
	public void visitarPlayer(Player player) {
		// TODO Auto-generated method stub
		if (intersects(efecto.getEntidadGrafica(), player.getEntidadGrafica()) ) {
			efecto.aplicarEfecto();
			efecto.getEntidadGrafica().setVisible(false);
			Juego.instancia().removeEntidad(efecto);
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
