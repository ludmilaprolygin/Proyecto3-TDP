package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
    private int duration;

    public SplashScreen(int d) {
        duration = d;
    }

    public void showSplash() {
        this.setLocationByPlatform(true);

        JPanel content = (JPanel)getContentPane();
        content.setBackground(new java.awt.Color(191,191,191));
        content.setLayout(null);
        JLabel label = new JLabel();

        //Set the window's bounds, centering the window
        int width = 850;
        int height = 650;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        this.setBounds(x, y, 800, 600);  

        label.setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/fondosplash.jpg")));
        content.add(label, BorderLayout.CENTER);
        label.setBounds(0, 0, 800, 600);

        setVisible(true);

        try { 
        	Thread.sleep(duration); 
        }
        catch (Exception e) {}
        
        setLocationRelativeTo(null);
        setVisible(false);
        getContentPane().setBackground(new java.awt.Color(0,0,0));
        this.setOpacity(0.0f);
        content.add(label, "West");
    }
    
    public void showSplashAndExit() {
        showSplash();
    }
}