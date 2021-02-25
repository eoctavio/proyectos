package graficos;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscribiendoMarco {

	public static void main(String[] args) {
	
	 MarcoConTexto miMarco = new MarcoConTexto();
	 
	 miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}

class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer texto");
		Lamina miLamina = new Lamina();
		
		add(miLamina);
	}
}

class Lamina extends JPanel {
	
	public void paintComponent (Graphics g) {
		
		g.drawString("Estamos aprendiendo swing", 100, 100);
		super.paintComponents(g);
	}
	
}