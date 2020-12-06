package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.*;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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
	protected Thread hiloJuego;
	protected Thread hiloInfectados;
	protected JLayeredPane panelMapa;
	protected JProgressBar barraCargaViral;
	protected JLabel labelPlayer; 
	protected JLabel labelNivel;
	protected JLabel labelTanda;
	protected JLabel labelPremio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SplashScreen s = new SplashScreen(4000);
		s.showSplash();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIJuego frame = new GUIJuego();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} 
				catch (Exception e) {
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
		//setBounds(100, 100, 901, 634);
		setBounds(74, 0, 857, 795);
		setTitle("Cuarentena forever");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cargarBarra();
		
		juego = Juego.instancia();
		juego.setNivel(new Nivel()); 
		juego.setGUI(this);
		
		generarMapa();
		
		controlPlayer = new ControlPlayer(this);
		addKeyListener(new Adapter());
		
		cargarInfectados();
		cargarMusica();
		cargarInformacion();
		
		controlEntidades = new ControlEntidades(this);
		hiloJuego = new Thread(controlEntidades);
		hiloJuego.start();
	}
	
	/*
	 * Crea y carga una barra de progreso que muestra la carga viral actual del player.
	 */
	protected void cargarBarra() {
		barraCargaViral = new JProgressBar(); //Muestra la carga viral del player
		barraCargaViral.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		barraCargaViral.setBackground(Color.GREEN);
		barraCargaViral.setStringPainted(true);
		barraCargaViral.setOrientation(SwingConstants.VERTICAL);
		barraCargaViral.setBounds(0, 43, 74, 667);
		contentPane.add(barraCargaViral);
	}
	
	protected void generarMapa(){		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(74, 0, 769, 667);
		contentPane.add(panelMapa);
		
		cargarFondo();
		cargarPlayer(); 

		barraCargaViral.setValue(Player.instancia().getCargaViral());
	}
	
	protected void cargarFondo() {
		JLabel labelMapa = new JLabel("");
		labelMapa.setBounds(0, 0, 857, 795);
		actualizar("fondo.jpg", labelMapa);
		panelMapa.add(labelMapa, 2);
	}
	
	protected void cargarPlayer() {
		String[] rutaplayer = {"player.png", "playerInfectado.png"};
		int posX, posY;
		
		Player.instancia().getEntidadGrafica().setPosX(panelMapa.getWidth()/2-60);
		posX = Player.instancia().getEntidadGrafica().getPosX();
		Player.instancia().getEntidadGrafica().setPosY(panelMapa.getHeight()-30);
		posY = Player.instancia().getEntidadGrafica().getPosY();
		Player.instancia().getEntidadGrafica().setBounds(posX, posY, 112, 122);
		Player.instancia().getEntidadGrafica().setImagenes(rutaplayer);
		Player.instancia().getEntidadGrafica().actualizar(0);
		panelMapa.add(Player.instancia().getEntidadGrafica(), 0);
	}
	
	protected void cargarInfectados() {		
		controlInfectados = new ControlInfectados(this);
		hiloInfectados = new Thread(controlInfectados);
		hiloInfectados.start();
	}
	
	public JLayeredPane getPanelMapa() { 
		return panelMapa;
	}
	
	public JProgressBar getBarraProgreso() { 
		return barraCargaViral;
	}
	
	public Thread getHiloInfectados() {
		return hiloInfectados;
	}
	
	/*
	 * Crea y carga un hilo que controla música para el juego y labels que manipulan el inicio y finalización del sonido.
	 */
	protected void cargarMusica() {
		try {
			music = new Music();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
		
		music.start();
		
		JLabel iniciar = new JLabel("");
		iniciar.setBounds(0, 0, 34, 42);
		contentPane.add(iniciar);
		actualizar("volumeup.png", iniciar);
		
		JLabel detener = new JLabel("");
		detener.setBounds(40, 0, 34, 42);
		contentPane.add(detener);
		actualizar("volumeoff.png", detener);
		
		detener.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				music.stop();
			}
		});
		
		iniciar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						music = new Music();
					} catch (FileNotFoundException | JavaLayerException e1) {
						e1.printStackTrace();
					}
					music.start();
				}
			});	
	}	
	
	/*
	 * Crea y carga un panel con labels que muestran el nivel y tanda corrientes y, avisa que premio se intercepta.
	 */
	protected void cargarInformacion() {
		JPanel panelMostrador = new JPanel();
		panelMostrador.setBackground(Color.DARK_GRAY);
		panelMostrador.setBounds(75, 668, 768, 42);
		contentPane.add(panelMostrador);
		panelMostrador.setLayout(null);
		
		labelNivel = new JLabel("Nivel: "+Juego.instancia().getNivel().getNivel());
		labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
		labelNivel.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 24));
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setBounds(40, 11, 135, 33);
		panelMostrador.add(labelNivel);
		
		labelTanda = new JLabel("Tanda: "+Juego.instancia().getNivel().getNumeroTanda());
		labelTanda.setHorizontalAlignment(SwingConstants.CENTER);
		labelTanda.setForeground(Color.WHITE);
		labelTanda.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 24));
		labelTanda.setBounds(633, 11, 124, 33);
		panelMostrador.add(labelTanda);
		
		labelPremio = new JLabel("");
		labelPremio.setHorizontalAlignment(SwingConstants.CENTER);
		labelPremio.setForeground(Color.WHITE);
		labelPremio.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 24));
		labelPremio.setBounds(240, 11, 364, 33);
		panelMostrador.add(labelPremio);
	}
	
	public void mostrarPremio(String string) {
		labelPremio.setText(string);
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				labelPremio.setText("");
			}	
		};
		timer.schedule(tarea, 3000);
	}
	
	public ImageIcon actualizar(String nombre, JLabel label) {
		String ruta = "/Imagenes/"+nombre;
		ImageIcon original = new ImageIcon(GUIJuego.class.getResource(ruta));
		ImageIcon icono = new ImageIcon(original.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		
		label.setIcon(icono);
		label.repaint();
		
		return icono;
	}
	
	public void perder() {
		hiloInfectados.interrupt();
		hiloJuego.interrupt();
		music.interrupt();
		JOptionPane.showMessageDialog(null, "Juego perdido.", "Lo siento.", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
	
	public void ganar() {
		hiloInfectados.interrupt();
		hiloJuego.interrupt();
		music.interrupt();
		JOptionPane.showMessageDialog(null, "Juego ganado.", "Felicidades",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public void mostrarTandaSubida() {
		JOptionPane.showInternalMessageDialog(null, "Tanda completada.", "Bien hecho", JOptionPane.INFORMATION_MESSAGE);
		labelTanda.setText("Tanda: "+Juego.instancia().getNivel().getNumeroTanda());
	}
	
	public void mostrarNivelSubido() {
		JOptionPane.showInternalMessageDialog(null, "Nivel completado.", "Bien hecho", JOptionPane.INFORMATION_MESSAGE);
		labelNivel.setText("Nivel: "+Juego.instancia().getNivel().getNivel());
		labelTanda.setText("Tanda: "+Juego.instancia().getNivel().getNumeroTanda());
	}
	
	public void actualizarCargaViral(int cargaViral) {
		barraCargaViral.setValue(cargaViral);
		Color color;
		if(cargaViral>=80)
			color = Color.RED;
		else
			color = Color.GREEN;
		barraCargaViral.setBackground(color);
		barraCargaViral.repaint();
	}
	
	private class Adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            controlPlayer.keyPressed(e);
        }
    }
}