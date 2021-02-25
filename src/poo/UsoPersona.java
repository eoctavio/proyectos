package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		
		Persona [] lasPersonas = new Persona[2];
		
		lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
		lasPersonas[1] = new Alumno("Ana Lopez", "Biologia");
		
		for(Persona p : lasPersonas) {
			System.out.println(p.getNombre() + ", " + p.getDescripcion());
		}

	}
	
	

}

abstract class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract String getDescripcion();
	
}

class Empleado2 extends Persona{
	
	private double sueldo;
	private Date altaContrato;
	private int Id;
	
	public Empleado2(String nombre, double sueldo, int anio, int mes, int dia) {
		super(nombre);
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes -1, dia);
		altaContrato = calendario.getTime();
		
	}
	

	public double getSueldo() {
		return sueldo;
	}
	public Date getAltaContrato() {
		return altaContrato;
	}
	
	public void aumentarSuelso(double porcentaje) {
		
		double aumento = sueldo * (porcentaje / 100);
		
		sueldo += aumento;
		
	}
	
	@Override
	public String getDescripcion() {
		return "Este empleado tiene un Id= " + Id + " con un sueldo= " + sueldo;
	}

}

class Alumno extends Persona {
	
	private String carrera;
	
	public Alumno(String nombre, String carrera) {
		super(nombre);
		this.carrera = carrera;
	}

	@Override
	public String getDescripcion() {
		return "Este alumno está estudiando la carrera de " + carrera;
	}
	
	
	
}
