package Logica;

public class VisitorPocion extends Visitor{

	protected PocionEspecial pocion;
	
	public VisitorPocion(PocionEspecial pocion) {
		this.pocion = pocion;
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
		
	}

	@Override
	public void visitarProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioPocion(PocionEspecial premio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioCuarentena(EfectoCuarentena efecto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremioSuperArma(EfectoSuperArmaSanitaria efecto) {
		// TODO Auto-generated method stub
		
	}
}
