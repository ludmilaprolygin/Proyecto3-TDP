package Logica;

public final class Player extends Personaje{
	protected Arma arma;
	protected static Player player;
	
	private Player() {
		super();
		cargaViral = 0;
		velocidad = 0.6f;
		arma = new ArmaSanitaria();
	}
	
	public static Player instancia() {
		if(player == null) {
			player = new Player();
		}
		return player;
	}
	
	//Getters
	public Arma getArma() {
		return arma;
	}
	
	//Setters	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public void disparar() {
		arma.disparar();
	}
}
