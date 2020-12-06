package Logica;

public class VisitorAlpha extends Visitor{

	protected Alpha alpha;
	
	public VisitorAlpha(Alpha alpha) {
		this.alpha = alpha;
	}

	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarEnemigoBeta(Beta beta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPlayer(Player player) {
		// TODO Auto-generated method stub
		if(alpha.getCargaViral()>0)
			player.recibirDaño(alpha.getDaño());
	}

	@Override
	public void visitarProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioPocion(PocionEspecial premio) {}

	@Override
	public void visitarPremioCuarentena(EfectoCuarentena efecto) {}

	@Override
	public void visitarPremioSuperArma(EfectoSuperArmaSanitaria efecto) {}
}
