package componentes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

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
		
		configuraMenu("Arial", "fuente", "Arial", 9, 10, "");
		configuraMenu("Courier", "fuente", "Courier", 9, 10, "");
		configuraMenu("Verdana", "fuente", "Verdana", 9, 10, "");
		
		configuraMenu("Negrita", "estilo", "", Font.BOLD, 1, "bin/graficos/icono.gif");
		configuraMenu("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/graficos/icono.gif");
		
	/*	JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon( "bin/graficos/icono.gif"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon( "bin/graficos/icono.gif"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		
		estilo.add(negrita);
		estilo.add(cursiva);*/
		
		/*configuraMenu("12", "tamano", "", 9, 12, "");
		configuraMenu("16", "tamano", "", 9, 16, "");
		configuraMenu("20", "tamano", "", 9, 20, "");
		configuraMenu("24", "tamano", "", 9, 24, "");*/
		
		ButtonGroup tamanoLetra = new ButtonGroup();
		
		JRadioButtonMenuItem _12 = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem _16= new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem _20 = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem _24 = new JRadioButtonMenuItem("24");
		
		tamanoLetra.add(_12);
		tamanoLetra.add(_16);
		tamanoLetra.add(_20);
		tamanoLetra.add(_24);
		
		_12.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
		_16.addActionListener(new StyledEditorKit.FontSizeAction("", 16));
		_20.addActionListener(new StyledEditorKit.FontSizeAction("", 20));
		_24.addActionListener(new StyledEditorKit.FontSizeAction("", 24));
		
		tamano.add(_12);
		tamano.add(_16);
		tamano.add(_20);
		tamano.add(_24);
		
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		laminaMenu.add(miBarra);
		
		add(laminaMenu, BorderLayout.NORTH);
		
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		
		///////////////////////////////////////////////////
		

		JPopupMenu emergente = new JPopupMenu();
		
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		
		emergente.add(negritaE);
		emergente.add(cursivaE);
		
		miArea.setComponentPopupMenu(emergente);
		
	}
	
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam, String ubicacion) {
		
		JMenuItem elemMenu = new JMenuItem(rotulo, new ImageIcon(ubicacion));
		
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