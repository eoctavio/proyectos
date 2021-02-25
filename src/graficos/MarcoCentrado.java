package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MarcoCentrado {

	public static void main(String[] args) {
		
		Marco miMarco = new Marco();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		miMarco.setVisible(true);

	}

}

class Marco extends JFrame {
	
	
	public Marco() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setSize(anchoPantalla / 2, alturaPantalla /2);
		setLocation(anchoPantalla /4, alturaPantalla /4);
		setTitle("Marco centrado");
		
		Image miIcono = miPantalla.getImage("icono.gif");
		//Image miIcono = miPantalla.getImage("src/graficos/icono.gif");
		
		setIconImage(miIcono);
		
	}
	
}