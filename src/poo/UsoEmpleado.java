package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRH = new Jefatura("Octavio", 30000, 2006, 9,25);
		
		jefe_RRH.setIncentivo(2570);
		
		/*Empleado empleado1 = new Empleado("Octavio", 85000, 2014, 03, 17);
		Empleado empleado2 = new Empleado("Adanely", 100000, 2000, 05, 23);
		Empleado empleado3 = new Empleado("Luis", 105000, 1998, 10, 03);
		
		empleado1.aumentarSuelso(5);
		empleado2.aumentarSuelso(5);
		empleado3.aumentarSuelso(5);
		
		System.out.println("Nombre: " + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo() +
		                   " Fecha Alta: " + empleado1.getAltaContrato());
		System.out.println("Nombre: " + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo() +
                " Fecha Alta: " + empleado2.getAltaContrato());
		System.out.println("Nombre: " + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo() +
                " Fecha Alta: " + empleado3.getAltaContrato());*/
		
		Empleado [] misEmpleados = new Empleado[6];
		
		misEmpleados[0] = new Empleado("Paco Gomez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("Ana Lopez", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("Maria Martin", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Octavio");
		misEmpleados[4] = jefe_RRH;
		misEmpleados[5] = new Jefatura("Adanely Lopez", 90000, 2006, 8, 15);
		
		Jefatura jefaFinanzas = (Jefatura) misEmpleados[5];
		
		jefaFinanzas.setIncentivo(55000);
		/*for(int i = 0; i < 3; i++) {
			misEmpleados[i].aumentarSuelso(5);	
		}*/
		
		System.out.println(jefaFinanzas.tomarDecisiones("Dar más días de vacaciones a los empleados"));
		
		System.out.println("El jefe " + jefaFinanzas.getNombre() + " Tiene un bonus de " 
		                   + jefaFinanzas.setBounus(500));
		jefaFinanzas.setBounus(500);
		
		System.out.println(misEmpleados[3].getNombre() + " Tiene un bonus de " 
		               + misEmpleados[3].setBounus(200));
		
		
		for(Empleado e: misEmpleados) {
			e.aumentarSuelso(5);
		}
		
		/*for(int i = 0; i < 3; i++) {
			System.out.println("Nombre " + misEmpleados[i].getNombre()
					         + " Sueldo: " + misEmpleados[i].getSueldo()
					         + " Fecha de Alta: " + misEmpleados[i].getAltaContrato());
		}*/
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e: misEmpleados) {
			System.out.println("Nombre " + e.getNombre()
			         + " Sueldo: " + e.getSueldo()
			         + " Fecha de Alta: " + e.getAltaContrato());
		}
		
		
	}

}

class Empleado implements Comparable, Trabajadores{
	
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {
		
		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes -1, dia);
		altaContrato = calendario.getTime();
		
	}
	
	public Empleado (String nombre) {
		this(nombre, 30000, 2000, 01, 01);
	}
	
	
	public String getNombre() {
		return nombre;
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
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
	@Override
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado = (Empleado) miObjeto;
		if(this.sueldo < otroEmpleado.sueldo) {
			return -1;
		} 
		
		if(this.sueldo > otroEmpleado.sueldo) {
			return 1;
		}
		
		return 0;

	}

	@Override
	public double setBounus(double gratificacion) {
		
		return Trabajadores.bonusBase + gratificacion;
	}
}

class Jefatura extends Empleado implements Jefes{
	
    private double incentivo;
    
	public Jefatura(String nombre, double sueldo, int anio, int mes, int dia) {
		super(nombre, sueldo, anio, mes, dia);
	}
	
	public void setIncentivo(double b) {
		
		incentivo = b;
		
	}
	
	public double getSueldo() {
		
		double sueldoJefe = super.getSueldo();
		
		return sueldoJefe + incentivo;
	}

	@Override
	public String tomarDecisiones(String decision) {
		
		return "Un miembro de la direccion ha tomado la decisión de:" + decision;
	}
	
	public double setBounus(double gratificacion) {
		
		double prima = 2000;
		
		return Trabajadores.bonusBase + gratificacion + prima;
	}
	
}