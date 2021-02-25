package poo;

public class Coche {
	
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	
	private String color;
	private int pesoTotal;
	private boolean asientosCuero, climatizador;
	
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		pesoPlataforma = 500;
	}
	
	public String getDatosGenerales() {
		return "La plataforma del vehículo tiene " + ruedas + " ruedas " +
	           " mide " + largo/100 + " metros con un ancho de " + ancho + 
	           " cm y un peso de plataforma de " + pesoPlataforma + " kg";
	}
	
	public String getLrgo() {
		return "El largo del coche es " + largo;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return "El color del coche es: " + color;
	}
	
	public void seTieneAsientosCuero(String asientosCuero) {
		if(asientosCuero.equalsIgnoreCase("si")) {
			this.asientosCuero = true;
		} else {
			this.asientosCuero = false;
		}
		
	}
	
	public String dimeAsientos() {
		if(asientosCuero) {
			return "El coche tiene asientos de cuero";
		} else {
			return "El coche tiene asientos de serie";
		}
	}
	
	public void configuraClimatizador(String climatizador) {
		if(climatizador.equalsIgnoreCase("si") ) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}
	
	public String getClimatizador() {
		if(climatizador) {
			return "El coche incorpora climatizador";
		} else {
			return "El coche lleva aire acondicionado";
		}
	}
	
	public String getPesoCoche() {
		
		int pesoCarroceria = 500;
		pesoTotal = pesoPlataforma + pesoCarroceria;
		if(asientosCuero) {
			pesoTotal = pesoTotal + 50;
		}
		if(climatizador) {
			pesoTotal = pesoTotal + 20;
		}
		
		return "El peso del coche es " + pesoTotal;
		
	}
	
	public int getPrecioCoche() {
		int precioFInal = 10000;
		
		if(asientosCuero) {
			precioFInal += 2000;
		}
		if(climatizador) {
			precioFInal += 1500;
		}
		
		return precioFInal;
	}

}
