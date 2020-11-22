package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GUIJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected Juego juego;
	protected ControlInfectados controlInfectados; //NUEVO
	protected ControlPlayer controlPlayer; //NUEVO
	protected JLayeredPane panelMapa; //NUEVO
	protected JLabel labelPlayer; //NUEVO

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
	 */
	public GUIJuego() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 835);
		setTitle("Cuarentena forever");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar cargaViral = new JProgressBar();
		cargaViral.setStringPainted(true);
		cargaViral.setOrientation(SwingConstants.VERTICAL);
		cargaViral.setBounds(0, 0, 74, 700);
		contentPane.add(cargaViral);
		
		juego = new Juego();
		generarMapa();
		controlPlayer = new ControlPlayer(this);
		addKeyListener(new Adapter());
		cargarInfectados();
	}
	
	protected void generarMapa(){		
		panelMapa = new JLayeredPane();
		panelMapa.setBounds(74, 0, 857, 700);
		contentPane.add(panelMapa);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUIJuego.class.getResource("/Imagenes/ALPHA1Comun.png")));
		lblNewLabel.setBounds(135, 114, 49, 14);
		panelMapa.add(lblNewLabel, 0);
		
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
	}
	
	protected void cargarInfectados() { //NUEVO
		controlInfectados = new ControlInfectados(this);
		Thread hiloInfectados = new Thread(controlInfectados);
		hiloInfectados.start();
	}
	
	protected ImageIcon actualizar(String nombre, JLabel label) {
		String ruta = "/Imagenes/"+nombre;
		ImageIcon original = new ImageIcon(GUIJuego.class.getResource(ruta));
		ImageIcon icono = new ImageIcon(original.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
		label.setIcon(icono);
		label.repaint();
		return icono;
	}
	
	public Juego getJuego() { //NUEVO
		return juego;
	}
	
	public JLayeredPane getPanelMapa() { //NUEVO
		return panelMapa;
	}
	
	public JLabel getLabelPlayer() { //NUEVO
		return labelPlayer;
	}
	
	private class Adapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            controlPlayer.keyPressed(e);
        }
    }
}
