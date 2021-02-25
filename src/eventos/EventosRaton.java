package eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventosRaton {
	
   public static void main(String[] args) {
	   
	   MarcoRaton miMarco = new MarcoRaton();
	   
	   miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
   }

}

class MarcoRaton extends JFrame {
	
	public MarcoRaton() {
		setVisible(true);
		setBounds(700, 300, 600, 450);
		
		//EventoRaton evento = new EventoRaton();
		EventosDeRaton evento = new EventosDeRaton();
		//addMouseListener(evento);
		addMouseMotionListener(evento);
	}
}

class EventoRaton implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Haz hecho click");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Acabas de entrar");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Acabas de salir");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("Acabas de presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	System.out.println("Acabas de levantar");
		
	}
	
}
/*
class EventosDeRaton extends MouseAdapter{
	
	public void mouseClicked(MouseEvent e) {
		//System.out.println("coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());
		System.out.println(e.getClickCount());
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has pulsado el boton izquierdo");
		} else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("Has pulsado la rueda del raton");
		} else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Has pulsado el boton derecho del raton");
		}
		System.out.println(e.getModifiersEx());
	}
}*/

class EventosDeRaton implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("Estas arrastrando");
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		System.out.println("Estas moviendo");
		
	}
	
}