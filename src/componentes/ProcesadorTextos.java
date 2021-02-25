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
import javax.swing.text.StyledEditorKit;

public class ProcesadorTextos {
	
	public static void main(String[] args) {
		MenuProcesadorTextos miMarco = new MenuProcesadorTextos();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}

class MenuProcesadorTextos extends JFrame{
	public MenuProcesadorTextos() {
		
		setBounds(500, 300, 550, 400);
		
		LaminaProcesadorTextos miLamina = new LaminaProcesadorTextos();
		
		add(miLamina);
		
		setVisible(true);
	}
}

class LaminaProcesadorTextos extends JPanel{
	
	JTextPane miArea;
	JMenu fuente, estilo, tamano;
	Font letras;
	
	public LaminaProcesadorTextos() {
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
			if(tipoLetra == "Arial") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Arial"));
			} else if(tipoLetra == "Courier") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Courier"));
			} else if(tipoLetra == "Verdana") {
				elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Verdana"));
			}
			
		} else if(menu.equals("estilo")) {
			estilo.add(elemMenu);
			if(estilos == Font.BOLD) {
				elemMenu.addActionListener(new StyledEditorKit.BoldAction());
			} else if(estilos == Font.ITALIC) {
				elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
			
		} else if(menu.equals("tamano")) {
			tamano.add(elemMenu);
			elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamano", tam));
		}
		
	}

}