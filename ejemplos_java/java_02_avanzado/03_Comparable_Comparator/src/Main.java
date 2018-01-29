import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona("Maria",21,1));
		personas.add(new Persona("Pepe",18,2));
		personas.add(new Persona("Ana",25,3));
		personas.add(new Persona("Juana",17,4));
		Collections.sort(personas,new OrdenarPersonasPorEdad());
		System.out.println("Personas ordenadas por orden natural (nombre): "+personas);
	}
}