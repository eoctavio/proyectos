package componentes;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MarcoSlider {

	public static void main(String[] args) {
		
		FrameSilder miMarco = new FrameSilder();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameSilder extends JFrame{
	
	public FrameSilder() {
		
		setBounds(550, 400, 550, 350);
		
		LaminaSlider miLamina = new LaminaSlider();
		add(miLamina);
		
		setVisible(true);
	}
}

class LaminaSlider extends JPanel{
	public LaminaSlider() {
		JSlider control = new JSlider(0, 100, 50);
		
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		control.setPaintLabels(true);
		control.setPaintTicks(true);
        control.setFont(new Font("Arial", Font.ITALIC, 12));
        
       // control.setSnapToTicks(true);
		add(control);
	}
}
