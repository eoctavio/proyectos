package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {

	public static void main(String[] args) {
		
		MarcoAcciones marco = new MarcoAcciones();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoAcciones extends JFrame{
	
	public MarcoAcciones() {
		setTitle("Prueba acciones");
		setBounds(600, 350, 600, 300);
		PanelAccion lamina = new PanelAccion();
		add(lamina);
	}
}

class PanelAccion extends JPanel{
	
	public PanelAccion() {
		
		AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/agenda.gif"), Color.YELLOW);
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/agenda.gif"), Color.BLUE);
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/agenda.gif"), Color.RED);
		
		/*JButton botonAmarillo = new JButton("Amarillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");*/
		
		
		
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));
		
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		
		ActionMap mapaAccion = getActionMap();
		
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color colorBoton) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color" + nombre);
			putValue("color_de_fondo", colorBoton);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Color c = (Color) getValue("color_de_fondo");
			setBackground(c);
			
			System.out.println("Nombre: " + getValue(Action.NAME));
		}
		
    }

}