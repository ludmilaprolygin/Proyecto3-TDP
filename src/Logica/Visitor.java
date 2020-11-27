package Logica;

import java.awt.geom.Area;

import javax.swing.JLabel;

public abstract class Visitor
{
	public abstract void visitarEnemigoAlpha(Alpha alpha);
	
	public abstract void visitarEnemigoBeta(Beta beta);
	
	public abstract void visitarPlayer(Player player);
	
	public abstract void visitarProyectilArmaSanitaria(ProyectilArmaSanitaria proyectil);
	
	public abstract void visitarPremioPocion(PocionEspecial premio);
	
	public abstract void visitarPremioCuarentena(EfectoCuarentena efecto);
	
	public abstract void visitarPremioSuperArma(EfectoSuperArmaSanitaria efecto);
	
	public boolean intersects(JLabel labelA, JLabel labelB){
	    Area areaA = new Area(labelA.getBounds());
	    Area areaB = new Area(labelB.getBounds());

	    return areaA.intersects(areaB.getBounds2D());
	}
}