package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoColores {

	public static void main(String[] args) {
		
		MarcoConColor miMarco = new MarcoConColor();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);

	}
	


}

class MarcoConColor extends JFrame {
	
	public MarcoConColor() {
		
		setTitle("Prueba con colores");
		
		setSize(400, 400);
		
		LaminaConColor miLamina = new LaminaConColor();
		
		add(miLamina);
		
		miLamina.setBackground(SystemColor.window);
	}
}

class LaminaConColor extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectamgulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.setPaint(Color.WHITE);
		g2.draw(rectamgulo);
		g2.setPaint(Color.BLACK);
		
		g2.fill(rectamgulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectamgulo);
		
		g2.setPaint(new Color(0, 140,255).brighter());
		
		g2.fill(elipse);
		
		g2.draw(elipse);
	}
}
