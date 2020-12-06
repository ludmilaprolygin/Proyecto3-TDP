package GUI;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread{
	protected final Player pl;
	
	public Music() throws FileNotFoundException, JavaLayerException {
		String rutaArchivo = "Musica/Musica.mp3";
		InputStream in = Music.class.getClassLoader().getResourceAsStream(rutaArchivo);
		pl = new Player(in);
	}
	
	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
            while (!pl.isComplete()) {
				pl.play(); 
			}
        } 
		catch (JavaLayerException e) {
            e.printStackTrace();
        }
	}
}