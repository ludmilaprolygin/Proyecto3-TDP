package Logica;

public class VisitorAlpha extends Visitor{

	protected Alpha alpha;
	
	public VisitorAlpha(Alpha alpha) {
		this.alpha = alpha;
	}
	
	@Override
	public void visitarEnemigoAlpha(Alpha alpha) {
		// TODO Auto-generated method stub
		//Como se mueve
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