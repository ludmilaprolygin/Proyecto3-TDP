package Logica;

public class VisitorProyectil extends Visitor{

	protected Proyectil proyectil;
	
	public VisitorProyectil(Proyectil proyectil) {
		this.proyectil = proyectil; 
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
