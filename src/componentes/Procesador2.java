package componentes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Procesador2 {
	
	public static void main(String[] args) {
		MenuProcesador2 miMarco = new MenuProcesador2();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}

class MenuProcesador2 extends JFrame{
	public MenuProcesador2() {
		
		setBounds(500, 300, 550, 400);
		
		LaminaProcesador2 miLamina = new LaminaProcesador2();
		
		add(miLamina);
		
		setVisible(true);
	}
}

class LaminaProcesador2 extends JPanel{
	
	JTextPane miArea;
	JMenu fuente, estilo, tamano;
	Font letras;
	
	public LaminaProcesador2() {
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		JMenuBar miBarra = new JMenuBar();
		
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tamaño");
		
		configuraMenu("Arial", "fuente", "Arial", 9, 10);
		configuraMenu("Courier", "fuente", "Courier", 9, 10);
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10);
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1);
		
		configuraMenu("12", "tamano", "", 9, 12);
		configuraMenu("16", "tamano", "", 9, 16);
		configuraMenu("20", "tamano", "", 9, 20);
		configuraMenu("24", "tamano", "", 9, 24);
		
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		laminaMenu.add(miBarra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		
	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {
		
		JMenuItem elemMenu = new JMenuItem(rotulo);
		
		if(menu.equals("fuente")) {
			fuente.add(elemMenu);
		} else if(menu.equals("estilo")) {
			estilo.add(elemMenu);
		} else if(menu.equals("tamano")) {
			tamano.add(elemMenu);
		}
		
		elemMenu.addActionListener(new GestionaEventos(rotulo, tipoLetra, estilos, tam));
	}
	
	private class GestionaEventos implements ActionListener{
		
		String tipoTexto, menu;
		int estiloLetra, tamanoLetra;
		
		public GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra) {
			
			this.tipoTexto = texto2;
			this.estiloLetra = estilo2;
			this.tamanoLetra = tamLetra;
			this.menu = elemento;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			letras = miArea.getFont();
			
			if(menu.equals("Arial") || menu.equals("Courier") || menu.equals("Verdana")) {
				
				estiloLetra = letras.getStyle();
				tamanoLetra = letras.getSize();
			} else if(menu.equals("Cursiva") || menu.equals("Negrita")) {
				
				if(letras.getStyle() == 1 || letras.getStyle() == 2) {
					estiloLetra = 3;
				}
				tipoTexto = letras.getFontName();
				tamanoLetra = letras.getSize();
			} else if(menu.equals("12") || menu.equals("16") || menu.equals("20") || menu.equals("24")) {
				estiloLetra = letras.getStyle();
				tipoTexto = letras.getFontName();
			}
			
			miArea.setFont(new Font(tipoTexto, estiloLetra, tamanoLetra));
			
			System.out.println("Tipo: " + tipoTexto);
			System.out.println("Estilo: " + estiloLetra);
			System.out.println("Tamaño: " + tamanoLetra);
			
		}
		
		
	}
	

}