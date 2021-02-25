package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {
	
	public static void main(String[] args) {
		
		MarcoConDibujos miMarco = new MarcoConDibujos();
		
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setLocation(500, 150);
		
	}

}

class MarcoConDibujos extends JFrame {
	
	public MarcoConDibujos() {
		setTitle("Prueba Dibujos");
		setSize(400, 400);
		LaminaConFiguras miLamina = new LaminaConFiguras();
	    add(miLamina);
	}
}

class LaminaConFiguras extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//g.drawRect(100, 50, 200, 200);
		//g.drawLine(100, 100, 300, 200);
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		
		g2.draw(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double centroEnX = rectangulo.getCenterX();
		double centroEnY = rectangulo.getCenterY();
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		
		circulo.setFrame(centroEnX, centroEnY, centroEnX + radio, centroEnY + radio);
		
		g2.draw(circulo);
	}
	
}