import java.util.Scanner;

public class UsoTallas {
	
	enum Talla {
		
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANMDE("XL");
		private String abreviatura;
		
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String getAbreviatura() {
			return this.abreviatura;
		}
	}
	
	public static void main(String[] args) {
		
       Scanner entrada = new Scanner(System.in);
       
       System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
       
       String entradaDatos = entrada.next().toUpperCase();
       
       Talla laTalla = Enum.valueOf(Talla.class, entradaDatos);
       
       System.out.println("Talla " + laTalla);
       
       System.out.println("Abreviatura " + laTalla.getAbreviatura());
		
	}

}
