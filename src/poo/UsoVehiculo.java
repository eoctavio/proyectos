package poo;

import javax.swing.JOptionPane;

public class UsoVehiculo {
	
	public static void main(String[] args) {
		
		/*Coche miCoche = new Coche();
		
		miCoche.setColor(JOptionPane.showInputDialog("Introduce color"));
		
		
		System.out.println(miCoche.getDatosGenerales());
		
		System.out.println(miCoche.getColor());
		
		miCoche.seTieneAsientosCuero(JOptionPane.showInputDialog("Tiene asientos de piel"));
		
		System.out.println(miCoche.dimeAsientos());
		
		miCoche.configuraClimatizador(JOptionPane.showInputDialog("Tiene climatizador"));
		
		System.out.println(miCoche.getClimatizador());
		
		System.out.println("El precio final del coche es: " +miCoche.getPrecioCoche()); */
		
		Coche miCoche1 = new Coche();
		
		miCoche1.setColor("Rojo");
		
		Furgoneta miFurgoneta1 = new Furgoneta(7, 580);
		
		miFurgoneta1.setColor("Azul");
		miFurgoneta1.seTieneAsientosCuero("si");
		miFurgoneta1.configuraClimatizador("si");
		
		System.out.println(miCoche1.getDatosGenerales() + "Color " + miCoche1.getColor());
		
		System.out.println(miFurgoneta1.getDatosGenerales() + " " + miFurgoneta1.getDatosFurgoneta());
		
	}

}
