package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.*;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

public class GUIJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected Juego juego;
	protected Music music;
	protected ControlInfectados controlInfectados; 
	protected ControlPlayer controlPlayer;
	protected ControlEntidades controlEntidades;
	protected JLayeredPane panelMapa; 
	protected JLabel labelPlayer; 
	protected JProgressBar cargaViral;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIJuego frame = new GUIJuego();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public GUIJuego(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 826);
		setTitle("Cuarentena forever");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargaViral = new JProgressBar();
		cargaViral.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		cargaViral.setBackground(Color.GREEN);
		cargaViral.setStringPainted(true);
		cargaViral.setOrientation(SwingConstants.VERTICAL);
		cargaViral.setBounds(0, 39, 74, 756);
		contentPane.add(cargaViral);
		
		juego = Juego.instancia();
		juego.setNivel(new Nivel()); 
		
		for(int i=0; i<juego.getEntidades().size(); i++)
			System.out.println(i+1);
		
		generarMapa();
		controlPlayer = new ControlPlayer(this);
		addKeyListener(new Adapter());
		cargarInfectados();
		cargarMusica();
		controlEntidades = new ControlEntidades(this);
		Thread hilo = new Thread(controlEntidades);
		hilo.start();
	}
	
	protected void generarMapa(){		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(74, 0, 857, 795);
		contentPane.add(panelMapa);
		
		//Cargar el fondo
		JLabel labelMapa = new JLabel("");
		labelMapa.setBounds(0, 0, 857, 700);
		actualizar("fondo.jpg", labelMapa);
		panelMapa.add(labelMapa, 1);
		
		//Cargar el player
		labelPlayer = new JLabel("");
		labelPlayer.setBounds(panelMapa.getWidth()/2, 519, 146, 169);
		actualizar("player.png", labelPlayer);
		panelMapa.add(labelPlayer, 0);
		
		//Setear la carga del player
		cargaViral.setValue(Player.instancia().getCargaViral());
	}
	
	protected void cargarInfectados() { 
		controlInfectados = new ControlInfectados(this);
		Thread hiloInfectados = new Thread(controlInfectados);
		hiloInfectados.start();
	}
	
	protected void cargarMusica() {
		try {
			music = new Music();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
		music.start();
		
		//boton iniciar musica
		
		JLabel iniciar = new JLabel("");
		iniciar.setBounds(0, 0, 34, 38);
		actualizar("volumeup.png", iniciar);
		contentPane.add(iniciar);
		
		iniciar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						music = new Music();
					} catch (FileNotFoundException | JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					music.start();
				}
			});	
			
		JLabel detener = new JLabel("");
		detener.setBounds(40, 0, 34, 38);
		actualizar("volumeoff.png", detener);
		contentPane.add(detener);	
		
		detener.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				music.stop();
			}
		});
	}
	
	protected ImageIcon actualizar(String nombre, JLabel label) {
		String ruta = "/Imagenes/"+nombre;
		ImageIcon original = new ImageIcon(GUIJuego.class.getResource(ruta));
		ImageIcon icono = new ImageIcon(original.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(icono);
		label.repaint();
		return icono;
	}
	
	public Juego getJuego() { 
		return juego;
	}
	
	public JLayeredPane getPanelMapa() { 
		return panelMapa;
	}
	
	public JLabel getLabelPlayer() { 
		return labelPlayer;
	}
	
	public JProgressBar getProgreso() { 
		return cargaViral;
	}
	
	private class Adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            controlPlayer.keyPressed(e);
        }
    }
}