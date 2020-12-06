package Logica;

public class VisitorProyectilArmaSanitaria extends Visitor{

	protected ProyectilArmaSanitaria proyectil;
	
	public VisitorProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {
		this.proyectil = proyectil; 
	}

	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {
		// TODO Auto-generated method stub
		visitarEnemigo(alpha);
	}

	@Override
	public void visitarEnemigoBeta(Beta beta) {
		// TODO Auto-generated method stub
		visitarEnemigo(beta);
	}
	
	protected void visitarEnemigo(Infectado infectado) {
		if (intersects(infectado.getEntidadGrafica(), proyectil.getEntidadGrafica()) && infectado.getCargaViral() > 0) {
			infectado.recibirDaño(Player.instancia().getArma().getProyectil().getPoder());
			proyectil.getEntidadGrafica().setVisible(false);
			Juego.instancia().removeEntidad(proyectil);
		}
	}

	@Override
	public void visitarPlayer(Player player) {}

	@Override
	public void visitarProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {}

	@Override
	public void visitarPremioPocion(PocionEspecial premio) {}

	@Override
	public void visitarPremioCuarentena(EfectoCuarentena efecto) {}

	@Override
	public void visitarPremioSuperArma(EfectoSuperArmaSanitaria efecto) {}
}
