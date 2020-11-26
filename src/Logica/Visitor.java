package Logica;

public abstract class Visitor
{
	public abstract void visitarEnemigoAlpha(Alpha alpha);
	
	public abstract void visitarEnemigoBeta(Beta beta);
	
	public abstract void visitarPlayer(Player player);
	
	public abstract void visitarProyectil(Proyectil proyectil);
	
	public abstract void visitarPremio(Premio premio);
}