import java.util.Scanner;

public class Main {
	private static IVehiculo vehiculo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		 // Usamos como delimitador el dos puntos, o bien cualquier
		 // espacio/fin de línea (el \\s)
		 sc.useDelimiter("[:\\s]");

		 // Le pedimos al usuario que escriba su nombre
		 System.out.print("Por favor, escriba su nombre: ");
		 
		 // Leer el nombre del usuario
		 String nombre = sc.nextLine();

		 // Obtenemos el nombre
		 System.out.println("Bienvenido a nuestro concesionario "+nombre+"\n");
		 
		 // Mostramos al usuario las opciones del menú
		 System.out.println("***** CONCESIONARIO JAVACAR ****\n"
		 		+ "* 1. Seat\n"
				+ "* 2. Ferrari \n"
				+"**********************\n");
		 
		 System.out.print("Indique qué coche desea probar: ");
		 int seleccionMenu = sc.nextInt();
		 
		 if(seleccionMenu == 1) {
			 vehiculo = new Seat();
		 } else {
			 vehiculo = new Ferrari();
		 }
		 
		 vehiculo.mostrarDeposito();
		 vehiculo.acelerar();
		 vehiculo.mostrarDeposito();
		 vehiculo.acelerar();
		 vehiculo.acelerar();
		 vehiculo.acelerar();
		 vehiculo.acelerar();
		 vehiculo.acelerar();
		 
		 
		 
		
	}

}
