package Logica;

public class VisitorPlayer extends Visitor{

	protected Player player;
	
	public VisitorPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {}

	@Override
	public void visitarEnemigoBeta(Beta beta) {}

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