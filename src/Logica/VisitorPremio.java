package Logica;

public class VisitorPremio extends Visitor{

	protected Premio premio;
	
	public VisitorPremio(Premio premio) {
		this.premio = premio;
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
	public void visitarProyectil(Proyectil proyectil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremio(Premio premio) {
		// TODO Auto-generated method stub
		
	}

}
