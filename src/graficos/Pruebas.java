package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class Pruebas {
	
	public static void main(String[] args) {
	
		String fuente = JOptionPane.showInputDialog("Introduce fuente");
		
		boolean isFont = false;
		
		
		
		String [] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String nombreFuente : nombresDeFuentes) {
			
		    if(nombreFuente.equals(fuente)) {
		    	isFont = true;
		    }
		}
		
		if(isFont) {
			System.out.println("Fuente instalada");
		} else {
			System.out.println("No está instalada la fuente");
		}
			
	}

}
