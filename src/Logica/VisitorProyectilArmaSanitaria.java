package Logica;

public class VisitorProyectilArmaSanitaria extends Visitor{

	protected ProyectilArmaSanitaria proyectil;
	
	public VisitorProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil) {
		this.proyectil = proyectil; 
	}

	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {
		// TODO Auto-generated method stub
		alpha.setCargaViral(alpha.getCargaViral() - proyectil.getPoder());
	}

	@Override
	public void visitarEnemigoBeta(Beta beta) {
		// TODO Auto-generated method stub
		beta.setCargaViral(beta.getCargaViral() - proyectil.getPoder());
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
