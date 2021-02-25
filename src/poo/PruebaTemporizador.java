package poo;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameLaHora listener = new DameLaHora();
		
		Timer miTemporizador = new Timer(5000, listener);
		
		miTemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		System.exit(0);
		
	}

}

class DameLaHora implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Date ahora = new Date();
		
		System.out.println("Te pongo la hora cada 5 segundos " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
	}
	
	
	
}