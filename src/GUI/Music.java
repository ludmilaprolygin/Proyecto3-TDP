package GUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Logica.Juego;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread{
	protected final Player pl;
	
	public Music() throws FileNotFoundException, JavaLayerException {
		//String rutaArchivo = "Musica/Musica.mp3";
		pl = new Player(new FileInputStream("C:\\Users\\mlpro\\Documents\\Universidad\\Computacion\\2 - Tecnologia de la Programacion\\Practica\\Programas\\Proyecto 3\\src\\Musica\\Musica.mp3"));
	}
	
	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
            while (true) {
				pl.play();       
               }
        } 
		catch (JavaLayerException e) {
            e.printStackTrace();
         }
	}
}
