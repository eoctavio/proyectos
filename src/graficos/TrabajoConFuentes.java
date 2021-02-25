package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajoConFuentes {

	public static void main(String[] args) {
		
		MarcoConFuentes miMarco = new MarcoConFuentes();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);

	}

}

class MarcoConFuentes extends JFrame {
	
	public MarcoConFuentes() {
		
		setTitle("Prueba con fuenets");
		
		setSize(400, 400);
		
		LaminaConFuentes miLamina = new LaminaConFuentes();
		
		add(miLamina);
		
		miLamina.setForeground(Color.BLUE);
		
	}
}

class LaminaConFuentes extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Font miFuente = new Font("Calibri", Font.BOLD, 26);
		
		g2.setFont(miFuente);
		
		g2.setColor(Color.BLUE);
		g2.drawString("Octavio", 100, 100);
		
		g2.setFont(new Font("Arial", Font.ITALIC, 24));
		
		g2.setColor(new Color(128, 90, 50).brighter());
		
		g2.drawString("Curso java", 100, 200);
		
			
	}
}