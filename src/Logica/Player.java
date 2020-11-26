package Logica;

import java.util.List;

public final class Player extends Personaje{
	protected Arma arma;
	protected static Player player;
	
	private Player() {
		super();
		visitor = new VisitorPlayer(this);
		cargaViral = 0;
		velocidad = 7;
		arma = new ArmaSanitaria();
	}
	
	public static Player instancia() {
		if(player == null) {
			player = new Player();
		}
		return player;
	}
	
	public Arma getArma() {
		return arma;
	}
		
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void disparar() {
		arma.disparar();
	}

	@Override
	public void jugar() {}

	@Override
	public List<Entidad> detectarColisiones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		v.visitarPlayer(this);
	}
}
