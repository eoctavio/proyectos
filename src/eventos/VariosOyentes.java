package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VariosOyentes {
	
	public static void main(String[] args) {
		MarcoPrincipal miMarco = new MarcoPrincipal();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

class MarcoPrincipal extends JFrame{
	
	public MarcoPrincipal() {
		setTitle("Prueba varios");
		setBounds(600, 100, 300, 200);
		LaminaPrincipal lamina = new LaminaPrincipal();
		add(lamina);

	}
}

class LaminaPrincipal extends JPanel{
	
	JButton botonCerrar;
	
	public LaminaPrincipal() {
		JButton botonNuevo = new JButton("Nuevo");
		add(botonNuevo);
		botonCerrar = new JButton("Cerrar todo");
		add(botonCerrar);
		
		OyenteNuevo miOyente = new OyenteNuevo();
		
		botonNuevo.addActionListener(miOyente);
	}
	
	private class OyenteNuevo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MarcoEmergente marco = new MarcoEmergente(botonCerrar);
			marco.setVisible(true);
			
		}
		
		
	}
}

class MarcoEmergente extends JFrame{
	
	private static int contador = 0;
	public MarcoEmergente(JButton botonPrincipal) {
		contador ++;
		setTitle("Ventana " + contador);
		setBounds(40 * contador, 40 * contador, 300, 150);
		CierraTodos oyenteCerra = new CierraTodos();
		botonPrincipal.addActionListener(oyenteCerra);
	}
	
	private class CierraTodos implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
		
	}
}