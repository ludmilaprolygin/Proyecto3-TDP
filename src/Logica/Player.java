package Logica;

public final class Player extends Personaje{
	protected Arma arma;
	protected static Player player;
	
	private Player() {
		super();
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
}
