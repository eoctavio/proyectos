package componentes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class MarcoEmergente {

	public static void main(String[] args) {
		MarcoEmergenteM miMarco = new MarcoEmergenteM();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEmergenteM extends JFrame{
	
	public MarcoEmergenteM() {
		 setBounds(100, 100, 300, 250);
		 
		 LaminaEmergenteM miLamina = new LaminaEmergenteM();
		 add(miLamina);
		 setVisible(true);
	}
}

class LaminaEmergenteM extends JPanel{
	
	public LaminaEmergenteM() {
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamano = new JMenu("Tamaño");
		
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		laminaMenu.add(miBarra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		JTextPane miArea = new JTextPane();
		
		add(miArea, BorderLayout.CENTER);
	
		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opcion 1");
		JMenuItem opcion2 = new JMenuItem("Opcion 2");
		JMenuItem opcion3 = new JMenuItem("Opcion 3");
		
		
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		miArea.setComponentPopupMenu(emergente);
		
	}
}