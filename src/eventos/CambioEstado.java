package eventos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioEstado {

	public static void main(String[] args) {
		
		MarcoEstado miMarco = new MarcoEstado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoEstado extends JFrame {

	public MarcoEstado() {
		setVisible(true);
		
		setBounds(300, 300, 500, 350);
		
		CambiaEstado nuevoEstado = new CambiaEstado();
		
		addWindowStateListener(nuevoEstado);
	}
	
}

class CambiaEstado implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		
		System.out.println("La ventana ha cambiado de estado");
		
		//System.out.println(e.getNewState());
		
		if(e.getNewState() == Frame.MAXIMIZED_BOTH) {
		   System.out.println("La pantalla esta en pantalla completa");
		}
		
	}
	
}