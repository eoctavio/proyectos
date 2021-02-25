package componentes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MarcoRadio {
	
	public static void main(String[] args) {
		
		MarcoRad miMarco = new MarcoRad();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoRad extends JFrame{
	
	public MarcoRad() {
		setVisible(true);
		setBounds(550, 300, 500, 550);
		
		LaminaRad miLamina = new LaminaRad();
		
		add(miLamina);
		
	}	
}

class LaminaRad extends JPanel{
	
	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
	private ButtonGroup miGrupo;
	private JPanel laminaBotones;
	
	public LaminaRad() {
		setLayout(new BorderLayout());
		
		texto = new JLabel("Mexico siempre ha tenido los peores gobiernos...");
		
		texto.setFont(new Font("Serif", Font.PLAIN, 12));
		
		add(texto, BorderLayout.CENTER);
		
		laminaBotones = new JPanel();
		
		miGrupo = new ButtonGroup();
		
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Muy Grande", false, 26);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
	}
	
	public void colocarBotones(String nombre, boolean seleccionado, final int tamano) {
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		miGrupo.add(boton);
		laminaBotones.add(boton);
		
		ActionListener miEvento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif", Font.PLAIN, tamano));
				
			}
		};
		
		boton.addActionListener(miEvento);
		
	}
	
}